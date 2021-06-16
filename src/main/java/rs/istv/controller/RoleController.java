package rs.istv.controller;

import java.util.List;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.istv.entity.*;
import rs.istv.security.annotation.role.RequireAdmin;
import rs.istv.service.*;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
@RequireAdmin
public class RoleController {
	private final RoleService roleService;

	@GetMapping
	public ResponseEntity<List<Role>> getAll() {
		return ResponseEntity.ok(roleService.findAll());
	}

	@GetMapping("/{roleId}")
	public ResponseEntity<Role> getById(@PathVariable Integer roleId) {
		return ResponseEntity.ok(roleService.findById(roleId));
	}

	@PostMapping
	public ResponseEntity<Role> save(@RequestBody Role role) {
		return ResponseEntity.status(201).body(roleService.save(role));
	}

	@PutMapping
	public ResponseEntity<Role> update(@RequestBody Role role) {
		return ResponseEntity.ok(roleService.update(role));
	}

	@DeleteMapping("/{roleId}")
	public void deleteById(@PathVariable Integer roleId) {
		roleService.deleteById(roleId);
	}

}

