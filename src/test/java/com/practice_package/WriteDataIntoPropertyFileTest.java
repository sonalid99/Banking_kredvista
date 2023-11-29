package com.practice_package;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WriteDataIntoPropertyFileTest {

	public static void main(String[] args) throws IOException {

		//create object for properties class
		Properties p=new Properties();
		
		p.setProperty("url", "http://rmgtestingserver:8084/");
		p.setProperty("username", "rmgyantra");
		p.setProperty("password", "rmgy@9999");
		
		//create object for FileOutputStream
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\CommonData.property");
		p.store(fos,"write data"); 
		
		//get the data from properties file
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.property");
		
		String URL=p.getProperty("url");
		String UN=p.getProperty("username");
		String PWD=p.getProperty("password");
		
		System.out.println(URL);
		System.out.println(UN);
		System.out.println(PWD);
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get(URL);
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		driver.findElement(By.id("usernmae")).sendKeys(UN);
		
		driver.findElement(By.id("inputPassword")).sendKeys(PWD);
		
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		
	}

}
