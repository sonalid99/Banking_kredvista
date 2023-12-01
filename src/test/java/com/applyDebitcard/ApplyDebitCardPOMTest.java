package com.applyDebitcard;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.ObjectRepo.ApplyDebitCardPage;
import com.ObjectRepo.ApproveCustomerPage;
import com.ObjectRepo.CustomerHomePage;
import com.ObjectRepo.OpenAccountPage;
import com.ObjectRepo.StaffHomePage;
import com.ObjectRepo.StaffLoginPage;
import com.onlinebanking.kredvista.GenericUtils.ExcelUtil;
import com.onlinebanking.kredvista.GenericUtils.FileUtils;
import com.onlinebanking.kredvista.GenericUtils.JavaUtils;
import com.onlinebanking.kredvista.GenericUtils.WebDriverUtils;

public class ApplyDebitCardPOMTest {

	@Test
	public void TC_13() throws Throwable
	{
		
	FileUtils fLib=new FileUtils();
	ExcelUtil eLib=new ExcelUtil();
	WebDriverUtils wLib= new WebDriverUtils();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	JavaUtils jLib=new JavaUtils();
	OpenAccountPage oap=new OpenAccountPage(driver);
	CustomerHomePage chp=new CustomerHomePage(driver);
	
	String URL=fLib.readDataInPropertyFile("url");
	String BROWSER=fLib.readDataInPropertyFile("browser");
	String STAFFUSERNAME=fLib.readDataInPropertyFile("staffid");
	String STAFFPASSWORD=fLib.readDataInPropertyFile("staffPassword");
	
	int random=jLib.getRandomNo();
	
	//excel file handling for testscript data
	eLib.writeDataIntoExcel("Openaccount",5, 1, "pan1234"+random );
	HashMap<String, String> mapOpenAcc=eLib.readMultipleData("OpenAccount", driver);
	HashMap<String, String> mapDebitCard=eLib.readMultipleData("ApplyDebitCard", driver);
	
	//launch browser & navigate to application
	driver=new ChromeDriver();

	wLib.maximizeWindow(driver);
	
	driver.get(URL);
	
	wLib.waitForPageLoad(driver, 30);
	
	
	//click on open account tab 
	chp.openAccount();

	
	//online account opening form page filling textfield filling
	eLib.readMultipleData("OpenAccount", driver);
	oap.dobCalendarPopup();
	oap.submitButton();
	
	//confirm account opening form
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
	
	
	//click on staff login link in homepage
	chp.staffLoginButton();
	
	//staff login
	StaffLoginPage slp=new StaffLoginPage(driver);
	slp.staffLogin(STAFFUSERNAME, STAFFPASSWORD);
	
	//click on approve pending Acc tab in staff homepage	
	StaffHomePage shp=new StaffHomePage(driver);
	shp.approveCustomer();
	

	//approving account
	ApproveCustomerPage acp=new ApproveCustomerPage(driver);
	acp.approveCustomerText(aplNo);
	acp.approveCustomerBtn();
	
	//view active cust and fetch acc no from pan no
	shp.viewActiveCustomer();
	//driver.findElement(By.name("viewdet")).click();
	String expectedPanNo=mapOpenAcc.get("pan_no");
	
	//get acc no from pan no
	//ActiveCustomerPage acp=new ActiveCustomerPage(driver);
	 
	//String accNo=acp.FindCustomerAccNoFromPan(expectedPanNo, driver);
	String accNo = driver.findElement(By.xpath("//tr/td[.='"+expectedPanNo+"']/preceding-sibling::td[5]")).getText();
	mapDebitCard.put("acc_no", accNo);
	
	//click on logout
	shp.staffLogoutButton();
	
	//driver.findElement(By.name("logout_btn")).click();
	
	//click on customer home button
	chp.homeButton();
	
	//driver.findElement(By.xpath("//img[@class='logo_img']")).click();
	
	
	//apply for debit card
	chp.debitCard();
	
	ApplyDebitCardPage adcp=new ApplyDebitCardPage(driver);
	adcp.applyDebitCard(mapDebitCard, driver);

	adcp.submitButton();
	
	driver.quit();
	
	}
	
}
