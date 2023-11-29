package com.practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class SqlDeleteQueryTest {

	public static void main(String[] args) throws SQLException {

		//register
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		//connect
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra", "root", "root");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a student name");
		String name=sc.nextLine();
		
		Statement state = con.createStatement();
		String query="delete from Student where Sname='"+name+"';";
		
		int result = state.executeUpdate(query);
		
		String query1="select* from student where Sname='"+name+"';";
		ResultSet result1 = state.executeQuery(query1);
		
		boolean flag=false;
		if(result1.next()) {
			
		if(result1.getString(1).equalsIgnoreCase(name)) {
			System.out.println("Student data is not deleted");
			flag=true;
		}
		}
		if(flag==false) {
			System.out.println("data is deleted");
		}
		
		/*if(result>=1) {
			System.out.println("data deleted successfully");
			
		}
		else {
			System.out.println("data not deleted");
		}*/
		
		
	}

}
