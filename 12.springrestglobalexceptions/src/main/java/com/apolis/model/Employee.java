package com.apolis.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class Employee {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private int salary;
	private String email;
	public Employee(String name, int salary, String email) {
		super();
		this.name = name;
		this.salary = salary;
		this.email = email;
	}
	public Employee() {
		super();
	}
}
