package rs.istv.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.*;
import org.springframework.stereotype.Service;
import rs.istv.dto.OrderDTO;
import rs.istv.dto.OrderDTOForAndroid;
import rs.istv.entity.*;
import rs.istv.repository.OrderProductRepository;
import rs.istv.repository.OrderRepository;
import rs.istv.service.OrderService;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class OrderServiceImpl implements OrderService {
	private final OrderRepository orderRepository;
	private final OrderProductRepository orderProductRepository;

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

	@Override
	public Integer calculateTotal(Integer orderId) {
		int total = 0;
		Order order = findById(orderId);
		for(OrderProduct orderProduct : order.getOrderProducts()){
			total+= orderProduct.getProduct().getPrice() * orderProduct.getQuantity();
		}
		return total;
	}

	@Override
	public Order toggleOrderStatus(Integer orderId, String status) {
		Order order = findById(orderId);
		order.setOrderStatus(status);
		return orderRepository.save(order);
	}

	@Override
	public List<OrderProduct> getAllOrderProductsByOrderId(Integer orderId) {
		return findById(orderId).getOrderProducts();
	}

	@Override
	public List<Order> getAllByBuyerId(Integer buyerId) {
		return orderRepository.findAllByBuyerId_Id(buyerId);
	}

	@Override
	public Order saveOrderDTOForBuyer(Buyer buyerId, OrderDTO orderDTO) {
		Order order = new Order();
		order.setOrderStatus("Na čekanju");
		order.setBuyerId(buyerId);
		order.setDeliveryAddress(orderDTO.getDeliveryAddress());
		order = orderRepository.save(order);
		for(Product product : orderDTO.getProducts()){
			OrderProduct orderProduct = new OrderProduct();
			orderProduct.setOrder(order);
			orderProduct.setProduct(product);
			orderProduct.setQuantity(4);
			orderProductRepository.save(orderProduct);
		}
		return order;
	}

	@Override
	public Order saveOrderDTOAndroid(OrderDTOForAndroid orderDTO) {
		Order order = findById(orderDTO.getOrderId());
		order.setDeliveryAddress(orderDTO.getDeliveryAddress());
		order.setOrderStatus(orderDTO.getOrderStatus());
		return save(order);
	}


}