package rs.istv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.istv.entity.Person;

@Repository
public  interface PersonRepository extends JpaRepository<Person, Integer> {

}