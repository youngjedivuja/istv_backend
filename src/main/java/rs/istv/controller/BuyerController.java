package rs.istv.controller;

import java.util.List;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.istv.entity.*;
import rs.istv.security.annotation.role.RequireAdmin;
import rs.istv.service.*;

@RestController
@RequestMapping("/buyers")
@RequiredArgsConstructor
@RequireAdmin
public class BuyerController {
	private final BuyerService buyerService;

	@GetMapping
	public ResponseEntity<List<Buyer>> getAll() {
		return ResponseEntity.ok(buyerService.findAll());
	}

	@GetMapping("/{buyerId}")
	public ResponseEntity<Buyer> getById(@PathVariable Integer buyerId) {
		return ResponseEntity.ok(buyerService.findById(buyerId));
	}

	@PostMapping
	public ResponseEntity<Buyer> save(@RequestBody Buyer buyer) {
		return ResponseEntity.status(201).body(buyerService.save(buyer));
	}

	@PutMapping
	public ResponseEntity<Buyer> update(@RequestBody Buyer buyer) {
		return ResponseEntity.ok(buyerService.update(buyer));
	}

	@DeleteMapping("/{buyerId}")
	public void deleteById(@PathVariable Integer buyerId) {
		buyerService.deleteById(buyerId);
	}

}

