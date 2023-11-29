package com.practice_package;

import java.awt.Desktop.Action;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MakeMyTrip_CalendarPopupTest {

	public static void main(String[] args) throws InterruptedException {

		String monthAndYear= "March 2024";
		
		int date=10; 
		
		//launch empty browser
		WebDriver driver=new ChromeDriver();
		
		//enter url
		driver.get("https://www.makemytrip.com/");
		
		driver.manage().window().maximize();
		//wait for pageload
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		Thread.sleep(5000);
		
		Actions a = new Actions(driver);
		//handle popup
		a.doubleClick().perform();
		Thread.sleep(10000);

		a.doubleClick().perform();

		
		
		//handle popup
		//driver.findElement(By.xpath("//a[@id='webklipper-publisher-widget-container-notification-close-div']")).click();
		
		//handle login popup
		//driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();

		//click on departure
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		
		//infinite loop
		for(;;) {
			try {
		//select the date
		driver.findElement(By.xpath("//div[text()='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']")).click();
		break;
			}
			catch (Exception e) {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
			}
	}

}
