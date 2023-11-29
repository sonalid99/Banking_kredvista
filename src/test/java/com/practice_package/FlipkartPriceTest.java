package com.practice_package;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FlipkartPriceTest {
	
	@Test
	public void testMethod() {
		
        WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.flipkart.com/");
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//input[@class='Pke_EE']")).sendKeys("Iphone14 pro"+Keys.ENTER);
		
		List<WebElement> mobileNames= driver.findElements(By.xpath("//div[contains(text(),'APPLE iPhone 14 Pro')]"));
		
		List<WebElement> mobilePrices= driver.findElements(By.xpath("//div[contains(text(),'APPLE iPhone 14 Pro')]/../..//div[@class='_30jeq3 _1_WHN1']"));
		
		System.out.println(mobileNames.size());
		
		for(int i=0;i<mobileNames.size();i++) {
			
			System.out.println(mobileNames.get(i).getText()+" --> "+mobilePrices.get(i).getText());
		}
		
		driver.quit();
		}

}
