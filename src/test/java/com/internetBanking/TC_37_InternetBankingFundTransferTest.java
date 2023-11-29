package com.internetBanking;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.commons.math3.fraction.ProperBigFractionFormat;
import org.apache.poi.hpsf.Property;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.onlinebanking.kredvista.GenericUtils.ExcelUtil;
import com.onlinebanking.kredvista.GenericUtils.FileUtils;
import com.onlinebanking.kredvista.GenericUtils.JavaUtils;
import com.onlinebanking.kredvista.GenericUtils.WebDriverUtils;

public class TC_37_InternetBankingFundTransferTest {
	
	@Test
	public void internetBankingTest() throws IOException, InterruptedException{
		
		FileUtils fLib=new FileUtils();
		ExcelUtil eLib=new ExcelUtil();
		WebDriverUtils wLib=new WebDriverUtils();
		JavaUtils jLib=new JavaUtils();
		
		String URL=fLib.readDataInPropertFile("url");
		
		String CUSTOMERID=fLib.readDataInPropertFile("customerId");
		
		String PASSWORD=fLib.readDataInPropertFile("password");

		
		WebDriver driver=new ChromeDriver();
		
		wLib.maximizeWindow(driver);
		
		driver.get(URL);
		
		wLib.waitForPageLoad(driver, 10);
		
		Thread.sleep(3000);
		
		WebElement InternetBankingTab=driver.findElement(By.xpath("//div[@class='ebanking']"));
		
		wLib.mouseHover(driver, InternetBankingTab);
		
		//login tab
		driver.findElement(By.xpath("//li[contains(text(),'Login')]")).click();
		
		//username
		driver.findElement(By.xpath("//input[@name='customer_id']")).sendKeys(CUSTOMERID);
		
		//password
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(PASSWORD);
		
		//click on login
		driver.findElement(By.xpath("//input[@name='login-btn']")).click();
		
		//click on fund transfer
		driver.findElement(By.xpath("//li[text()='Fund Transfer']")).click();
		
		//add beneficiery
		driver.findElement(By.xpath("//input[@name='add_beneficiary']")).click();
		Thread.sleep(1000);

		//enter the fields in add beneficiary
		eLib.readMultipleData("addBeneficiary", driver);
		
		/*FileInputStream fs=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		Workbook wb = WorkbookFactory.create(fs);
		
		Sheet sh = wb.getSheet("addBeneficiary");
		
		int count= sh.getLastRowNum();
				
		HashMap<String, String> map= new HashMap<String, String>();
		
		for(int i=0;i<=count;i++) {
			
			String key= sh.getRow(i).getCell(0).getStringCellValue();
			
			String value= sh.getRow(i).getCell(1).getStringCellValue();
			
			map.put(key, value);
			
			
		}
		

	
		for(Entry<String,String> set:map.entrySet()) {
			
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
			
		}*/
		
		WebElement acc=driver.findElement(By.name("beneficiary_acc_type"));
		
		wLib.dropdown(acc, "Current");
		
		/*Select s = new Select(acc);
		
		s.selectByVisibleText("Current");*/
		
		driver.findElement(By.name("add_beneficiary_btn")).click();
		
		wLib.alertPopupAccept(driver);
		
		/*Alert al= driver.switchTo().alert();
		
		al.accept();*/
		
		driver.findElement(By.xpath("//li[text()='Fund Transfer']")).click();
		
        WebElement beneficiery=driver.findElement(By.name("beneficiary"));
        
        wLib.dropdown(beneficiery," Sarfaraz-101111011393 ");
        
        /*Select sl=new Select(beneficiery);
        
        sl.selectByVisibleText(" Sarfaraz-101111011393 ");*/
        
        String amount="500";
        
        driver.findElement(By.name("trnsf_amount")).sendKeys(amount);
        
        driver.findElement(By.name("trnsf_remark")).sendKeys("sending 500");
        
        driver.findElement(By.name("fnd_trns_btn")).click();
        
        WebElement ele=driver.findElement(By.xpath("//label[@class='OTP_msg']"));
        
        String text = ele.getText();
         String[] texts = text.split(":");
         String otp = texts[1];
         int num=Integer.parseInt(otp);
         System.out.println(num);
        
         driver.findElement(By.name("otpcode")).sendKeys(otp);
        
         driver.findElement(By.name("verify-btn")).click();
       
         wLib.alertPopupAccept(driver);
         
         /*Alert alt=driver.switchTo().alert();
         
         alt.accept();*/
         
         driver.findElement(By.name("logout_btn")).click();
         
         String CUSTID=fLib.readDataInPropertFile("custid");
         
         String CUSTPASSWORD = fLib.readDataInPropertFile("custpassword");
        		 
        /*String CUSTID = p.getProperty();
 		
 		String CUSTPASSWORD = p.getProperty("custpassword");*/
 		
 		//username
 		driver.findElement(By.xpath("//input[@name='customer_id']")).sendKeys(CUSTID);
 				
 		//password
 		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(CUSTPASSWORD);
 				
 		//click on login
 		driver.findElement(By.xpath("//input[@name='login-btn']")).click();
 		
 		//my account
 		driver.findElement(By.xpath("//li[text()='My Account']")).click();
 		
 		String balance= driver.findElement(By.xpath("//label[contains(text(),'Available Balance :$')]")).getText();
 		
 		System.out.println("Updated balance"+balance);
 		
		
	}

}
