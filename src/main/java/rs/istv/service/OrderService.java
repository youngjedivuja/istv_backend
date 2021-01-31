package rs.istv.service;

import java.util.Collection;
import java.util.List;
import rs.istv.entity.*;

public  interface OrderService {

	List<Order> findAll();

	Order save(Order order);

	Order update(Order order);

	Order findById(Integer orderId);

	void deleteById(Integer orderId);

}