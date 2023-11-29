package com.practice_package;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class IccRankTest {
	
	@Test
	public void testMethod() {
		
		WebDriver driver=new ChromeDriver();
		
        driver.manage().window().maximize();
		
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		//String country="Australia";
		
		List<WebElement> pos = driver.findElements(By.xpath("//table//tbody/tr/td[1]"));
		
		List<WebElement> team =driver.findElements(By.xpath("//table//tbody/tr/td[2]/span[2]"));
		
		List<WebElement> matches= driver.findElements(By.xpath("//table//tbody/tr/td[3]"));
		
		for(int i=0;i<team.size();i++) {
			
			System.out.println(pos.get(i).getText()+"==>"+team.get(i).getText()+"==>"+matches.get(i).getText());
		}
		
		
	}

}
