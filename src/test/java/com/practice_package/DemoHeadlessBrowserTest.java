package com.practice_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DemoHeadlessBrowserTest {

	public static void main(String[] args) {
		
		ChromeOptions option = new ChromeOptions();
		option.setHeadless(true);
		WebDriver driver= new ChromeDriver(option);
		driver.get("https://www.google.com/");
		String title = driver.getTitle();
		System.out.println(title);
		driver.quit();
	}
}
