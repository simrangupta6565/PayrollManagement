package com.simran.presentation;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;

import com.simran.presentation.model.Employee;
import com.simran.presentation.service.EmployeeService;

public class LoginEmployee {

	public static void menu(ApplicationContext ac) {
		Scanner s = new Scanner(System.in);
		String userName;
		String password;
		do {
			System.out.println("Enter Employee User Name:");
			userName = s.nextLine();
			System.out.println("Enter Password:");
			password = s.nextLine();
			Employee e = EmployeeService.findEmployee(userName, password);
			if(e!=null) {
				EmployeeService.showdetails(e);
				break;
			}
			else
				System.out.println("Invalid Credentials!");
		}while( true);
		
		
	}

}
