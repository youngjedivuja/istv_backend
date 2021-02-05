package rs.istv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.istv.entity.Employee;
import rs.istv.entity.User;

import java.util.Optional;

@Repository
public  interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Optional<Employee> findByUserId(User user);
}