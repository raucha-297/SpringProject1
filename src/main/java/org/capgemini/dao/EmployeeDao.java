package org.capgemini.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.capgemini.pojo.Employee;

public class EmployeeDao {
	private Connection connection;

	public void openConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:XE", "system", "root");

	}

	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int createEmployee(Employee employee) {
		try {
			openConnection();
			String query = "Insert Into Employee(Employee_Id, Employee_Name, Employee_Salary) Values (?,?,?)";
			PreparedStatement pstatement = connection.prepareStatement(query);
			pstatement.setInt(1, employee.getEmployeeId());
			pstatement.setString(2, employee.getEmployeeName());
			pstatement.setDouble(3, employee.getEmployeeSalary());
			int result = pstatement.executeUpdate();
			closeConnection();
			return result;
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return 0;

	}

	public int deleteEmployee(int employeeId) {
		try {
			openConnection();
			String query = "Delete From Employee Where EmployeeId=?";
			PreparedStatement pstatement = connection.prepareStatement(query);
			pstatement.setInt(1, employeeId);
			int result = pstatement.executeUpdate();
			closeConnection();
			return result;
		} catch (ClassNotFoundException  | SQLException e) {
			
			e.printStackTrace();
		}
		return 0; 
		}
	public boolean checkLogin(String username, String password){
		boolean result = false;
		try{
		openConnection();
		String query = "Select Username, Password From Login Where Username='"+username+"' and Password='"+password+"'";
		//String query = "Select Username, Password From Login Where Username=? and Password=?"
		System.out.println(query);
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(query);
		if(rs.next()){
			result = true;
			
		}
		closeConnection();
		
	}
		catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}
		return result;
		

	}


	public EmployeeDao(){
		System.out.println("EmployeeDao object is created by spring framework");
	}
	
}
