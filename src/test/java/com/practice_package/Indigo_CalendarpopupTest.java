package com.practice_package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Indigo_CalendarpopupTest {

	public static void main(String[] args) throws InterruptedException {

		String monthAndYear="January 2024";
		int date=14;
	
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.goindigo.in/");
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		Thread.sleep(10000);
		
		//Enter From Location
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("Bengaluru");
		
		//Enter To Location
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("Bhubaneswar");
		
		//Click on travel date
		driver.findElement(By.xpath("//label[text()='Travel Dates']")).click();
		
		//select date
		for(;;) {
		try {
			
		driver.findElement(By.xpath("//div[text()='"+monthAndYear+"']/ancestor::div[@class='react-datepicker__month-container']/descendant::div[text()='"+date+"']")).click();
		break;
		}
		
		catch(Exception e) {
			
		driver.findElement(By.xpath("//button[@aria-label='Next Month']")).click();
		}		
		}
		
		//click on search flight
		driver.findElement(By.xpath("//span[text()='Search Flight']")).click();
	}

}
