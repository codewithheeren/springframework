## Microservices2 - RestTemplate Implementation
Codebase - https://github.com/codewithheeren/workspace/tree/main/spring-boot-microservices/2.microservices02
### pom.xml 
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.5.3</version>
		<relativePath />
	</parent>
	<groupId>com.codewithheeren</groupId>
	<artifactId>microservices02</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>microservices02</name>
	<description>Demo project for Spring Boot</description>
	<properties>
		<java.version>1.8</java.version>
		<maven-jar-plugin.version>3.1.1</maven-jar-plugin.version>
	</properties>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>
	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>
</project>
```
---
### application.properties 
```properties
server.port = 8080
```
---
### Microservices02Application.java
```java
package com.codewithheern.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
/**
 * This class is a service provider class.
 * Microservice 2 is exposing rest endpoints.
 * This microservice 1 have one service class(EmployeeService) .
 * @author Heeren
 * @version 1.0
 */
@SpringBootApplication
@ComponentScan("com.codewithheeren")
public class Microservices02Application {

	public static void main(String[] args) {
		SpringApplication.run(Microservices02Application.class, args);
		System.out.println("Microservice-2 ...");
	}

}

```
---
### Employee.java
```java
package com.codewithheeren.microservices.entity;

public class Employee {

	private long id;
	private String firstName;
	private String lastName;
	private String emailId;

	public Employee(long id, String firstName, String lastName, String emailId) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
				+ "]";
	}
}
```
---
### EmployeeController.java
```java
package com.codewithheeren.microservices.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.codewithheeren.microservices.entity.Employee;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

	private final List<Employee> employees = new ArrayList<>();

	public EmployeeController() {
		employees.add(new Employee(1, "Heeren", "S.", "heeren@gmail.com"));
		employees.add(new Employee(2, "Ravi", "Kumar", "ravi@gmail.com"));
	}

	@GetMapping
	public List<Employee> getAllEmployees() {
		System.out.println("Microservice2 getAllEmployees(..) invoked");
		return employees;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		System.out.println("Microservice2 getEmployeeById(..) invoked with Id - " + id);
		Optional<Employee> employee = employees.stream().filter(emp -> emp.getId() == id).findFirst();

		return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		System.out.println("Microservice2 createEmployee(..) invoked with employee - " + employee);
		employees.add(employee);
		return new ResponseEntity<>(employee, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
		System.out.println("Microservice2 updateEmployee(..) invoked");

		for (int i = 0; i < employees.size(); i++) {
			if (employees.get(i).getId() == id) {
				employees.set(i, updatedEmployee);
				return ResponseEntity.ok(updatedEmployee);
			}
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
		System.out.println("Microservice2 deleteEmployee(..) invoked with ID: " + id);
		if (employees.removeIf(emp -> emp.getId() == id)) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}

```
---

