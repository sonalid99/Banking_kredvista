package com.internetBanking;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ObjectRepo.AddBeneficieryPage;
import com.ObjectRepo.CustomerHomePage;
import com.ObjectRepo.FundTransferPage;
import com.ObjectRepo.InternetBankingHomePage;
import com.ObjectRepo.InternetBankingLoginPage;
import com.ObjectRepo.OTPFundTransferPage;
import com.onlinebanking.kredvista.GenericUtils.ExcelUtil;
import com.onlinebanking.kredvista.GenericUtils.FileUtils;
import com.onlinebanking.kredvista.GenericUtils.JavaUtils;
import com.onlinebanking.kredvista.GenericUtils.ReInitClass;
import com.onlinebanking.kredvista.GenericUtils.WebDriverUtils;

@Listeners(com.onlinebanking.kredvista.GenericUtils.ListenerImplementation.class)
public class InternetBankingUsingGenericLibAndPOMTest extends ReInitClass {
	
	@Test
        public void internetBankingTest() throws IOException, InterruptedException{
		
		FileUtils fLib=new FileUtils();
		ExcelUtil eLib=new ExcelUtil();
		WebDriverUtils wLib=new WebDriverUtils();
		JavaUtils jLib=new JavaUtils();
		
		String URL=fLib.readDataInPropertFile("url");
		
		String CUSTOMERID=fLib.readDataInPropertFile("customerId");
		
		String PASSWORD=fLib.readDataInPropertFile("password");
		
		driver.get(URL);
		
		wLib.waitForPageLoad(driver, 10);
				
		CustomerHomePage cuHome=new CustomerHomePage(driver);
		cuHome.internetBankingLogin(driver,wLib);
		
		//Login
		InternetBankingLoginPage iBLogin=new InternetBankingLoginPage(driver);
		iBLogin.LoginTointernetBanking(CUSTOMERID, PASSWORD);
		Thread.sleep(1000);
		
		Assert.fail();
		
		//click on fund transfer
		InternetBankingHomePage iBHome=new InternetBankingHomePage(driver);
		iBHome.fundTransfer();
				
		//add beneficiery
		FundTransferPage fund=new FundTransferPage(driver);
		fund.addBeneficiaryButton();
		
		Thread.sleep(1000);

		//enter the fields in add beneficiary
		HashMap<String, String> map = eLib.readMultipleData("addBeneficiary", driver);
		
		AddBeneficieryPage addBenf=new AddBeneficieryPage(driver);
		//addBenf.toReadMultipleDataFromExcel(driver, jLib, map);
		addBenf.addBenefieciaryButton();

		wLib.alertPopupAccept(driver);
		
		iBHome.fundTransfer();
		
		//send amount to beneficiary
		fund.selectBeneficierySendAmount();
		
        
		//Verify OTP
		OTPFundTransferPage otp=new OTPFundTransferPage(driver);
		
		otp.OTPverify();
		
       
         wLib.alertPopupAccept(driver);
         
         //logout as user A
         iBHome.logoutButton();
         
         
         String CUSTID = fLib.readDataInPropertFile("custid");
         
         String CUSTPASSWORD = fLib.readDataInPropertFile("custpassword");
        		 
         InternetBankingLoginPage ilp=new InternetBankingLoginPage(driver);
         
         ilp.LoginTointernetBanking(CUSTID, CUSTPASSWORD);
         
       //my account
         iBHome.myAccount();
 		 		
 		String balance= iBHome.currentBalance();
 		
 		System.out.println("Updated balance"+balance);
 		
		
	}

}



