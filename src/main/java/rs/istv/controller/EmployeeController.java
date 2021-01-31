package rs.istv.controller;

import java.util.List;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.istv.entity.*;
import rs.istv.service.*;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {
	private final EmployeeService employeeService;

	@GetMapping
	public ResponseEntity<List<Employee>> getAll() {
		return ResponseEntity.ok(employeeService.findAll());
	}

	@GetMapping("/{employeeId}")
	public ResponseEntity<Employee> getById(@PathVariable Integer employeeId) {
		return ResponseEntity.ok(employeeService.findById(employeeId));
	}

	@PostMapping
	public ResponseEntity<Employee> save(@RequestBody Employee employee) {
		return ResponseEntity.status(201).body(employeeService.save(employee));
	}

	@PutMapping
	public ResponseEntity<Employee> update(@RequestBody Employee employee) {
		return ResponseEntity.ok(employeeService.update(employee));
	}

	@DeleteMapping("/{employeeId}")
	public void deleteById(@PathVariable Integer employeeId) {
		employeeService.deleteById(employeeId);
	}

}

