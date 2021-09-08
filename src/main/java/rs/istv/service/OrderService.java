package rs.istv.service;

import java.util.Collection;
import java.util.List;

import rs.istv.dto.OrderDTO;
import rs.istv.dto.OrderDTOForAndroid;
import rs.istv.entity.*;

public  interface OrderService {

	List<Order> findAll();

	Order save(Order order);

	Order update(Order order);

	Order findById(Integer orderId);

	void deleteById(Integer orderId);

    Integer calculateTotal(Integer orderId);

    Order toggleOrderStatus(Integer orderId, String status);

	List<OrderProduct> getAllOrderProductsByOrderId(Integer orderId);

	List<Order> getAllByBuyerId(Integer buyerId);

	Order saveOrderDTOForBuyer(Buyer buyerId, OrderDTO orderDTO);

    Order saveOrderDTOAndroid(OrderDTOForAndroid orderDTO);
}