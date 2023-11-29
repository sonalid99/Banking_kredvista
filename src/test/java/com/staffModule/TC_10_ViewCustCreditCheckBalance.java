package com.staffModule;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC_10_ViewCustCreditCheckBalance {
	
	@Test
	public void staffModuleTest2() throws IOException, InterruptedException {
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\BankingCommonData.properties.txt");
		
		Properties p=new Properties();
		
		p.load(fis);
		
		String URL = p.getProperty("url");
		
		String STAFFID = p.getProperty("staffid");
		
		String STAFFPASSWORD = p.getProperty("staffpassword");
		
		//launch empty browser
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		//enter url
		driver.get(URL);
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		//click on staff login button
		driver.findElement(By.xpath("//a[text()='Staff Login']")).click();
		
		//enter username
		driver.findElement(By.name("staff_id")).sendKeys(STAFFID);
		
		//enter password
		driver.findElement(By.name("password")).sendKeys(STAFFPASSWORD);
		
		//click on login button
		driver.findElement(By.name("staff_login-btn")).click();
		
		//click on view active customer tab
		driver.findElement(By.name("viewdet")).click();
		
		//CHECK IF THE ACCOUNT NO CREATED IS PRESENT OR NOT BY SCROLLING TO THE END OF THE PAGE.
		//account no  =1011951011621 it is active or not

		//find account detail
		String	cusDetail=driver.findElement(By.xpath("//div[@class='active_customers_container']//td[text()='1011951011621']")).getText();
		
		//check current bal
		String bal=driver.findElement(By.xpath("//td[text()='1011951011621']/../td[8]")).getText();
		
		bal=bal.replace("$", "");
		
		double balance=Double.parseDouble(bal);
		
		System.out.println("Available balance = "+balance);
	   
	  
		//CLICK ON HOME BUTTON
		driver.findElement(By.xpath("//input[@name='home']")).click();
		
		driver.findElement(By.name("credit_cust_ac")).click();
		
	    driver.findElement(By.xpath("//input[@name='customer_account_no']")).sendKeys("1011951011621");
	
	    driver.findElement(By.name("credit_amount")).sendKeys("1000");
	
	    driver.findElement(By.name("credit_btn")).click();
	
	
	    //handle pop up
	    String confrm=driver.switchTo().alert().getText();
	
	    driver.switchTo().alert().accept();
	
	    if(confrm.contains("Amount credited Successfully")) {
		System.out.println("amount credit");
	}

	
	    //Click on staff home button
	    driver.findElement(By.xpath("//input[@name='home']")).click();
	
	    //click on view Active Button in Active customer button
	    driver.findElement(By.name("viewdet")).click();
			
	    //cusDetail=driver.findElement(By.xpath("//div[@class='active_customers_container']//td[text()='1011951011621']")).getText();
        String UpdatedBalance=driver.findElement(By.xpath("//td[text()='1011951011621']/../td[8]")).getText();
			
       //remove $ for validate balance
	   UpdatedBalance=UpdatedBalance.replace("$", "");
	   
	   double updbal=Double.parseDouble(UpdatedBalance);
	   
	   System.out.println("Updated balance= "+updbal);
			
	   //validate the test case
			
	   if((balance+1000)==updbal) {
	   System.out.println("Balance successfully upadated and Test pass");
	}
	else {
		System.out.println("test case failed");
	}

	//close the browser
	driver.quit();
		
	}
		
}
