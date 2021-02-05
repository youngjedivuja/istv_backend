package rs.istv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.istv.entity.Order;

import java.util.List;
import java.util.Optional;

@Repository
public  interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findAllByBuyerId_Id(Integer buyerId);
}