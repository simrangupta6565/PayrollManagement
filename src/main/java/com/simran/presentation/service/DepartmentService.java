package com.simran.presentation.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simran.presentation.model.Department;


@Service
public class DepartmentService {
	@Autowired
	private  DepartmentOperations db;
	
	public List<Department> findAll() {
		return  db.listAllDepartment();
	}

	public void addDepartment(Department d) {
		db.save(d);
	}

	public String deleteDepartment(int departmentId) {
		Department d = getDepartment(departmentId);
		if(d== null) 
			return "Department Not Found!";
		db.delete(d);
		return "Department Removed!";
	}
	private Department getDepartment(int departmentId) {
		Department d = null;
		Optional<Department> opt = db.findById(departmentId);
		if(!opt.isEmpty())
			d = opt.get();
		return d;
	}


}
