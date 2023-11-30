package com.staffModule;


import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ObjectRepo.CreditCustomerPage;
import com.ObjectRepo.CustomerHomePage;
import com.ObjectRepo.StaffHomePage;
import com.ObjectRepo.StaffLoginPage;
import com.ObjectRepo.ViewActiveCustomerPage;
import com.onlinebanking.kredvista.GenericUtils.ExcelUtil;
import com.onlinebanking.kredvista.GenericUtils.FileUtils;
import com.onlinebanking.kredvista.GenericUtils.WebDriverUtils;

@Listeners(com.onlinebanking.kredvista.GenericUtils.ListenerImplementation.class)
public class ViewCustomerCreditCheckBalancePOMTest {
	
	@Test
	public void staffModuleTest2() throws IOException, InterruptedException {
		
		FileUtils fLib=new FileUtils();
		ExcelUtil eLib=new ExcelUtil();
		WebDriverUtils wLib=new WebDriverUtils();
		
		String URL = fLib.readDataInPropertFile("url");
		String STAFFID = fLib.readDataInPropertFile("staffid");
		String STAFFPASSWORD = fLib.readDataInPropertFile("staffpassword");
		
		//launch empty browser
		WebDriver driver=new ChromeDriver();
		
		wLib.maximizeWindow(driver);
		
		Thread.sleep(10000);
		//enter url
		driver.get(URL);
		
		wLib.waitForPageLoad(driver, 10);
		
		//click on staff login button
		CustomerHomePage chp=new CustomerHomePage(driver);
		
		chp.staffLoginButton();
		
		//staff login
		StaffLoginPage slp=new StaffLoginPage(driver);
		
		slp.staffLogin(STAFFID, STAFFPASSWORD);
				
		//click on view active customer tab
		StaffHomePage shp=new StaffHomePage(driver);
		
		shp.viewActiveCustomer();
				
		//CHECK IF THE ACCOUNT NO CREATED IS PRESENT OR NOT BY SCROLLING TO THE END OF THE PAGE.
		//account no  =1011951011621 it is active or not

		//find account detail
		ViewActiveCustomerPage vcp=new ViewActiveCustomerPage();
		
		vcp.custDetailsAndBalance(driver);

	  
		//CLICK ON HOME BUTTON
		shp.homeButton();
		
		//Click on credit customer tab
		shp.creditCustomer();
		
		//credit to customer
		CreditCustomerPage ccp=new CreditCustomerPage(driver);
	    
	    ccp.creditToCustomer();
	   
	    //handle pop up
	    String confirm=wLib.alertPopupgetText(driver);
	    wLib.alertPopupAccept(driver);
	    
	    if(confirm.contains("Amount credited Successfully")) {
		System.out.println("amount credit");
	}

	
	    //Click on staff home button
	    shp.homeButton();
	    	
	    //click on view Active Button in Active customer button
	    shp.viewActiveCustomer();
			
	   
	    //cusDetail=driver.findElement(By.xpath("//div[@class='active_customers_container']//td[text()='1011951011621']")).getText();
        vcp.updatedCustomerBalance(driver);
        

	//close the browser
	driver.quit();
		
	}
		

}
