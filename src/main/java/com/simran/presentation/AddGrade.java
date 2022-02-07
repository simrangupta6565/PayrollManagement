package com.simran.presentation;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;

import com.simran.presentation.model.Grade;
import com.simran.presentation.service.GradeService;
import com.simran.presentation.service.ManageService;

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
			System.out.println("Enter the Choice:");
			Integer option = Integer.parseInt(input.nextLine());
			Grade g = new Grade();
			switch(option)
			{
				case 1:
					System.out.println("Enter the Grade Name:");
					gradeName = input.nextLine();
					g.setGradeName(gradeName);
					System.out.println("Enter the  Grade Basic Pay:");
					gradeBasic = Double.parseDouble(input.nextLine());
					g.setGradeBasic(gradeBasic);
					System.out.println("Enter the  Dearness Allowance(Percentage Value):");
					gradeDa =  Double.parseDouble(input.nextLine());
					g.setGradeDa(gradeDa);
					System.out.println("Enter the House Rent Allowance(Percentage Value):");
					gradeHra = Double.parseDouble(input.nextLine());
					g.setGradeHra(gradeHra);
					System.out.println("Enter the  Medical Allowance(Percentage Value):");
					gradeMa =  Double.parseDouble(input.nextLine());
					g.setGradeMa(gradeMa);
					System.out.println("Enter the  Bonus(Percentage Value):");
					gradeBonus = Double.parseDouble(input.nextLine());
					g.setGradeBonus(gradeBonus);
					System.out.println("Enter the  Provident Fund(Percentage Value):");
					gradePf = Double.parseDouble(input.nextLine());
					g.setGradePf(gradePf);
					gradeService.addGrade(g);
					System.out.println("Grade Details Successfully Added");
					findAll(ac);
					break;
				case 2:
					System.out.println("Enter Grade Id:");
					gradeId= Integer.parseInt(input.nextLine());
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
			System.out.println("Do you want to continue");
			String choice = input.nextLine();
			if(choice.equals("no")) {
				System.out.println("User don't want to continue");;
				System.exit(0);
			}
		}	
	}
}
