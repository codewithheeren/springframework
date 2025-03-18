## Microservices1 - RestTemplate Implementation
Codebase - https://github.com/codewithheeren/workspace/tree/main/spring-boot-microservices/1.microservices01
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
	<artifactId>microservices01</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>microservices01</name>
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
server.port = 8181
```
---
### MicroservicesApplication.java
```java
package com.codewithheeren.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import com.codewithheeren.microservices.service.EmployeeService;
/**
 * This class implements Rest Template.
 * Microservice 1 is client class which is consuming Microservice 2.
 * This microservice 1 have one service class(EmployeeService) .
 * Employee Service class make call to Microservice 2 controller rest endpoints and consume those rest end points.
 * @author Heeren
 * @version 1.0
 */
@SpringBootApplication
public class MicroservicesApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MicroservicesApplication.class, args);
        EmployeeService service = context.getBean(EmployeeService.class);

        System.out.println("Microservice-1 ...");

        // Step 1: Create a new employee
        service.createEmployee();

        // Step 2: Get newly created employee
        service.getEmployeeById(3L);

        // Step 3: Get all employees
        service.getAllEmployees();

        // Step 4: Update employee
        service.updateEmployee(3L);

        // Step 5: Delete employee
        service.deleteEmployee(3L);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
```
---
### EmployeeDTO.java
```java
package com.codewithheeren.microservices.entity;

public class EmployeeDTO {

	private long id;
	private String firstName;
	private String lastName;
	private String emailId;

	public EmployeeDTO() {
		super();
	}

	public EmployeeDTO(long id, String firstName, String lastName, String emailId) {
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
### EmployeeService.java
```java
package com.codewithheeren.microservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.codewithheeren.microservices.entity.EmployeeDTO;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService {

	@Autowired
    private final RestTemplate restTemplate = null;
    private static final String BASE_URL = "http://localhost:8080/api/v1/employees";

    public void getAllEmployees() {
        ResponseEntity<String> response = restTemplate.exchange(
            BASE_URL, HttpMethod.GET, createHttpEntity(), String.class);

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response: " + response.getBody());
    }

    public EmployeeDTO getEmployeeById(Long id) {
        String url = BASE_URL + "/{id}";
        ResponseEntity<EmployeeDTO> response = restTemplate.exchange(
            url, HttpMethod.GET, createHttpEntity(), EmployeeDTO.class, id);

        EmployeeDTO employee = response.getBody();
        System.out.println("Fetched Employee: " + employee);
        return employee;
    }

    public void createEmployee() {
        EmployeeDTO newEmployee = new EmployeeDTO(3L, "Tom", "Z.", "tom@gmail.com");
        ResponseEntity<EmployeeDTO> response = restTemplate.postForEntity(
            BASE_URL, newEmployee, EmployeeDTO.class);

        System.out.println("Employee Created: " + response.getBody());
    }

    public void updateEmployee(Long id) {
        String url = BASE_URL + "/{id}";
        EmployeeDTO updatedEmployee = new EmployeeDTO(id, "Updated", "Name", "updated@gmail.com");
        restTemplate.put(url, updatedEmployee, id);
        System.out.println("Employee Updated: " + updatedEmployee);
    }

    public void deleteEmployee(Long id) {
        String url = BASE_URL + "/{id}";
        restTemplate.delete(url, id);
        System.out.println("Employee Deleted with ID: " + id);
    }

    private HttpEntity<String> createHttpEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        return new HttpEntity<>(headers);
    }
}

```
---

