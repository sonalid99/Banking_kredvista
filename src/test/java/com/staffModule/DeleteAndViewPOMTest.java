package com.staffModule;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ObjectRepo.CustomerHomePage;
import com.ObjectRepo.DeleteCustomerPage;
import com.ObjectRepo.StaffHomePage;
import com.ObjectRepo.StaffLoginPage;
import com.ObjectRepo.ViewActiveCustomerPage;
import com.onlinebanking.kredvista.GenericUtils.BaseClass;
import com.onlinebanking.kredvista.GenericUtils.ExcelUtil;
import com.onlinebanking.kredvista.GenericUtils.FileUtils;
import com.onlinebanking.kredvista.GenericUtils.WebDriverUtils;

@Listeners(com.onlinebanking.kredvista.GenericUtils.ListenerImplementation.class)
public class DeleteAndViewPOMTest extends BaseClass {

	@Test(retryAnalyzer = com.onlinebanking.kredvista.GenericUtils.RetryImplementClass.class)
	public void deleteModuleTest() throws IOException, InterruptedException {
		
		FileUtils fLib=new FileUtils();
		ExcelUtil eLib=new ExcelUtil();
		WebDriverUtils wLib=new WebDriverUtils();
		StaffHomePage shp=new StaffHomePage(driver);
		
		shp.deleteCustomer();
		
		eLib.readMultipleData("Deleteaccount", driver);
		
		//enter details of customer
		DeleteCustomerPage dcp=new DeleteCustomerPage(driver);

		//click on delete button
		dcp.deleteButton();
		
		//Assert.fail();
		
	    //alert popup after delete
	    wLib.alertPopupAccept(driver);
		
		Thread.sleep(1000);
		
		shp.homeButton();
				
		shp.viewActiveCustomer();
		
		ViewActiveCustomerPage vcp=new ViewActiveCustomerPage();
				
		vcp.validate(driver);
		

	}
	}

