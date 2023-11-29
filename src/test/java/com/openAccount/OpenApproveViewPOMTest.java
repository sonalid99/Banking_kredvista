package com.openAccount;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ObjectRepo.ApproveCustomerPage;
import com.ObjectRepo.CustomerHomePage;
import com.ObjectRepo.OpenAccountPage;
import com.ObjectRepo.StaffHomePage;
import com.ObjectRepo.StaffLoginPage;
import com.ObjectRepo.ViewActiveCustomerPage;
import com.onlinebanking.kredvista.GenericUtils.ExcelUtil;
import com.onlinebanking.kredvista.GenericUtils.FileUtils;
import com.onlinebanking.kredvista.GenericUtils.JavaUtils;
import com.onlinebanking.kredvista.GenericUtils.WebDriverUtils;

@Listeners(com.onlinebanking.kredvista.GenericUtils.ListenerImplementation.class)
public class OpenApproveViewPOMTest {

	@Test()
	public void TC_01() throws IOException, InterruptedException, Throwable
	{
		FileUtils fLib=new FileUtils();
		ExcelUtil eLib=new ExcelUtil();
		WebDriverUtils wLib=new WebDriverUtils();
		JavaUtils jLib=new JavaUtils();
		
	    //property file handling for common data
		String URL=fLib.readDataInPropertFile("url");	
		String STAFFUSERNAME=fLib.readDataInPropertFile("staffid");
		String STAFFPASSWORD=fLib.readDataInPropertFile("staffpassword"); 
	
		
	//launch browser & navigate to application
	WebDriver driver=new ChromeDriver();
	wLib.maximizeWindow(driver);
	driver.get(URL);
	wLib.waitForPageLoad(driver, 10);
	
	//click on open account tab 
	CustomerHomePage chp=new CustomerHomePage(driver);
	chp.openAccount();
	
	//get random number
	int random = jLib.getRandomNo();
	
	//excel file handling for testscript data
	HashMap<String,String> map=eLib.readMultipleData("Openaccount", driver);
	
	//handling calendar popup
	OpenAccountPage oap=new OpenAccountPage(driver);
	oap.dobCalendarPopup();
	
	
	//click on submit button
	oap.submitButton();
	
	//click on confirm button
	oap.confirmSubmitButton();
	
	String text = wLib.alertPopupgetText(driver);
	wLib.alertPopupAccept(driver);
	
	String aplNo="";
	for(int i=0;i<text.length();i++)
	{
		if(Character.isDigit(text.charAt(i)))
		{
			aplNo=aplNo+text.charAt(i);
		}
	}
	
	//click on staff login button
	chp.staffLoginButton();
	
	StaffLoginPage slp=new StaffLoginPage(driver);
	slp.staffLogin(STAFFUSERNAME, STAFFPASSWORD);
	
	StaffHomePage shp=new StaffHomePage(driver);
	
	//click on approve customer tab
	shp.approveCustomer();
			
	ApproveCustomerPage acp=new ApproveCustomerPage(driver);

	//enter the application number
	acp.approveCustomerText(aplNo);
	
	Thread.sleep(3000);
		
	try
	{
		//click on approve button
		acp.approveCustomerBtn();
	
	
	wLib.alertPopupAccept(driver);
	
	Thread.sleep(3000);

	}
	catch(Exception e)
	{
		System.err.println("Failed");
	}
	Thread.sleep(3000);

	//click on staff home 
	shp.homeButton();
		
	//click on view active customer
	shp.viewActiveCustomer();	

	ViewActiveCustomerPage vacp=new ViewActiveCustomerPage();
	
	//validate the approved customer is visible by using PAN no
	vacp.validateCustByPAN(driver);
	
	/*String expectedPanNo=map.get("pan_no");
	
	List<WebElement> panNos = driver.findElements(By.xpath("//tbody//td[9]"));
	boolean flag=false;
	for(WebElement actualPanNo:panNos)
	{
		if(actualPanNo.getText().equals(expectedPanNo))
		{
			System.out.println("Acc details found in active customer section");
			flag=true;
			break;
		}
	}
	if(!flag)
	{
		System.err.println("Acc details not found in active customer section");
	}*/
	
	//close browser
	driver.quit();
	
	}
}
