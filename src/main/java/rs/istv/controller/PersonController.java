package rs.istv.controller;

import java.util.List;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.istv.entity.*;
import rs.istv.security.annotation.role.RequireAdmin;
import rs.istv.service.*;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
@RequireAdmin
public class PersonController {
	private final PersonService personService;

	@GetMapping
	public ResponseEntity<List<Person>> getAll() {
		return ResponseEntity.ok(personService.findAll());
	}

	@GetMapping("/{personId}")
	public ResponseEntity<Person> getById(@PathVariable Integer personId) {
		return ResponseEntity.ok(personService.findById(personId));
	}

	@PostMapping
	public ResponseEntity<Person> save(@RequestBody Person person) {
		return ResponseEntity.status(201).body(personService.save(person));
	}

	@PutMapping
	public ResponseEntity<Person> update(@RequestBody Person person) {
		return ResponseEntity.ok(personService.update(person));
	}

	@DeleteMapping("/{personId}")
	public void deleteById(@PathVariable Integer personId) {
		personService.deleteById(personId);
	}

}

