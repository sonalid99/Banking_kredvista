package com.staffModule;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
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

import com.onlinebanking.kredvista.GenericUtils.FileUtils;
import com.onlinebanking.kredvista.GenericUtils.WebDriverUtils;

public class TC_03_ApproveAndActiveCustomer {
	
	//declared global variable for storing application no
	String aplNo="";
	
	@Test(dependsOnMethods="generateApplNo")
	public void approveAndView() throws IOException, InterruptedException {
		
		FileUtils fLib=new FileUtils();
		WebDriverUtils wLib=new WebDriverUtils();
		
		String URL =fLib.readDataInPropertFile("url");
		String STAFFID =fLib.readDataInPropertFile("staffid");
		String STAFFPASSWORD = fLib.readDataInPropertFile("staffpassword");

		//launch empty browser
		WebDriver driver=new ChromeDriver();
		
		wLib.maximizeWindow(driver);
		
		//enter url
		driver.get(URL);
		
		wLib.waitForPageLoad(driver, 10);

		
		//click on staff login button
		driver.findElement(By.xpath("//a[text()='Staff Login']")).click();
		
		//enter username
		driver.findElement(By.name("staff_id")).sendKeys(STAFFID);
		
		
		driver.findElement(By.name("password")).sendKeys(STAFFPASSWORD);
		
		driver.findElement(By.name("staff_login-btn")).click();
		
		//click on approve pending customer tab
		driver.findElement(By.name("apprvac")).click();
		
		driver.findElement(By.name("application_no")).sendKeys(aplNo);
		
		driver.findElement(By.name("search_application")).click();
		
		Thread.sleep(3000);
			
		try
		{
		driver.findElement(By.name("approve_cust")).click();
		Alert a=driver.switchTo().alert();
		a.accept();
		Thread.sleep(3000);

		}
		catch(Exception e)
		{
			System.err.println("Failed");
		}
		Thread.sleep(3000);

		driver.findElement(By.name("home")).click();
		driver.findElement(By.name("viewdet")).click();
		
	}
		
		@Test
		public void generateApplNo() throws IOException {
			
			//property file handling for common data
			FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\BankingCommonData.properties.txt");
			Properties p=new Properties();
			p.load(fis);
			
			String URL=p.getProperty("url");
			
			//excel file handling for testscript data
			FileInputStream fs=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
			Workbook workbook = WorkbookFactory.create(fs);
			Sheet sheet = workbook.getSheet("Openaccount");
			
			Random r=new Random();
			int random=r.nextInt(1000);
			
			
			//create a empty hashmap
			HashMap<String, String> map=new HashMap<String, String>();
			
			int lastRowInd=sheet.getLastRowNum();
			for(int i=0;i<=lastRowInd;i++)
			{
				String key=sheet.getRow(i).getCell(0).getStringCellValue();
				String value=sheet.getRow(i).getCell(1).getStringCellValue();
				map.put(key, value);
			}
			
			
			
			//launch browser & navigate to application
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(URL);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			
			//click on open account tab 
			driver.findElement(By.xpath("//li[.='Open Account']")).click();
			

			
			//online account opening form page filling textfield filling
			for(Entry<String, String> set:map.entrySet())
			{
				if(set.getKey().equals("pan_no"))
				{
					driver.findElement(By.name(set.getKey())).sendKeys(set.getValue()+random);
				}
				else
				{
				driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
				}
			}
			//gender DD handling in acc opening page
			WebElement genderDD = driver.findElement(By.name("gender"));
			Select select=new Select(genderDD);
			select.selectByVisibleText(map.get("gender"));
			
			//handling calender popup
			 WebElement calenderPopUp = driver.findElement(By.name("dob"));
			 JavascriptExecutor js=(JavascriptExecutor) driver;
			 js.executeScript("arguments[0].value='12122000'", calenderPopUp);
			
			 
			 //handling city dropdwon
			 WebElement cityDD = driver.findElement(By.name("city"));
			 select=new Select(cityDD);
			 select.selectByVisibleText(map.get("city"));
			 
			 driver.findElement(By.name("submit")).click();
			 
			
			driver.findElement(By.name("cnfrm-submit")).click();
			
			Alert alert=driver.switchTo().alert();
			String text=alert.getText();
			alert.accept();
			
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


