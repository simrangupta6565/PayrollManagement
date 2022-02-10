package com.simran.emp;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;

import com.simran.emp.model.Employee;
import com.simran.emp.model.EmployeeDetails;
import com.simran.emp.service.EmployeeService;


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
			Integer employeeAcNo = null;
			Integer employeeId = null;
			Scanner input = new Scanner (System.in);
			while(true) {
			System.out.println("----------------------");
			System.out.println("Manage Employee");
			System.out.println("----------------------");
			
			System.out.println("1. Add Employee");
			System.out.println("2. Update Employee");
			System.out.println("3. Delete  Employee");
			System.out.println("4. Find Employee");
			System.out.println("5. List All Employee");
			System.out.println("6. Back");
			System.out.println("7. Exit");
			
			System.out.print("Enter the Choice: ");
			Integer option = input.nextInt();
			Employee employee = new Employee();
			EmployeeDetails details = new EmployeeDetails();
			EmployeeService employeeService = ac.getBean(EmployeeService.class);
			switch(option)
			{
				case 1:
					System.out.print("Enter the Employee UserName: ");
					employeeUserName = input.next();
					System.out.print("Enter the Employee Password: ");
					employeepassword = input.next();
					System.out.print("Enter the Employee Department Id: ");
					employeeDepartment = input.next();
					System.out.print("Enter the Employee Grade Id: ");
					employeeGrade = input.next();
					System.out.print("Enter the Employee Email: ");
					employeeEmail = input.next();
					System.out.print("Enter the Employee Name: ");
					employeeName = input.next();
					System.out.print("Enter the Employee Date Of Birth: ");
					employeeDob = input.next();
					System.out.print("Enter the Employee Date Of Joining: ");
					employeeDoj = input.next();
					System.out.print("Enter the Employee Address: ");
					employeeAddress = input.next();
					System.out.print("Enter the Employee Bank Account Number: ");
					employeeAcNo = input.nextInt();
					employee.setEmployeeUserName(employeeUserName);
					employee.setEmployeePassword(employeepassword);
					employee.setEmployeeDepartment(Integer.parseInt(employeeDepartment));
					employee.setEmployeeGrade(Integer.parseInt(employeeGrade));
					details.setEmployeeEmail(employeeEmail);
					details.setEmployeeName(employeeName);
					details.setEmployeeDob(employeeDob);
					details.setEmployeeDoj(employeeDoj);
					details.setEmployeeAddress(employeeAddress);
					details.setEmployeeAcNo(employeeAcNo);
					employee.setDetails(details);
					employeeService.addRecord(employee);
					System.out.println("Employee Added!");
					break;
				case 2:
					System.out.print("Enter the Employee Id:  ");
					employeeId = input.nextInt();
					System.out.print("Enter the Employee UserName: ");
					employeeUserName = input.next();
					System.out.print("Enter the Employee Password: ");
					employeepassword = input.next();
					System.out.print("Enter the Employee Department Id: ");
					employeeDepartment = input.next();
					System.out.println("Enter the Employee Grade Id: ");
					employeeGrade = input.next();
					System.out.print("Enter the Employee Email: ");
					employeeEmail = input.next();
					System.out.print("Enter the Employee Name: ");
					employeeName = input.next();
					System.out.print("Enter the Employee Date Of Birth: ");
					employeeDob = input.next();
					System.out.print("Enter the Employee Date Of Joining: ");
					employeeDoj = input.next();
					System.out.print("Enter the Employee Address: ");
					employeeAddress = input.next();
					System.out.print("Enter the Employee Bank Account Number: ");
					employeeAcNo = input.nextInt();
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
					details.setEmployeeAcNo(employeeAcNo);
					employee.setDetails(details);
					employeeService.updateRecord(employee);
					System.out.println("Employee Updated!");
					break;
				case 3:
					System.out.print("Enter the Employee Id: ");
					employeeId = input.nextInt();
					employeeService.deleteRecord(employeeId);
					System.out.println("Employee Removed!");
					break;
				case 4:
					System.out.print("Enter the Employee Id: ");
					employeeId = input.nextInt();
					employee =employeeService.getEmployee(employeeId);
					
					if(employee==null) {
						System.out.println("Record Not Found!");
					}
					else {
						System.out.println("\tEmployee Id\tEmployee UserName\tEmployee Password\tEmployee Name\tEmployee Email\tEmployee DOB\tEmployee DOJ\tEmployee Address");
						System.out.println("\t------------------------------------------------------------------------------------------------------------------------------------------------------");
						System.out.println("\t\t"+ employee.getEmployeeId()+ "\t\t"+ employee.getEmployeeUserName()+"\t\t"+employee.getEmployeePassword()+"\t\t\t"+employee.getDetails().getEmployeeName()
								+"\t\t"+employee.getDetails().getEmployeeEmail()+"\t"+employee.getDetails().getEmployeeDob()+"\t"+employee.getDetails().getEmployeeDoj()
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
			System.out.print("Do you want to continue: ");
			String choice =input.next();
			if(choice.equals("no")) {
				System.out.println("User don't want to continue");
				input.close();
				System.exit(0);
			}
			}
		}
		
	}
}
