package com.practice_package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CribuzzNewTest {

	public static void main(String[] args) {

        WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.cricbuzz.com/");
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		WebElement score=driver.findElement(By.xpath("//span[text()='ENG']/ancestor::div[@class='cb-hmscg-tm-bat-scr cb-font-14']//div[@class='cb-col-50 cb-ovr-flo']"));
		
		System.out.println(score.getText());
		
		driver.quit();
	}

}
