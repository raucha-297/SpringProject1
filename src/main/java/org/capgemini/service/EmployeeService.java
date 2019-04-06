package org.capgemini.service;

import org.capgemini.dao.EmployeeDao;
import org.capgemini.pojo.Employee;

public class EmployeeService {
	//EmployeeDao is dependency for EmployeeService, 
	//that dependency should not be created by using new operator, 
	//instead we should ask to spring framework to provide that dependency.
	//for that we should have getter and setter method.
	//EmployeeDao dao = new EmployeeDao();
	public EmployeeService(){
		System.out.println("EmployeeService object is created by spring framework");
	}
	
	private EmployeeDao dao;
	public void addEmployee(Employee emp){
		System.out.println("add employee service is called");
		dao.createEmployee(emp);
		
	}
	public void setDao(EmployeeDao dao){
		System.out.println("setDao called by spring framework to set dependency");
		this.dao = dao;
	}
}


