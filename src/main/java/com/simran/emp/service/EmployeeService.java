package com.simran.emp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simran.emp.model.Employee;
@Service
public class EmployeeService {
	@Autowired
	private  EmployeeOperations db;
	public void addRecord(Employee employee) {
			db.save(employee);
		}

	public String updateRecord(Employee employee) {
		Employee emp = getEmployee(employee.getEmployeeId());
		if(emp== null) 
			return "Employee Not Found!";
		db.save(employee);
		return "Employee Updated";
	}

	public Employee getEmployee(Integer employeeId) {
		Employee emp = null;
		Optional<Employee> opt = db.findById(employeeId);
		if(!opt.isEmpty())
			emp = opt.get();
		return emp;
	}

	public String deleteRecord(Integer employeeId) {
		Employee emp = getEmployee(employeeId);
		if(emp== null) 
			return "Employee Not Found!";
		db.delete(emp);
		return "Employee Removed!";
	}

	public List<Employee> listAllEmployee() {
		return db.listAllEmployee();
	}
	

}
