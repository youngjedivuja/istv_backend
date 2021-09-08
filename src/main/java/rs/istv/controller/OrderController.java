package rs.istv.controller;

import java.util.List;

import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import rs.istv.dto.OrderDTO;
import rs.istv.dto.OrderDTOForAndroid;
import rs.istv.entity.*;
import rs.istv.security.annotation.PermitAll;
import rs.istv.security.annotation.role.RequireBuyer;
import rs.istv.service.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
@PermitAll
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> getAll() {
        return ResponseEntity.ok(orderService.findAll());
    }

    @GetMapping("/forBuyer")
    public ResponseEntity<List<Order>> getAllByBuyerId(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(orderService.getAllByBuyerId(user.getBuyerId().getId()));
    }

    @PostMapping("/saveOrderDTO")
    public ResponseEntity<Order> saveOrderDTO(@AuthenticationPrincipal User user, @RequestBody OrderDTO orderDTO) {
        return ResponseEntity.ok(orderService.saveOrderDTOForBuyer(user.getBuyerId(), orderDTO));
    }

    @PutMapping("/dto")
    public ResponseEntity<Order> saveOrder( @RequestBody OrderDTOForAndroid orderDTO) {
        return ResponseEntity.ok(orderService.saveOrderDTOAndroid( orderDTO));
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

    @GetMapping("/{orderId}/calculateTotal")
    public ResponseEntity<Integer> calculateTotal(@PathVariable Integer orderId) {
        return ResponseEntity.ok(orderService.calculateTotal(orderId));
    }

    @GetMapping("/{orderId}/toggleOrderStatus/{status}")
    public ResponseEntity<Order> toggleOrderStatus(@PathVariable Integer orderId, @PathVariable String status) {
        return ResponseEntity.ok(orderService.toggleOrderStatus(orderId, status));
    }

    @GetMapping("/{orderId}/orderproducts")
    public ResponseEntity<List<OrderProduct>> getAllOrderProductsByOrderId(@PathVariable Integer orderId) {
        return ResponseEntity.ok(orderService.getAllOrderProductsByOrderId(orderId));
    }

}

