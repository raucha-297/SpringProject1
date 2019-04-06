package org.capgemini.pojo;

public class Employee {
	
	private int employeeId;
	private String employeeName;
	private double employeeSalary;
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public double getEmployeeSalary() {
		return employeeSalary;
	}
	public void setEmployeeSalary(double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	//this will contain id, name and salary.
	public Employee(){
		System.out.println("Employee object is created by spring framework");
	}

	

}
