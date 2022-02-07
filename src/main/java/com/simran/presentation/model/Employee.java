package com.simran.presentation.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer employeeId;
	@Column(unique=true)
	private String employeeUserName;
	private String employeePassword;
	private Integer employeeDepartment;
	private Integer employeeGrade;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="EmployeeEmail")
	private EmployeeDetails details;
	public EmployeeDetails getDetails() {
		return details;
	}
	public void setDetails(EmployeeDetails details) {
		this.details = details;
	}
	public Integer getEmployeeDepartment() {
		return employeeDepartment;
	}
	public void setEmployeeDepartment(Integer employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}
	public Integer getEmployeeGrade() {
		return employeeGrade;
	}
	public void setEmployeeGrade(Integer employeeGrade) {
		this.employeeGrade = employeeGrade;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public String getEmployeeUserName() {
		return employeeUserName;
	}
	public void setEmployeeUserName(String employeeUserName) {
		this.employeeUserName = employeeUserName;
	}
	public String getEmployeePassword() {
		return employeePassword;
	}
	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}
	public void setEmployeeId(Integer employeeId2) {
		this.employeeId = employeeId2;
	}
	


}
