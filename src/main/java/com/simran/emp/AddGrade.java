package com.simran.emp;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;

import com.simran.emp.model.Grade;
import com.simran.emp.service.GradeService;


public class AddGrade {
	public static void findAll(ApplicationContext ac) {
		GradeService gradeService = ac.getBean(GradeService.class);
		List<Grade> l = gradeService.findAll();
		Iterator<Grade> itr = l.iterator();
		System.out.println("\t-------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("\tGrade Id\tGrade Name\tBasic Pay\tDearness Allowance\tHouse Rent Allowance\tMedical Allowance\tBonus\t Provident Fund");
		System.out.println("\t-------------------------------------------------------------------------------------------------------------------------------------------------");
		while(itr.hasNext()) {
			Grade g = itr.next();
			System.out.println("\t\t"+g.getGradeId()+"\t"+g.getGradeName()+"\t\t"+g.getGradeBasic()+"\t\t"+g.getGradeDa()+"\t\t\t"+g.getGradeHra()+"\t\t\t"+g.getGradeMa()+"\t\t\t"+g.getGradeBonus()
			+"\t\t"+g.getGradePf());
		}
		System.out.println("\t-------------------------------------------------------------------------------------------------------------------------------------------------");
		
	}
	public static void menu(ApplicationContext ac) {
		Integer gradeId= null;
		String  gradeName=null;
		Double gradeBasic=null;
		Double gradeDa=null;
		Double gradeHra=null;
		Double gradeMa=null;
		Double gradeBonus=null;
		Double gradePf=null;
		Scanner input = new Scanner (System.in);
		GradeService gradeService = ac.getBean(GradeService.class);
		findAll(ac);
		while(true) {
			System.out.println("1. Add Grade Details");
			System.out.println("2. Delete Grade");
			System.out.println("3. Back");
			System.out.println("4. Exit");
			System.out.print("Enter the Choice:");
			Integer option = input.nextInt();
			Grade g = new Grade();
			switch(option)
			{
				case 1:
					System.out.print("Enter the Grade Name: ");
					gradeName = input.next();
					g.setGradeName(gradeName);
					System.out.print("Enter the  Grade Basic Pay: ");
					gradeBasic = input.nextDouble();
					g.setGradeBasic(gradeBasic);
					System.out.print("Enter the  Dearness Allowance(Percentage Value): ");
					gradeDa =  input.nextDouble();
					g.setGradeDa(gradeDa);
					System.out.print("Enter the House Rent Allowance(Percentage Value): ");
					gradeHra = input.nextDouble();
					g.setGradeHra(gradeHra);
					System.out.print("Enter the  Medical Allowance(Percentage Value): ");
					gradeMa =  input.nextDouble();
					g.setGradeMa(gradeMa);
					System.out.print("Enter the  Bonus(Percentage Value): ");
					gradeBonus = input.nextDouble();
					g.setGradeBonus(gradeBonus);
					System.out.print("Enter the  Provident Fund(Percentage Value): ");
					gradePf = input.nextDouble();
					g.setGradePf(gradePf);
					gradeService.addGrade(g);
					System.out.println("Grade Details Successfully Added");
					findAll(ac);
					break;
				case 2:
					System.out.print("Enter Grade Id: ");
					gradeId= input.nextInt();
					gradeService.deleteGrade(gradeId);
					System.out.println("Grade Details Successfully Deleted");
					findAll(ac);
					break;
				case 3:
					AdminClient.menu(ac);
					break;
				case 4:
					System.out.println("Exit");
					System.exit(0);
			}
			System.out.print("Do you want to continue");
			String choice = input.next();
			if(choice.equals("no")) {
				System.out.println("User don't want to continue");
				input.close();
				System.exit(0);
			}
		}	
	}
}
