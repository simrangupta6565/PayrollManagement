package com.simran.emp;

import java.text.DecimalFormat;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;

import com.simran.emp.business.AuthenticateUser;
import com.simran.emp.business.CalculateSalary;
import com.simran.emp.model.Department;
import com.simran.emp.model.Employee;
import com.simran.emp.model.Grade;
import com.simran.emp.service.DepartmentService;
import com.simran.emp.service.GradeService;

public class LoginEmployee {
	private static final DecimalFormat df = new DecimalFormat("0.00");
	public static void menu(ApplicationContext ac) {
		Scanner input = new Scanner(System.in);
		String userName;
		String password;
		do {
			System.out.print("Enter Employee User Name: ");
			userName = input.next();
			System.out.print("Enter Password: ");
			password = input.next();
			Employee employee = AuthenticateUser.findEmployee(userName, password, ac);
			if(employee!=null) {
				while(true) {
					System.out.println("----------------------");
					System.out.println("Welcome Employee");
					System.out.println("----------------------");
					
					System.out.println("1. View Personal Details");
					System.out.println("2. Generate Salary Slip");
					System.out.println("3. Back");
					System.out.println("4. Exit");
					System.out.print("Enter the Choice:");
					Integer option = input.nextInt();
					
					switch(option)
					{
						case 1:
							System.out.println("\tEmployee Id\tEmployee Name\tEmployee Email\tEmployee DOB\tEmployee DOJ\tEmployee Address\tAccount Number");
							System.out.println("\t-------------------------------------------------------------------------------------------------------------------------------------");
							System.out.println("\t\t"+ employee.getEmployeeId()+ "\t"+employee.getDetails().getEmployeeName()
										+"\t\t"+employee.getDetails().getEmployeeEmail()+"\t"+employee.getDetails().getEmployeeDob()+"\t"+employee.getDetails().getEmployeeDoj()
										+"\t"+employee.getDetails().getEmployeeAddress()+"\t\t\t"+employee.getDetails().getEmployeeAcNo());
							System.out.println("\t-------------------------------------------------------------------------------------------------------------------------------------");
							break;
						case 2:
							GradeService gradeService = ac.getBean(GradeService.class);
							Grade g = gradeService.getGrade(employee.getEmployeeGrade());
							DepartmentService departmentService = ac.getBean(DepartmentService.class);
							Department d = departmentService.getDepartment(employee.getEmployeeDepartment());
							CalculateSalary c = new CalculateSalary();
							double basic = c.getBasic(g);
							double da = c.getDa(g)
;							double hra= c.getHra(g);
							double ma = c.getMa(g);
							double pf = c.getPf(g);
							double  gross = c.getGross(g);
							double bonus = c.getBonus(g);
							double net = c.getNet(g);
							System.out.println("\t---------------------------------------------------------------------------------------------");
							System.out.println("\t------------------------------------ Salary Slip --------------------------------------------");
							System.out.println("\t\tEmployee Id: "+employee.getDetails().getEmployeeName()+" \t\t\t\tDepartment Id: "+ d.getDepartmentName());
							System.out.println("\t\tGrade Id: "+g.getGradeName() + " \t\t\t\t\tAccount Number: "+ employee.getDetails().getEmployeeAcNo());
							System.out.println("\t---------------------------------------------------------------------------------------------");
							System.out.println("\t\tBasic : "+df.format(basic)+" \t\t\t\tDearness Allowance: "+ df.format(da));
							System.out.println("\t\tHouse Rent Allowance: "+df.format(hra)+" \t\t\tMedical Allowance: "+df.format(ma));
							System.out.println("\t\tBonus : "+df.format(bonus)+" \t\t\t\tProvident Fund: "+ df.format(pf));
							System.out.println("\t\tGross Salary: "+df.format(gross)+" \t\t\t\tTotal Deduction: "+ df.format(pf));
							System.out.println("\t\tNet Salary: "+df.format(net));
							System.out.println("\t---------------------------------------------------------------------------------------------");
							break;
						case 3:
							EmployeeManagementApplication.menu(ac);
							break;
						case 4:
							System.out.println("Exit");
							System.exit(0);
					}
					System.out.print("Do you want to continue: ");
					String choice =input.next();
					if(choice.equals("no")) {
						System.out.println("User don't want to continue");
						input.close();
						System.exit(0);
					}
					
				}
				
			}
			else
				System.out.println("Invalid Credentials!");
		}while( true);
		
		
	}

}
