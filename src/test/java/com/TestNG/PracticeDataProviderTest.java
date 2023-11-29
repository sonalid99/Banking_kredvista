package com.TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PracticeDataProviderTest {
	
	@Test
	public void execution() {
		
	}
	
	
	@DataProvider
	public void storeData() {
		
		Object[][] obj=new Object[2][2];
		
		obj[0][0]="Hyderabad";
		obj[0][1]="Nursery";
		
		obj[1][0]="Gwalior";
		obj[1][1]="Primary";
		
		
	}

}
