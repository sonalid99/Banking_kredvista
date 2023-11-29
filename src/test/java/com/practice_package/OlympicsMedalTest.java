package com.practice_package;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OlympicsMedalTest {
	@Test
	public void testMethod() throws InterruptedException{
		
			
        WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		Thread.sleep(10000);
		
		//driver.findElement(By.id("onetrust-accept-btn-handler")).click();
				
		List<WebElement> team =driver.findElements(By.xpath("//div[@class='Tablestyles__CommonGrid-sc-xjyvs9-1 Tablestyles__Content-sc-xjyvs9-3 knZfST eVgKXR']//span[@class='styles__CountryName-sc-fehzzg-6 jYXabZ']"));
		
		List<WebElement> gold =driver.findElements(By.xpath("//span[@class='Medalstyles__Medal-sc-1tu6huk-1 gHnuPI']"));
		
		List<WebElement> silver =driver.findElements(By.xpath("//span[@class='Medalstyles__Medal-sc-1tu6huk-1 lzFVJ']"));
		
		List<WebElement> bronze =driver.findElements(By.xpath("//span[@class='Medalstyles__Medal-sc-1tu6huk-1 brSNnJ']"));

		List<WebElement> totalMedals =driver.findElements(By.xpath("//span[@class='OcsTextstyles__StyledText-sc-1a1i41u-0 cuettq text--sm-body']"));

		for(int i=0;i<team.size();i++) {
			
			System.out.println(team.get(i).getText()+" ==> "+gold.get(i).getText()+" ==> "+silver.get(i).getText()+" ==> "+bronze.get(i).getText()+" ==> "+totalMedals.get(i).getText());
		}

		driver.quit();
	}

}
