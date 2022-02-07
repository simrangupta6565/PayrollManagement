package com.simran.presentation;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;

import com.simran.presentation.model.Department;
import com.simran.presentation.model.Grade;
import com.simran.presentation.service.DepartmentService;
import com.simran.presentation.service.GradeService;

public class AddDepartment {
	public static void findAll(ApplicationContext ac) {
		DepartmentService departmentService = ac.getBean(DepartmentService.class);
		List<Department> l =departmentService.findAll();
		Iterator<Department> itr = l.iterator();
		System.out.println("\t----------------------------------------------------------------------------");
		System.out.println("\t\tDepartment Id\t\t\t Department Name");
		System.out.println("\t----------------------------------------------------------------------------");
		while(itr.hasNext()) {
			Department d = itr.next();
			System.out.println("\t\t\t"+d.getDepartmentId()+"\t\t\t"+d.getDepartmentName());
		}
		System.out.println("\t----------------------------------------------------------------------------");
		
	}
	public static void menu(ApplicationContext ac) {
		findAll(ac);
		DepartmentService departmentService = ac.getBean(DepartmentService.class);
		Scanner input = new Scanner (System.in);
		while(true) {
			System.out.println("1. Add Department ");
			System.out.println("2. Delete Department ");
			System.out.println("3. Back");
			System.out.println("4. Exit");
			System.out.println("Enter the Choice:");
			Integer option = Integer.parseInt(input.nextLine());
			Department d = new Department();
			switch(option)
			{
				case 1:
					System.out.println("Enter Department Name:");
					String departmentname = input.nextLine();
					d.setDepartmentName(departmentname);
					departmentService.addDepartment(d);
					System.out.println("Department Added!");
					findAll(ac);
					break;
				case 2:
					System.out.println("Enter Department Id:");
					int departmentId = Integer.parseInt(input.nextLine());
					departmentService.deleteDepartment(departmentId);
					findAll(ac);
					break;
				case 3:
					AdminClient.menu(ac);
					break;
				case 4:
					System.out.println("Exit");
					System.exit(0);
			}
			System.out.println("Do you want to continue");
			String choice = input.nextLine() ;
			if(choice.equals("no")) {
				System.out.println("User don't want to continue");
				System.exit(0);
			}
		}	
		
	}

	
}
