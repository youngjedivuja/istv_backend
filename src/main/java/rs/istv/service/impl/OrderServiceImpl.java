package rs.istv.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.*;
import org.springframework.stereotype.Service;
import rs.istv.entity.*;
import rs.istv.repository.OrderRepository;
import rs.istv.service.OrderService;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class OrderServiceImpl implements OrderService {
	private final OrderRepository orderRepository;

	@Override
	public List<Order> findAll() {
		return orderRepository.findAll();
	}

	@Override
	public Order findById(Integer orderId) {
		return orderRepository.findById(orderId)
				.orElseThrow(() -> new NoSuchElementException("OrderService.notFound"));
	}

	@Override
	public Order save(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public Order update(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public void deleteById(Integer orderId) {
		orderRepository.deleteById(orderId);
	}


}