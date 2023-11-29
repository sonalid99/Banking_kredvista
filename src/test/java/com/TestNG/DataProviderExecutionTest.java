package com.TestNG;

import org.testng.annotations.Test;

public class DataProviderExecutionTest {

	@Test(dataProviderClass = DataProviderTest.class, dataProvider = "data")
	public void executeDataProvider(String from, String to, int price) {
		System.out.println(from+"--->"+to+"--->"+price);
	}
}
