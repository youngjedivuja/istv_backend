package rs.istv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.istv.entity.Person;

import java.util.Optional;

@Repository
public  interface PersonRepository extends JpaRepository<Person, Integer> {
    Optional<Person> findByUnid(String unid);
}