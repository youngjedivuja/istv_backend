package rs.istv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.istv.entity.OrderProduct;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Integer> {
}
