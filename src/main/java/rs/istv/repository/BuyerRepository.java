package rs.istv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.istv.entity.Buyer;

@Repository
public  interface BuyerRepository extends JpaRepository<Buyer, Integer> {

}