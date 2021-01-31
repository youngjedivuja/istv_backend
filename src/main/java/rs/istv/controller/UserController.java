package rs.istv.controller;

import java.util.List;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.istv.entity.*;
import rs.istv.service.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;

	@GetMapping
	public ResponseEntity<List<User>> getAll() {
		return ResponseEntity.ok(userService.findAll());
	}

	@GetMapping("/{userId}")
	public ResponseEntity<User> getById(@PathVariable Integer userId) {
		return ResponseEntity.ok(userService.findById(userId));
	}

	@PostMapping
	public ResponseEntity<User> save(@RequestBody User user) {
		return ResponseEntity.status(201).body(userService.save(user));
	}

	@PutMapping
	public ResponseEntity<User> update(@RequestBody User user) {
		return ResponseEntity.ok(userService.update(user));
	}

	@DeleteMapping("/{userId}")
	public void deleteById(@PathVariable Integer userId) {
		userService.deleteById(userId);
	}

}

