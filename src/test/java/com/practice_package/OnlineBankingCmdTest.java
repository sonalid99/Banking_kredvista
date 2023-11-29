package com.practice_package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OnlineBankingCmdTest {
	
	@Test
	public void writeParameter() {
		
		String BROWSER= System.getProperty("browser");
		
		String URL= System.getProperty("url");
		
		String UN= System.getProperty("username");
		
		String PWD= System.getProperty("password");
		
        WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get(URL);
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//a[text()='Staff Login']")).click();
		
		driver.findElement(By.xpath("//input[@name='staff_id']")).sendKeys(UN);
		
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(PWD);
		
		driver.findElement(By.xpath("//input[@name='staff_login-btn']")).click();
	}

}
