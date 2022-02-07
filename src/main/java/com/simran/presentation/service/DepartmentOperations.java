package com.simran.presentation.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.simran.presentation.model.Department;
@Repository
public interface DepartmentOperations extends JpaRepository<Department, Integer>{
	@Query("select d from Department d")
	public List<Department> listAllDepartment();
}
