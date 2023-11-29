package com.practice_package;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ProkabaddiStandingsTest {
	
	@Test
	public void testMethod() {
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.prokabaddi.com/standings");
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		List<WebElement> pos =driver.findElements(By.xpath("//div[@class='table-body']/descendant::p[@class='position']"));
		
		List<WebElement> team =driver.findElements(By.xpath("//div[@class='team-name']"));
		
		List<WebElement> matches =driver.findElements(By.xpath("//div[@class='table-data matches-play']//p[@class='count']"));
		
		List<WebElement> matchesWon =driver.findElements(By.xpath("//div[@class='table-data matches-won']//p[@class='count']"));
		
		List<WebElement> matchesLost =driver.findElements(By.xpath("//div[@class='table-data matches-lost']//p[@class='count']"));
		
		List<WebElement> matchesDraw =driver.findElements(By.xpath("//div[@class='table-data matches-draw']//p[@class='count']"));
		
		for(int i=0;i<pos.size();i++) {
			
			System.out.println(pos.get(i).getText()+"  "+team.get(i).getText()+"  "+matches.get(i).getText()+"  "+matchesWon.get(i).getText()+"  "+matchesLost.get(i).getText()+"  "+matchesDraw.get(i).getText());
		}

		driver.quit();
	}

}
