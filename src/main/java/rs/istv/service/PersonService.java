package rs.istv.service;

import java.util.Collection;
import java.util.List;
import rs.istv.entity.*;

public  interface PersonService {

	List<Person> findAll();

	Person save(Person person);

	Person update(Person person);

	Person findById(Integer personId);

	void deleteById(Integer personId);

}