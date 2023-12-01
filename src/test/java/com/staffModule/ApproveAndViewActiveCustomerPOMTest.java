package com.staffModule;

import java.awt.AWTException;
import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.ObjectRepo.ApproveCustomerPage;
import com.ObjectRepo.CustomerHomePage;
import com.ObjectRepo.OpenAccountPage;
import com.ObjectRepo.StaffHomePage;
import com.ObjectRepo.StaffLoginPage;
import com.onlinebanking.kredvista.GenericUtils.ExcelUtil;
import com.onlinebanking.kredvista.GenericUtils.FileUtils;
import com.onlinebanking.kredvista.GenericUtils.JavaUtils;
import com.onlinebanking.kredvista.GenericUtils.WebDriverUtils;

public class ApproveAndViewActiveCustomerPOMTest {

	//declared global variables
	public WebDriver driver;
		String aplNo="";
		FileUtils fLib=new FileUtils();
		

		@Test(dependsOnMethods="generateApplNo")
		public void approveAndView() throws IOException, InterruptedException {
			
			
			String URL =fLib.readDataInPropertyFile("url");
			String STAFFID =fLib.readDataInPropertyFile("staffid");
			String STAFFPASSWORD = fLib.readDataInPropertyFile("staffpassword");

			//launch empty browser
			WebDriverUtils wLib=new WebDriverUtils();
			wLib.maximizeWindow(driver);
			
			//enter url
			driver.get(URL);
			
			wLib.waitForPageLoad(driver, 10);

			
			//click on staff login button
			CustomerHomePage chp=new CustomerHomePage(driver);
			chp.staffLoginButton();
			
			
			//enter username
			StaffLoginPage slp=new StaffLoginPage(driver);
			slp.staffLogin(STAFFID, STAFFPASSWORD);
			
			//click on approve customer tab
			StaffHomePage shp=new StaffHomePage(driver);
			shp.approveCustomer();			
			
			//enter application number
			ApproveCustomerPage acp=new ApproveCustomerPage(driver);
			acp.approveCustomerText(aplNo);
			
			Thread.sleep(1000);
				
			//handle alert popup
			try
			{
			acp.approveCustomerBtn();
			wLib.alertPopupAccept(driver);
			
			Thread.sleep(1000);

			}
			catch(Exception e)
			{
				System.err.println("Failed");
			}
			Thread.sleep(1000);

			//click on staff home
			shp.homeButton();
			
			//click on view active customer tab
			shp.viewActiveCustomer();
			
			driver.quit();
		}
			
			@Test
			public void generateApplNo() throws IOException, AWTException {
				
				//property file handling for common data
				FileUtils fLib=new FileUtils();
				
				String URL=fLib.readDataInPropertyFile("url");
		
				ExcelUtil eLib=new ExcelUtil();
	
				JavaUtils jLib=new JavaUtils();
				//jLib.getRandomNo();
				
				//launch browser & navigate to application
				driver=new ChromeDriver();
				
				WebDriverUtils wLib=new WebDriverUtils();
				wLib.maximizeWindow(driver);
				
				driver.get(URL);
				
				wLib.waitForPageLoad(driver, 10);
				
				//click on open account tab 
				CustomerHomePage chp=new CustomerHomePage(driver);
                 chp.openAccount();
									
				HashMap<String, String> map = eLib.readMultipleData("Openaccount", driver);
		
				//handling calender popup
				OpenAccountPage oap=new OpenAccountPage(driver);
				oap.dobCalendarPopup();
				
				 
				//click on open account submit button 
				oap.submitButton();
				
				//click on confirm button 
				oap.confirmSubmitButton();
				
				//handle popup
				String text = wLib.alertPopupgetText(driver);
				wLib.alertPopupAccept(driver);
				
				//capture the application number
				for(int i=0;i<text.length();i++)
				{
					if(Character.isDigit(text.charAt(i)))
					{
						aplNo=aplNo+text.charAt(i);
					}
				}
				System.out.println("Application No : "+aplNo);
				

				
			}

			
}
