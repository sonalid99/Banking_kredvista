package com.TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

	@Test(dataProvider ="data")
	public void getData(String from,String to,int price) {
	System.out.println(from+"--->"+to+"--->"+price);	
	}
	
	@DataProvider
	public Object[][] store()
	{
		Object[][] obj=new Object[2][2];
		
		obj[0][0]="Bangalore";
		obj[0][1]="Bhubaneswar";
		
		obj[1][0]="Bangalore";
		obj[1][1]="Delhi";
		
		return obj;
	}
	
	@DataProvider
	public Object[][] data() {

		Object[][] obj=new Object[2][3];
		
		obj[0][0]="Bangalore";
		obj[0][1]="Bhubaneswar";
		obj[0][2]=5000;
		
		obj[1][0]="Bangalore";
		obj[1][1]="Delhi";
		obj[1][2]=4000;
		
		return obj;
	}
}
