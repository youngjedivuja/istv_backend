package rs.istv.service.impl;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import rs.istv.dto.UserPersonEmployeeDTO;
import rs.istv.entity.*;
import rs.istv.repository.EmployeeRepository;
import rs.istv.repository.PersonRepository;
import rs.istv.repository.UserRepository;
import rs.istv.service.EmployeeService;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Integer employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new NoSuchElementException("EmployeeService.notFound"));
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(Integer employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    @Override
    public Employee updateRecordStatus(Integer employeeId) {
        Employee employee = findById(employeeId);
        employee.setRecordStatus(employee.getRecordStatus() > 0 ? 0 : 1);
        return employeeRepository.save(employee);
    }

    @Override
    public Employee saveUserPersonEmployeeDTO(UserPersonEmployeeDTO userPersonEmployeeDTO) {
        Person person = new Person();
        User user = new User();
        Employee employee = new Employee();
        if (personRepository.findByUnid(userPersonEmployeeDTO.getUnid()).isPresent()) {
            person = personRepository.findByUnid(userPersonEmployeeDTO.getUnid()).get();
            user = userRepository.findByUsername(userPersonEmployeeDTO.getUsername()).get();
            employee = employeeRepository.findByUserId(user).get();
        }
        person.setBirthDate(userPersonEmployeeDTO.getBirthDate());
        person.setGender(userPersonEmployeeDTO.getGender());
        person.setName(userPersonEmployeeDTO.getName());
        person.setSurname(userPersonEmployeeDTO.getSurname());
        person.setUnid(userPersonEmployeeDTO.getUnid());
        person.setPin(userPersonEmployeeDTO.getPin());
        person = personRepository.save(person);

        user.setPersonId(person);
        user.setUsername(userPersonEmployeeDTO.getUsername());
        user.setEmail(userPersonEmployeeDTO.getEmail());
        user.setPassword(passwordEncoder.encode(user.getUsername() + "." + person.getPin().substring(0, 2)));
        user = userRepository.save(user);

        employee.setUserId(user);
        employee.setBank(userPersonEmployeeDTO.getBank());
        employee.setPosition(userPersonEmployeeDTO.getPosition());
        employee.setEmploymendStartDate(userPersonEmployeeDTO.getEmploymentStartDate());
        return employeeRepository.save(employee);
    }


}