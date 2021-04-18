package rs.istv.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import rs.istv.entity.Employee;
import rs.istv.entity.Person;
import rs.istv.entity.User;
import rs.istv.repository.EmployeeRepository;
import rs.istv.repository.PersonRepository;
import rs.istv.repository.UserRepository;
import rs.istv.service.impl.EmployeeServiceImpl;
import rs.istv.service.impl.PersonServiceImpl;
import rs.istv.service.impl.UserServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @Mock
    EmployeeRepository employeeRepositoryMock;
    @Mock
    PersonRepository personRepositoryMock;
    @Mock
    UserRepository userRepositoryMock;

    @InjectMocks
    EmployeeServiceImpl employeeService;
    @InjectMocks
    PersonServiceImpl personService;
    @InjectMocks
    UserServiceImpl userService;

    //BDD testing

    //Testing update record status - deactivating employee
    @Test
    void updateRecordStatus() {
        //given
        Employee employee = new Employee();
        employee.setRecordStatus(0);
        given(employeeRepositoryMock.save(any(Employee.class))).willReturn(employee);

        //when
        Employee updatedEmployee = employeeService.save(new Employee());

        //then
        then(employeeRepositoryMock).should().save(any(Employee.class));
        assertThat(updatedEmployee).isNotNull();
    }

    @Test
    void saveUserPersonEmployeeDTO() {
        //given
        Person person = new Person();
        given(personRepositoryMock.save(any(Person.class))).willReturn(person);

        User user = new User();
        given(userRepositoryMock.save(any(User.class))).willReturn(user);

        Employee employee = new Employee();
        given(employeeRepositoryMock.save(any(Employee.class))).willReturn(employee);

        //when
        Employee savedEmployee = employeeService.save(new Employee());
        Person savedPerson = personService.save(new Person());
        User savedUser = userService.save(new User());

        //then
        then(personRepositoryMock).should().save(any(Person.class));
        assertThat(savedPerson).isNotNull();

        then(userRepositoryMock).should().save(any(User.class));
        assertThat(savedUser).isNotNull();

        then(employeeRepositoryMock).should().save(any(Employee.class));
        assertThat(savedEmployee).isNotNull();
    }
}