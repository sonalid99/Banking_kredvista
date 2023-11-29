package com.practice_package;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonPriceCheckTest {

	public static void main(String[] args) throws InterruptedException {
		
WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in/");
		
		Thread.sleep(20000);
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Iphone"+Keys.ENTER);
				
		List<WebElement> phoneNames= driver.findElements(By.xpath("//span[contains(text(),'iPhone ')]"));
		
		
		for(int i=0; i<phoneNames.size();i++) {
			String phone= phoneNames.get(i).getText();
			String price= driver.findElement(By.xpath("//span[contains(text(),'"+phone+"')]/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']//span[@class='a-price']")).getText();

			
			String r=price.replace(",", "");
			
			int p =Integer.parseInt(r);
			
			if(p<=60000) {
				
				System.out.println(phone+" ---> "+price);

	}

}
	}
}
