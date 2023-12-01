package com.internetBanking;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ObjectRepo.AddBeneficieryPage;
import com.ObjectRepo.CustomerHomePage;
import com.ObjectRepo.FundTransferPage;
import com.ObjectRepo.InternetBankingHomePage;
import com.ObjectRepo.InternetBankingLoginPage;
import com.ObjectRepo.InternetBankingRegistrationPage;
import com.onlinebanking.kredvista.GenericUtils.ExcelUtil;
import com.onlinebanking.kredvista.GenericUtils.FileUtils;
import com.onlinebanking.kredvista.GenericUtils.JavaUtils;
import com.onlinebanking.kredvista.GenericUtils.WebDriverUtils;

@Listeners(com.onlinebanking.kredvista.GenericUtils.ListenerImplementation.class)
public class TC_32_RegisterLoginFundTransferAddAndViewBeneficiaryPOMTest {

	@Test
	public void InternetBankingRegisterFundTrasfer() throws IOException, InterruptedException {
		
		FileUtils fLib=new FileUtils();
		ExcelUtil eLib=new ExcelUtil();
		WebDriverUtils wLib=new WebDriverUtils();
		JavaUtils jLib=new JavaUtils();
		
		String URL=fLib.readDataInPropertyFile("url");
		
		String CUSTOMERID=fLib.readDataInPropertyFile("customerId");
		
		String PASSWORD=fLib.readDataInPropertyFile("password");
		
		WebDriver driver=new ChromeDriver();
		
		wLib.maximizeWindow(driver);
		
		driver.get(URL);
		
		wLib.waitForPageLoad(driver, 10);
		
		//Click on internet banking register tab
		CustomerHomePage cuHome=new CustomerHomePage(driver);
		cuHome.internetBankingRegister(driver);
		Thread.sleep(2000);

		//Internet banking registration page
		InternetBankingRegistrationPage ibr=new InternetBankingRegistrationPage(driver);
		ibr.registerToInternetBanking();
		Thread.sleep(2000);
		
		//Login
		InternetBankingLoginPage iBLogin=new InternetBankingLoginPage(driver);
		iBLogin.LoginTointernetBanking(CUSTOMERID, PASSWORD);
		Thread.sleep(1000);
		
		//click on myAccount
		InternetBankingHomePage ibh=new InternetBankingHomePage(driver);
		ibh.myAccount();
		
		//click on fund transfer tab
		ibh.fundTransfer();
		
		//add beneficiary
		FundTransferPage fund=new FundTransferPage(driver);
		fund.addBeneficiaryButton();
				
		Thread.sleep(1000);
		
		//enter the fields in add beneficiary
		HashMap<String, String> map = eLib.readMultipleData("addBeneficiary", driver);
				
		AddBeneficieryPage addBenf=new AddBeneficieryPage(driver);
		//addBenf.toReadMultipleDataFromExcel(driver, jLib, map);
		addBenf.addBenefieciaryButton();
		
		//handle alert popup
		wLib.alertPopupAccept(driver);
		
		//click on fund transfer tab
		ibh.fundTransfer();
		
		//click on view beneficiary tab
		fund.viewBeneficiary();
		
		//click on logout
		ibh.logoutButton();
		
		//close browser
		driver.quit();

		
		
	}
	
}
