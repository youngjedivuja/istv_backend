package rs.istv.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.*;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import rs.istv.entity.*;
import rs.istv.repository.UserRepository;
import rs.istv.service.UserService;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class UserServiceImpl implements UserService {
	private final UserRepository userRepository;

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findById(Integer userId) {
		return userRepository.findById(userId)
				.orElseThrow(() -> new NoSuchElementException("UserService.notFound"));
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public User update(User user) {
		return userRepository.save(user);
	}

	@Override
	public void deleteById(Integer userId) {
		userRepository.deleteById(userId);
	}

    @Override
    public User findByUsername(String username) {
		return userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("UserService.usernameNotFound"));
    }


}