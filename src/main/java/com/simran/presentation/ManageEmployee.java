package com.simran.presentation;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;

import com.simran.presentation.model.Employee;
import com.simran.presentation.model.EmployeeDetails;
import com.simran.presentation.service.ManageService;

public class ManageEmployee {
	public static void menu(ApplicationContext ac) {
		{
			String  employeeUserName=null;
			String employeepassword = null;
			String employeeDepartment = null;
			String employeeGrade= null;
			String employeeEmail=null;
			String employeeName= null;
			String employeeDob = null;
			String employeeDoj = null;
			String employeeAddress = null;
			String employeeAcNo = null;
			Integer employeeId = null;
			Scanner input = new Scanner (System.in);
			while(true) {
			System.out.println("----------------------");
			System.out.println("Manage Employee");
			System.out.println("----------------------");
			
			System.out.println("1. Add Records");
			System.out.println("2. Update Record");
			System.out.println("3. Delete  Record");
			System.out.println("4. Find Record");
			System.out.println("5. List All Record");
			System.out.println("6. Back");
			System.out.println("7. Exit");
			
			System.out.println("Enter the Choice:");
			Integer option = Integer.parseInt(input.nextLine());
			Employee employee = new Employee();
			EmployeeDetails details = new EmployeeDetails();
			ManageService employeeService = ac.getBean(ManageService.class);
			switch(option)
			{
				case 1:
					System.out.println("Enter the Employee UserName:");
					employeeUserName = input.nextLine();
					//check username is unique.
					System.out.println("Enter the Employee Password:");
					employeepassword = input.nextLine();
					System.out.println("Enter the Employee Department Id:");
					employeeDepartment = input.nextLine();
					System.out.println("Enter the Employee Grade Id:");
					employeeGrade = input.nextLine();
					System.out.println("Enter the Employee Email:");
					employeeEmail = input.nextLine();
					//check email validity
					System.out.println("Enter the Employee Name:");
					employeeName = input.nextLine();
					System.out.println("Enter the Employee Date Of Birth:");
					employeeDob = input.nextLine();
					System.out.println("Enter the Employee Date Of Joining:");
					employeeDoj = input.nextLine();
					System.out.println("Enter the Employee Address:");
					employeeAddress = input.nextLine();
					System.out.println("Enter the Employee Bank Account Number:");
					employeeAcNo = input.nextLine();
					//AccountNo. is valid
					employee.setEmployeeUserName(employeeUserName);
					employee.setEmployeePassword(employeepassword);
					employee.setEmployeeDepartment(Integer.parseInt(employeeDepartment));
					employee.setEmployeeGrade(Integer.parseInt(employeeGrade));
					details.setEmployeeEmail(employeeEmail);
					details.setEmployeeName(employeeName);
					details.setEmployeeDob(employeeDob);
					details.setEmployeeDoj(employeeDoj);
					details.setEmployeeAddress(employeeAddress);
					details.setEmployeeAcNo(Integer.parseInt(employeeAcNo));
					employee.setDetails(details);
					employeeService.addRecord(employee);
					System.out.println("Employee Added!");
					break;
				case 2:
					System.out.println("Enter the Employee Id:");
					employeeId = Integer.parseInt(input.nextLine());
					System.out.println("Enter the Employee UserName:");
					employeeUserName = input.nextLine();
					//check username is unique.
					System.out.println("Enter the Employee Password:");
					employeepassword = input.nextLine();
					System.out.println("Enter the Employee Department Id:");
					employeeDepartment = input.nextLine();
					System.out.println("Enter the Employee Grade Id:");
					employeeGrade = input.nextLine();
					System.out.println("Enter the Employee Email:");
					employeeEmail = input.nextLine();
					//check email validity
					System.out.println("Enter the Employee Name:");
					employeeName = input.nextLine();
					System.out.println("Enter the Employee Date Of Birth:");
					employeeDob = input.nextLine();
					System.out.println("Enter the Employee Date Of Joining:");
					employeeDoj = input.nextLine();
					System.out.println("Enter the Employee Address:");
					employeeAddress = input.nextLine();
					System.out.println("Enter the Employee Bank Account Number:");
					employeeAcNo = input.nextLine();
					//AccountNo. is valid
					employee.setEmployeeId(employeeId);
					employee.setEmployeeUserName(employeeUserName);
					employee.setEmployeePassword(employeepassword);
					employee.setEmployeeDepartment(Integer.parseInt(employeeDepartment));
					employee.setEmployeeGrade(Integer.parseInt(employeeGrade));
					details.setEmployeeEmail(employeeEmail);
					details.setEmployeeName(employeeName);
					details.setEmployeeDob(employeeDob);
					details.setEmployeeDoj(employeeDoj);
					details.setEmployeeAddress(employeeAddress);
					details.setEmployeeAcNo(Integer.parseInt(employeeAcNo));
					employee.setDetails(details);
					employeeService.updateRecord(employee);
					System.out.println("Employee Updated!");
					break;
				case 3:
					System.out.println("Enter the Employee Id:");
					employeeId = Integer.parseInt(input.nextLine());
					
					employeeService.deleteRecord(employeeId);
					System.out.println("Employee Removed!");
					break;
				case 4:
					System.out.println("Enter the Employee Id:");
					employeeId = Integer.parseInt(input.nextLine());
					
					employee =employeeService.getEmployee(employeeId);
					if(employee==null) {
						System.out.println("Record Not Found!");
					}
					else {
						System.out.println("\tEmployee Id\tEmployee UserName\tEmployee Password\tEmployee Name\tEmployee Email\tEmployee DOB\tEmployee DOJ\tEmployee Address");
						System.out.println("\t------------------------------------------------------------------------------------------------------------------------------------------------------");
						System.out.println("\t"+ employee.getEmployeeId()+ "\t"+ employee.getEmployeeUserName()+"\t"+employee.getEmployeePassword()+"\t"+employee.getDetails().getEmployeeName()
								+"\t"+employee.getDetails().getEmployeeEmail()+"\t"+employee.getDetails().getEmployeeDob()+"\t"+employee.getDetails().getEmployeeDoj()
								+"\t"+employee.getDetails().getEmployeeAddress());
						System.out.println("\t------------------------------------------------------------------------------------------------------------------------------------------------------");
					}
					break;
				case 5:
					List<Employee> l = employeeService.listAllEmployee();
					Iterator<Employee> itr = l.iterator();
					System.out.println("\t------------------------------------------------------------------------------------------------------------------------------------------------------");
					System.out.println("\tEmployee Id\tEmployee UserName\tEmployee Password\tEmployee Name\tEmployee Email\tEmployee DOB\tEmployee DOJ\tEmployee Address");
					System.out.println("\t------------------------------------------------------------------------------------------------------------------------------------------------------");
					while(itr.hasNext()) {
						 employee = itr.next();
						System.out.println("\t\t"+ employee.getEmployeeId()+ "\t\t"+ employee.getEmployeeUserName()+"\t\t"+employee.getEmployeePassword()+"\t\t\t"+employee.getDetails().getEmployeeName()
								+"\t\t"+employee.getDetails().getEmployeeEmail()+"\t"+employee.getDetails().getEmployeeDob()+"\t"+employee.getDetails().getEmployeeDoj()
								+"\t"+employee.getDetails().getEmployeeAddress());
					}
					System.out.println("\t------------------------------------------------------------------------------------------------------------------------------------------------------");
					
					break;
				case 6:
					AdminClient.menu(ac);
					break;
				case 7:
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
}
