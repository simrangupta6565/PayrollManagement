package com.simran.emp.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.simran.emp.model.Employee;
@Repository
public interface EmployeeOperations extends JpaRepository<Employee, Integer>{
	@Query("select e from Employee e")
	public List<Employee> listAllEmployee();

}
