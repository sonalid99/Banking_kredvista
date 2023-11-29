package com.practice_package;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ICCTest {

	//To check if the country name is present in the list or not
	@Test
	public void testMenthod() {
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		String country="Asia";
		
		List<WebElement> ele =driver.findElements(By.xpath("//table//tbody/tr/td[2]/span[2]"));
		
		boolean flag=false;
		
		for(WebElement element:ele) {
			String countryNames=element.getText();
			if(countryNames.equals(country)) {
				System.out.println("country "+country+" is present");
				
				flag=true;
				break;
			}
		}
		
		if(!flag) {
			System.out.println("country "+country+" is not present");
		}
		
		driver.quit();
			
	}
}
