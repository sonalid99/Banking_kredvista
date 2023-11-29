package com.Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SpiceJetCalendarTest {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		
        WebDriver driver=new ChromeDriver(option);
		
		driver.manage().window().maximize();
		
		driver.get("https://www.spicejet.com/");
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//div[text()='Departure Date']/..")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[text()='November ' and text()='2023']/ancestor::div[@class='css-1dbjc4n r-1mdbw0j r-ymttw5 r-b2dl2 r-mzjzbw r-wk8lta r-tvv088']/descendant::div[text()='9']")).click();

	}

}
