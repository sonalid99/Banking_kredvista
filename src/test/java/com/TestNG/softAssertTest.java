package com.TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class softAssertTest {
	
	
	@Test
	public void softAssert() {
		
		SoftAssert sa = new SoftAssert();
		String exp="Online Banking Syste";
		WebDriver driver=new ChromeDriver();

		driver.get("http://rmgtestingserver/domain/Online_Banking_System/");
		String title=driver.getTitle();
		sa.assertEquals(title, exp);
		System.out.println(exp);

		driver.quit();
		
		sa.assertAll();
	}
	
	@Test
	public void testSoftAssert() {
		
		SoftAssert sA = new SoftAssert();

		WebDriver driver=new ChromeDriver();

		driver.get("http://rmgtestingserver/domain/Online_Banking_System/");
		
		
		
	}

}
