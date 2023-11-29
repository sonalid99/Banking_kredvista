package com.onlinebanking.kredvista.GenericUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseUtils {

	Connection con=null;
	public void connectDB() throws SQLException {
		
		Driver driver1=new Driver(); 
		
		DriverManager.registerDriver(driver1);
		
		con=DriverManager.getConnection(IpathConstants.DBURL, IpathConstants.DB_Username, IpathConstants.DB_Password);
		
	}
	
	public String executeAndGetQuery(int colData,String expData,String query) throws SQLException {
		
	Statement state = con.createStatement();
	//String query="select* from Student;";
	ResultSet result = state.executeQuery(query);
	
	boolean flag=false;
	
	while(result.next()) {
		String actual=result.getString(colData);
		
		if(actual.equalsIgnoreCase(expData)) 
		{
			flag=true;
			break;
		}
	}
		if(flag) {
			System.out.println("project created successfuly");
			return expData;
		}
		else
		{
		
			System.out.println("project is not created");
			return "";
		}
		
	}
	
	
	public void disconnectDatabase() throws SQLException 
	{
		con.close();
	}
	
	
	}

