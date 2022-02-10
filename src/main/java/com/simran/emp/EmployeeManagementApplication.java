package com.simran.emp;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EmployeeManagementApplication {

	public static void main(String[] args) {
		ApplicationContext ac=SpringApplication.run(EmployeeManagementApplication.class, args);
		EmployeeManagementApplication.menu(ac);
			
	}
	public static void menu(ApplicationContext ac) {
		Scanner input = new Scanner (System.in);
		while(true) {
			System.out.println("\t----------------------------------");
			System.out.println("\tEmployee Payroll Management System");
			System.out.println("\t----------------------------------");
			
			System.out.println("1. Admin Login ");
			System.out.println("2. Employee Login ");
			System.out.println("3. Exit");
			System.out.print("Enter the Choice:");
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
			System.out.print("Do you want to continue: ");
			String choice = input.next();
			if(choice.equals("no")) {
				System.out.println("User don't want to continue");
				input.close();
				System.exit(0);
			}
		}
	}
}
