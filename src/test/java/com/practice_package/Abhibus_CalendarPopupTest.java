package com.practice_package;

import org.asynchttpclient.webdav.WebDavResponse;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Abhibus_CalendarPopupTest {

	public static void main(String[] args) {
		
		String month="December";
		
		int year=2023;
		
		int date=12;

		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.abhibus.com/");
		
		//enter from location
		driver.findElement(By.xpath("//input[@placeholder='From Station']")).sendKeys("Bangalore");
		
		//select the autosuggestion
		driver.findElement(By.xpath("//div[text()='Bangalore']")).click();
		
		//enter the location in To textbox
		driver.findElement(By.xpath("//input[@placeholder='To Station']")).sendKeys("Tirupathi");
		
		//select the autosuggestion
		//driver.findElement(By.xpath("//div[text()='Tirupathi']")).click();
		
		//click on calendar
		driver.findElement(By.xpath("//div[@class='journey-date-input-wrapper col']/descendant::div[@class='input-prefix col auto']")).click();
		
		for(;;) {
			
		try {
		//select date
		driver.findElement(By.xpath("//span[text()='"+month+"']/following-sibling::span[text()='"+year+"']/ancestor::div[@class='container calendar  ']/descendant::span[text()='"+date+"']")).click();
		break;
		}
		
		catch(Exception e) {
			
		//select next on calendar
		driver.findElement(By.xpath("//span[@class='calender-month-change']")).click();
		
		}
		}
		
		driver.findElement(By.xpath("//a[text()='Search']")).click();
	}

}

