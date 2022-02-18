package com.apolis.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.apolis.model.Employee;
import com.apolis.repository.EmployeeRepository;

@Component
public class EmployeeRunner implements CommandLineRunner {

	@Autowired
	EmployeeRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		repository.save(new Employee("John", 21000,"john@gmail.com"));
		repository.save(new Employee("Tom", 57000,"test@gmail.com"));
		repository.save(new Employee("Ron", 31000,"test2@gmail.com"));
	}

}
