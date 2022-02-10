package com.simran.emp.business;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;

import com.simran.emp.model.Employee;
import com.simran.emp.service.EmployeeService;

public class AuthenticateUser {
	public static Employee findEmployee(String userName, String password,ApplicationContext ac) {
		EmployeeService employeeService = ac.getBean(EmployeeService.class);
		List<Employee> l = employeeService.listAllEmployee();
		Iterator<Employee> itr = l.iterator();
		
		while(itr.hasNext()) {
			Employee employee = itr.next();
			if(employee.getEmployeeUserName().equals(userName))
				if(employee.getEmployeePassword().equals(password))
					return employee;
				else break;
		}
		return null;
	}
}
