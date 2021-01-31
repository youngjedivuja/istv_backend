package rs.istv.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.*;
import org.springframework.stereotype.Service;
import rs.istv.entity.*;
import rs.istv.repository.PersonRepository;
import rs.istv.service.PersonService;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class PersonServiceImpl implements PersonService {
	private final PersonRepository personRepository;

	@Override
	public List<Person> findAll() {
		return personRepository.findAll();
	}

	@Override
	public Person findById(Integer personId) {
		return personRepository.findById(personId)
				.orElseThrow(() -> new NoSuchElementException("PersonService.notFound"));
	}

	@Override
	public Person save(Person person) {
		return personRepository.save(person);
	}

	@Override
	public Person update(Person person) {
		return personRepository.save(person);
	}

	@Override
	public void deleteById(Integer personId) {
		personRepository.deleteById(personId);
	}


}