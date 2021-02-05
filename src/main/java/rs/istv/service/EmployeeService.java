package rs.istv.service;

import java.util.Collection;
import java.util.List;

import rs.istv.dto.UserPersonEmployeeDTO;
import rs.istv.entity.*;

public  interface EmployeeService {

	List<Employee> findAll();

	Employee save(Employee employee);

	Employee update(Employee employee);

	Employee findById(Integer employeeId);

	void deleteById(Integer employeeId);

    Employee updateRecordStatus(Integer employeeId);

    Employee saveUserPersonEmployeeDTO(UserPersonEmployeeDTO userPersonEmployeeDTO);
}