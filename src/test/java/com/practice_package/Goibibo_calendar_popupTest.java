package com.practice_package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Goibibo_calendar_popupTest {

	public static void main(String[] args) {
		
		
		String monthAndYear= "March 2024";
		int date=25;
		
		
		//launch the browser
		WebDriver driver=new ChromeDriver();
		
		//maximize the browser
		driver.manage().window().maximize();
				
		//enter the url
		driver.get("https://www.goibibo.com/");
		
		//wait for page load
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
				
		//handle login popup
		driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
		
		//wait for page load
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		//click on departure
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		
		//infinite loop
		for(;;)
		{
			try {
				driver.findElement(By.xpath("//div[text()='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']")).click();
				break;
			}
			catch (Exception e) {
				
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
				
			}
		}
		
		//click on done
		driver.findElement(By.xpath("//span[text()='Done']")).click();

	}
}
