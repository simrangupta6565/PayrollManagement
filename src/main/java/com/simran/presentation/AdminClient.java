package com.simran.presentation;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;

import com.simran.presentation.model.Employee;


public class AdminClient {

	public static void menu(ApplicationContext ac) {
		Scanner input = new Scanner (System.in);
		while(true) {
		System.out.println("----------------------");
		System.out.println("Welcome Admin");
		System.out.println("----------------------");
		
		System.out.println("1. Manage Employee");
		System.out.println("2. Add new Department");
		System.out.println("3. Add new Grade");
		System.out.println("4. Prepare Monthly Salary");
		System.out.println("5. Exit");
		
		System.out.println("Enter the Choice:");
		Integer option = Integer.parseInt(input.nextLine());
		
		switch(option)
		{
			case 1:
				 ManageEmployee.menu(ac);
				break;
			case 2:
				AddDepartment.menu(ac);
				break;
			case 3:
				AddGrade.menu(ac);
				break;
			case 4:
				EmployeeSalary.menu(ac);
				break;
			case 5:
				System.out.println("Exit");
				System.exit(0);
		}
		System.out.println("Do you want to continue");
		String choice =input.nextLine();
		if(choice.equals("no")) {
			System.out.println("User don't want to continue");;
			System.exit(0);
		}
		
	}
	}

}
