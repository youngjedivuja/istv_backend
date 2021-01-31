package rs.istv.security;


import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import rs.istv.entity.User;
import rs.istv.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import io.jsonwebtoken.*;

@Component
public class JwtProvider {

    private final UserService userService;
    @Value("${jwt.secret-key:secret}")
    private String secretKey;
    @Value("${jwt.expire-length:7200000}")
    private long validityInMilliseconds;

    public JwtProvider(UserService userService) {
        this.userService = userService;
    }

    public String createToken(String username, Collection<? extends GrantedAuthority> authorities) {
        Claims claims = Jwts.claims().setSubject(username);
        claims.put("roles", authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()));
        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public Authentication getAuthentication(String token) {
        User user = this.userService.findByUsername(getUsername(token));
        return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
    }

    public String getUsername(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    public String resolveToken(HttpServletRequest req) {
        String bearerToken = req.getHeader(SecurityConstants.HEADER_STRING);

        if (bearerToken == null || !bearerToken.startsWith(SecurityConstants.TOKEN_PREFIX)) {
            return null;
        }

        return bearerToken.substring(SecurityConstants.TOKEN_PREFIX.length());
    }

    public boolean validateToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return !claims.getBody().getExpiration().before(new Date());
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
}
