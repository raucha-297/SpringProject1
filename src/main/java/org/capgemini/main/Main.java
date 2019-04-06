package org.capgemini.main;

import org.capgemini.pojo.Employee;
import org.capgemini.service.EmployeeService;
import org.omg.CORBA.portable.ApplicationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		/*EmployeeService service = new EmployeeService();
		Employee emp = new Employee();
		service.addEmployee(emp);*/
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Beans.xml"); //container
		EmployeeService service= (EmployeeService)context.getBean("service");
		Employee employee = (Employee)context.getBean("employee");
		employee.setEmployeeId(34);
		employee.setEmployeeName("Ankish");
		employee.setEmployeeSalary(789456.12);
		service.addEmployee(employee);
		System.out.println("DaTA eNTERW");
		
	
	}

}
