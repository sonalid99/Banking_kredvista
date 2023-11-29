package com.practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;


public class CheckDataSqlTableTest {

	public static void main(String[] args) throws SQLException {
		
		//register
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		//connect
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra","root","root");
		
		//statement
		Statement state = con.createStatement();
		//String query1= "Select * from Employee;";
		
		//execute
	//	state.execute(query1);
		
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Enter the name of an employee");

        String name=sc.nextLine();
		
		Random r=new Random();
		
		int random=r.nextInt(100);
		
		int age=random;
		
		String query= "Select * from Emp where name='"+name+"';";
		
		ResultSet result = state.executeQuery(query);
		
		String insertQuery="insert into Emp values('"+name+"',"+age+");";
		
		if(!(result.next()))
		{
			int res=state.executeUpdate(insertQuery);
			if(res==1)
			{
				System.out.println("data inserted");
			}
			else
			{
				System.out.println("data could not be inserted");
			}
		}
		else
		{
			System.out.println("data already exists");
		}
		
	
		con.close();
		
	}

}
