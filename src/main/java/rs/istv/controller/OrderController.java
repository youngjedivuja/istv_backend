package rs.istv.controller;

import java.util.List;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.istv.entity.*;
import rs.istv.service.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
	private final OrderService orderService;

	@GetMapping
	public ResponseEntity<List<Order>> getAll() {
		return ResponseEntity.ok(orderService.findAll());
	}

	@GetMapping("/{orderId}")
	public ResponseEntity<Order> getById(@PathVariable Integer orderId) {
		return ResponseEntity.ok(orderService.findById(orderId));
	}

	@PostMapping
	public ResponseEntity<Order> save(@RequestBody Order order) {
		return ResponseEntity.status(201).body(orderService.save(order));
	}

	@PutMapping
	public ResponseEntity<Order> update(@RequestBody Order order) {
		return ResponseEntity.ok(orderService.update(order));
	}

	@DeleteMapping("/{orderId}")
	public void deleteById(@PathVariable Integer orderId) {
		orderService.deleteById(orderId);
	}

}

