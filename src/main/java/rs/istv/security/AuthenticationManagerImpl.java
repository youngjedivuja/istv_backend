package rs.istv.security;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import rs.istv.entity.User;
import rs.istv.repository.UserRepository;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
@Primary
public class AuthenticationManagerImpl implements AuthenticationManager {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final Environment env;

    @Value("${spring.security.disabled:false}")
    private String securityDisabled;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new BadCredentialsException("Invalid username or password"));

        if (!user.isEnabled())
            throw new DisabledException("Account disabled");

        // dev authentication override
        if (Boolean.parseBoolean(securityDisabled) || Arrays.asList(env.getActiveProfiles()).contains("dev")) {
            return new UsernamePasswordAuthenticationToken(username, null, user.getAuthorities());
        }

        if (user.getPassword() == null) {
            user.setPassword(passwordEncoder.encode(user.getUsername() + "123"));
            userRepository.save(user);
        }

        if (password == null || !passwordEncoder.matches(password, user.getPassword()))
            throw new BadCredentialsException("Invalid username or password");

        return new UsernamePasswordAuthenticationToken(username, null, user.getAuthorities());
    }
}
