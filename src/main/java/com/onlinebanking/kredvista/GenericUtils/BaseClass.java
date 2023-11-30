
package com.onlinebanking.kredvista.GenericUtils;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.ObjectRepo.CustomerHomePage;
import com.ObjectRepo.StaffHomePage;
import com.ObjectRepo.StaffLoginPage;

public class BaseClass {

	public DatabaseUtils dLib=new DatabaseUtils();
	public FileUtils fLib=new FileUtils();
	public ExcelUtil eLib=new ExcelUtil();
	public WebDriverUtils wLib=new WebDriverUtils();
	public WebDriver driver;
	public static WebDriver sdriver;
	
	@BeforeSuite(alwaysRun = true)
	public void config_DB() throws Throwable {
		dLib.connectDB();
		System.out.println("---connect to DB---");
	}
	
	//@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
	public void config_BC() throws IOException {
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
	
	@BeforeMethod(alwaysRun = true)
	public void config_BM() throws IOException {
		String URL=fLib.readDataInPropertFile("url");
		String USERNAME=fLib.readDataInPropertFile("staffid");
		String PASSWORD=fLib.readDataInPropertFile("staffpassword");
		
		
		driver.get(URL);
		wLib.waitForPageLoad(driver, 10);

		CustomerHomePage chp=new CustomerHomePage(driver);
		chp.staffLoginButton();
		
		StaffLoginPage slp=new StaffLoginPage(driver);
		slp.staffLogin(USERNAME, PASSWORD);
		
		System.out.println("---staff login---");
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void config_AM() {
		StaffHomePage shp= new StaffHomePage(driver);
		shp.staffLogoutButton();
		System.out.println("---Logout---");
	}
	
	@AfterClass(alwaysRun = true)
	public void config_AC() {
		//driver.quit();
		//System.out.println("---Close browser----");
	}
	
	@AfterSuite(alwaysRun = true)
	public void config_AS() throws SQLException {
		dLib.disconnectDatabase();
	}
	
}
