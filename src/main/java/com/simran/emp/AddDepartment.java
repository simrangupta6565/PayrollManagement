package com.simran.emp;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;

import com.simran.emp.model.Department;
import com.simran.emp.service.DepartmentService;


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
			System.out.println("\t\t\t"+d.getDepartmentId()+"\t\t\t\t"+d.getDepartmentName());
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
			System.out.print("Enter the Choice: ");
			Integer option = input.nextInt();
			Department d = new Department();
			switch(option)
			{
				case 1:
					System.out.print("Enter Department Name: ");
					String departmentname = input.next();
					d.setDepartmentName(departmentname);
					departmentService.addDepartment(d);
					System.out.println("Department Added!");
					findAll(ac);
					break;
				case 2:
					System.out.print("Enter Department Id: ");
					int departmentId = input.nextInt();
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
			System.out.print("Do you want to continue ");
			String choice = input.next() ;
			if(choice.equals("no")) {
				System.out.println("User don't want to continue");
				input.close();
				System.exit(0);
			}
		}	
		
	}

	
}
