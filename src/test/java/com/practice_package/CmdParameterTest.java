package com.practice_package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CmdParameterTest {

	@Test
	public void cmdParameterTest() {
		
		String BROWSER = System.getProperty("browser");
		
		String URL = System.getProperty("url");
		
		String UN = System.getProperty("username");
		
		String PWD = System.getProperty("password");
		
        WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get(URL);
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		driver.findElement(By.id("usernmae")).sendKeys(UN);
		
		driver.findElement(By.id("inputPassword")).sendKeys(PWD);
		
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		
		
	}
}
