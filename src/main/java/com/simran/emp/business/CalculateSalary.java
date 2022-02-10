package com.simran.emp.business;

import com.simran.emp.model.Grade;

public class CalculateSalary {
	public double getBasic(Grade g) {
		double basic = g.getGradeBasic();
		return basic;
	}
	public double getDa(Grade g) {
		double basic = g.getGradeBasic();
		double da =g.getGradeDa();
		da = basic*(da*0.01);
		return da;
	}
	public double getHra(Grade g) {
		double basic = g.getGradeBasic();
		double hra= g.getGradeHra();
		hra = basic*(hra*0.01);
		return hra;
	}
	public double getMa(Grade g) {
		double basic = g.getGradeBasic();
		double ma= g.getGradeMa();
		ma = basic*(ma*0.01);
		return ma;
	}
	public double getBonus(Grade g) {
		double basic = g.getGradeBasic();
		double bonus= g.getGradeBonus();
		bonus = basic*(bonus*0.01);
		return bonus;
	}
	public double getPf(Grade g) {
		double basic = g.getGradeBasic();
		double pf= g.getGradePf();
		pf= basic*(pf*0.01);
		return pf;
	}
	public double getGross(Grade g) {
		CalculateSalary c = new CalculateSalary();
		double basic = c.getBasic(g);
		double da = c.getDa(g);
		double hra= c.getHra(g);
		double ma = c.getMa(g);
		double bonus = c.getBonus(g);
		double  gross = basic + da+hra+ma+bonus;
		return gross;
	}
	public double getNet(Grade g) {
		
		CalculateSalary c = new CalculateSalary();
		double pf =  c.getPf(g);
		double  gross =c.getGross(g);
		double net = gross - pf;
		return net;
	}
}
