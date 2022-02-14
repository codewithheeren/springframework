package com.apolis.sartapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.apolis.sartapp.entity.Student;

@SpringBootApplication
//@ComponentScan("com.apolis")
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		Student student  = (Student)context.getBean("student");
		System.out.println(student);
	}

}
