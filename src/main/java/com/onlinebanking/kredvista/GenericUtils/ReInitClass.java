package com.onlinebanking.kredvista.GenericUtils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class ReInitClass {

	FileUtils fLib=new FileUtils();
	WebDriverUtils wLib=new WebDriverUtils();
	
	public WebDriver driver;
	public static WebDriver sdriver;
	
	@BeforeClass
	public void reinitBrowser() throws IOException {
		driver=new ChromeDriver();
		String BROWSER=fLib.readDataInPropertFile("browser");
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("---Invalid browser----");
		}
		
		sdriver=driver;
		
		wLib.maximizeWindow(driver);
		System.out.println("---Open Browser---");
		

	}
	
	@AfterClass
	public void closeBrowser() {
		
		driver.quit();
	}
}
