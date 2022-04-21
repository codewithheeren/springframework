package com.apolis.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apolis.exception.RecordNotFoundException;
import com.apolis.exception.ServiceException;
import com.apolis.model.Employee;
import com.apolis.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	public Employee saveEmployeeData(Employee employee) {
		Employee savedEmployee;
		if(employee.getName().length() == 0 || employee.getName().isEmpty()) {
			throw new ServiceException("701", "Employee name can not be blank.");
		}
		try {
			  savedEmployee = repository.save(employee);
		}
		catch(Exception ex)
		{
			throw new ServiceException("702", "Something went wrong inside service layer :"+ex.getMessage());
		}
		return savedEmployee;
	}

	public List<Employee> getAllEmployees() {
		List<Employee> employeeList =null;
		try {
		employeeList = repository.findAll();
		}
		catch(Exception ex)
		{
			throw new ServiceException("703","Something went wrong inside service layer :"+ ex.getMessage());
		}
		if(employeeList.isEmpty())
		{
			throw new ServiceException("704", "Employee list is empty.");
		}
		
		return employeeList;
	}

	public Employee getEmployeeById(Long id) {
		try {
		Optional<Employee> employee = repository.findById(id);
		return employee.get();
		}
		catch(NoSuchElementException ex)
		{
			throw new ServiceException("705","Employee id does not exist. :"+ ex.getMessage());
		}
		catch(Exception ex)
		{
			throw new ServiceException("706","Something went wrong inside service layer :"+ ex.getMessage());
		}	
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
