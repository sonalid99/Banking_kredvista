package com.practice_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class KSRTC_CalendarPopupTest {
	
public static void main(String[] args) {
	
	//launch empty browser
	WebDriver driver = new ChromeDriver();
	
	//maximize browser
	driver.manage().window().maximize();
	
	//enter url
	driver.get("https://www.ksrtc.in/");
	
	//click on date of departure
	driver.findElement(By.xpath("//div[@class='col-md-51 mb-1 booking-input']")).click();
	
	//select date from the calendar
	driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/descendant::a[text()='7']")).click();
	
	//click on search bus
	driver.findElement(By.xpath("//div[@class='col-md-22 mb-1 booking-input']")).click();
}
}
