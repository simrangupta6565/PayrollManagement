package com.simran.presentation;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.simran.presentation.model.Employee;
import com.simran.presentation.service.ManageService;

@SpringBootApplication
public class EmployeeManagementApplication {

	public static void main(String[] args) {
		ApplicationContext ac=SpringApplication.run(EmployeeManagementApplication.class, args);

		Scanner input = new Scanner (System.in);
		while(true) {
			System.out.println("\t----------------------------------");
			System.out.println("\tEmployee Payroll Management System");
			System.out.println("\t----------------------------------");
			
			System.out.println("1. Admin Login ");
			System.out.println("2. Employee Login ");
			System.out.println("3. Exit");
			System.out.println("Enter the Choice:");
			Integer option = input.nextInt();
			
			switch(option)
			{
				case 1:
					LoginAdmin.menu(ac);
					break;
				case 2:
					LoginEmployee.menu(ac);
					break;
				case 3:
					System.out.println("Exit");
					System.exit(0);
			}
			System.out.println("Do you want to continue");
			String choice = input.next();
			if(choice.equals("no")) {
				System.out.println("User don't want to continue");
				System.exit(0);
			}
		}	
	}
}
