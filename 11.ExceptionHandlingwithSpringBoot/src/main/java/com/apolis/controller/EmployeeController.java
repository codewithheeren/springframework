package com.apolis.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apolis.exception.ControllerException;
import com.apolis.exception.RecordNotFoundException;
import com.apolis.exception.ServiceException;
import com.apolis.model.Employee;
import com.apolis.service.EmployeeService;

@RestController
@RequestMapping("/emmanage")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@PostMapping("/addemployee")
	public ResponseEntity<?> saveEmployee(@RequestBody Employee employee) {
		try {
		Employee responseEmployee = service.saveEmployeeData(employee);
		return new ResponseEntity<Employee>(responseEmployee,HttpStatus.CREATED);
		}
		catch(ServiceException se)
		{
			ControllerException controllerException = new ControllerException(se.getCode(),se.getMessage());
			return new ResponseEntity<ControllerException>(controllerException,HttpStatus.BAD_REQUEST);
		}
		catch(Exception e)
		{
			ControllerException controllerException = new ControllerException("750","something went wrong inside controller.");
			return new ResponseEntity<ControllerException>(controllerException,HttpStatus.BAD_REQUEST);
		}
		}

	@GetMapping("/getall")
	public ResponseEntity<List<Employee>> getAllEmployees() throws Exception {
		List<Employee> employees = service.getAllEmployees();
		return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		Employee employee =  service.getEmployeeById(id);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable Long id)  {
		service.deleteEmployee(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		Employee responseEmployee = service.updateEmployeeData(employee);
		return new ResponseEntity<Employee>(responseEmployee,HttpStatus.CREATED);
	}
	
}
