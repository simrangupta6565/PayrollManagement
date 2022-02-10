package com.simran.emp;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;

import com.simran.emp.business.CalculateSalary;
import com.simran.emp.model.Department;
import com.simran.emp.model.Employee;
import com.simran.emp.model.Grade;
import com.simran.emp.service.DepartmentService;
import com.simran.emp.service.EmployeeService;
import com.simran.emp.service.GradeService;

public class EmployeeSalary {

	public static void menu(ApplicationContext ac) {
		Scanner input = new Scanner (System.in);
		while(true) {
			System.out.println("1. View Employee Report ");
			System.out.println("2. Back");
			System.out.println("3. Exit");
			System.out.print("Enter the Choice:");
			Integer option = input.nextInt();

			switch(option)
			{
				case 1:
					System.out.print("Enter the Employee Id:");
					Integer employeeId = input.nextInt();
					EmployeeService employeeService = ac.getBean(EmployeeService.class);
					Employee employee = employeeService.getEmployee(employeeId);
					GradeService gradeService = ac.getBean(GradeService.class);
					Grade g = gradeService.getGrade(employee.getEmployeeGrade());
					DepartmentService departmentService = ac.getBean(DepartmentService.class);
					Department d = departmentService.getDepartment(employee.getEmployeeDepartment());
					CalculateSalary c = new CalculateSalary();
					System.out.println("\t\tEmployee Id\tEmployee Name\tDepartment Name\t\tGrade Name\tGross Salary\t\tNet Salary");
					System.out.println("\t---------------------------------------------------------------------------------------------------------------");
					System.out.println("\t\t\t"+ employee.getEmployeeId()+ "\t"+employee.getDetails().getEmployeeName()
								+"\t\t"+d.getDepartmentName()+"\t\t"+g.getGradeName()+"\t\t"+c.getGross(g)+"\t\t\t"+c.getNet(g));
					System.out.println("\t---------------------------------------------------------------------------------------------------------------");
					break;
				case 2:
					AdminClient.menu(ac);
					break;
				case 3:
					System.out.println("Exit");
					System.exit(0);
			}
			System.out.print("Do you want to continue: ");
			String choice = input.next() ;
			if(choice.equals("no")) {
				System.out.println("User don't want to continue");
				input.close();
				System.exit(0);
			}
		}	
		
	}

}
