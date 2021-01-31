package rs.istv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.istv.entity.User;

@Repository
public  interface UserRepository extends JpaRepository<User, Integer> {

}