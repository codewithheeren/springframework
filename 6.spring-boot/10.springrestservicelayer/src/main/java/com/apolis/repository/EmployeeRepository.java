package com.apolis.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.apolis.model.Employee;
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	@Query(value = "SELECT * FROM employee",nativeQuery=true)
	public List<Employee> getAllEmployee();

	@Query(value = "SELECT * FROM employee where id= :id",nativeQuery=true)
	public Optional<Employee> getEmployeeById(@Param("id") Long id);
}
