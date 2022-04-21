package com.apolis.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apolis.exception.InputMissingException;
import com.apolis.model.Employee;
import com.apolis.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	public Employee saveEmployeeData(Employee employee) {
		if(employee.getName().length() == 0 || employee.getName().isEmpty()) {
			throw new InputMissingException("701", "Input detail is missing.");
		}
		return repository.save(employee);
	}

	public List<Employee> getAllEmployees() {
		List<Employee> employeeList = repository.getAllEmployee();
		return employeeList;
	}

	public Employee getEmployeeById(Long id) {
			Optional<Employee> employee = repository.getEmployeeById(id);
			return employee.get();
	}

	public void  deleteEmployee(Long id) {
		repository.deleteById(id);

	}
	public Employee updateEmployeeData(Employee employee) {
		Optional<Employee> optional = repository.findById(employee.getId());
		if(optional.isPresent())
		{
			Employee newEntity = optional.get();
			newEntity.setEmail(employee.getEmail());
			newEntity.setName(employee.getName());
			newEntity.setSalary(employee.getSalary());
			newEntity = repository.save(newEntity);
			return employee;
		}
		return null;
	}

}
