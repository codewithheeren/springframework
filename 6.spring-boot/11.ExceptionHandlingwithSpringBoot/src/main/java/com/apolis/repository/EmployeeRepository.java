package com.apolis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apolis.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
