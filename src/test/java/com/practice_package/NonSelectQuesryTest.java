package com.practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;


public class NonSelectQuesryTest {

	public static void main(String[] args) throws SQLException {

	    Connection con = null;
	    int result=0;
		try {
		//register the database
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		//get connection for database
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra","root","root");
		
		//create statement
		 Statement state = con.createStatement();
		 String query="insert into student values('Sonali','9080706050',24),('Vaishnavi','8090705060',26);";
		 
		 //execute update query
		 result = state.executeUpdate(query);
		 
		 if(result>=1)
		 {
			 System.out.println("data inserted successfully");
		 }
		 else
		 {
			 System.out.println("data is not updated");
		 }
		}
		catch(Exception e) {
			//handle exception
		}
		finally
		{
			//close the database
			con.close();
		}
		
		
	}

}
