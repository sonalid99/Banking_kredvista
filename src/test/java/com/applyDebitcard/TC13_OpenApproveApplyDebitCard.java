package com.applyDebitcard;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Random;

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

import com.ObjectRepo.CustomerHomePage;
import com.ObjectRepo.OpenAccountPage;
import com.onlinebanking.kredvista.GenericUtils.ExcelUtil;
import com.onlinebanking.kredvista.GenericUtils.FileUtils;
import com.onlinebanking.kredvista.GenericUtils.JavaUtils;
import com.onlinebanking.kredvista.GenericUtils.WebDriverUtils;

@Listeners(com.onlinebanking.kredvista.GenericUtils.ListenerImplementation.class)
public class TC13_OpenApproveApplyDebitCard {
	
	@Test
	public void TC_13() throws IOException
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
	/*FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\BankingCommonData.properties.txt");
	Properties pObj=new Properties();
	pObj.load(fis);*/
	
	/*String URL=pObj.getProperty("url");
	String BROWSER=pObj.getProperty("browser");
	String STAFFUSERNAME=pObj.getProperty("staffid");
	String STAFFPASSWORD=pObj.getProperty("staffPassword");*/
	
	//excel file handling for testscript data
		
		
	/*FileInputStream fis1=new FileInputStream("src\\test\\resources\\TestData.xlsx");
	Workbook workbook = WorkbookFactory.create(fis1);
	Sheet sheet = workbook.getSheet("OpenAccount");
	Sheet debitCardSheet=workbook.getSheet("ApplyDebitCard");*/
	
		int random=jLib.getRandomNo();
		
	//Random r=new Random();
	//int random=r.nextInt(999);
	
		
	//FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
	
	//sheet.getRow(5).getCell(1).setCellValue(pan+random);
	//workbook.write(fos);
		String pan = "pan1234";
		eLib.writeDataIntoExcel("Openaccount", 5, 1, pan+random);
	
	//create a empty hashmap
	HashMap<String, String> mapOpenAcc=new HashMap<String, String>();
	HashMap<String, String> mapDebitCard=new HashMap<String, String>();
	
	//storing values from excel to map
	int lastRowIndOpenAcc=eLib.getLastRowNo("Openaccount");
	int lastRowIndDebitCard =eLib.getLastRowNo("applydebitcard");
	
	//int lastRowIndOpenAcc=openAccSheet.getLastRowNum();
	//int lastRowIndDebitCard = applyDebitCardSheet.getLastRowNum();
	eLib.readMultipleData("Openaccount", driver);
	eLib.readMultipleData("applydebitcard", driver);
	
	/*for(int i=0;i<lastRowIndOpenAcc;i++)
	{
		String key=sheet.getRow(i).getCell(0).getStringCellValue();
		String value=sheet.getRow(i).getCell(1).getStringCellValue();
		mapOpenAcc.put(key, value);
	}
	for(int i=0;i<=lastRowIndDebitCard;i++)
	{
		String key=debitCardSheet.getRow(i).getCell(0).getStringCellValue();
		String value=debitCardSheet.getRow(i).getCell(1).getStringCellValue();
		mapDebitCard.put(key, value);
	}*/
	
	
	
	
	//launch browser & navigate to application
	
	driver.get(URL);
	
	wLib.waitForPageLoad(driver, 20);
	
	//click on open account tab 
	chp.openAccount();
	
	//driver.findElement(By.xpath("//li[.='Open Account']")).click();
	
	//online account opening form page filling textfield filling
	for(Entry<String, String> set:mapOpenAcc.entrySet())
	{
		driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
	}
	//gender DD handling in acc opening page
	WebElement genderDD = driver.findElement(By.name("gender"));
	Select select=new Select(genderDD);
	select.selectByVisibleText(mapOpenAcc.get("gender"));
	
	//handling calender popup
	 WebElement calenderPopUp = driver.findElement(By.name("dob"));
	 JavascriptExecutor js=(JavascriptExecutor) driver;
	 js.executeScript("arguments[0].value='12122000'", calenderPopUp);
	
	 
	 //handling city dropdwon
	 WebElement cityDD = driver.findElement(By.name("city"));
	 select=new Select(cityDD);
	 select.selectByVisibleText(mapOpenAcc.get("city"));
	 
	 driver.findElement(By.name("submit")).click();
	 
	
	driver.findElement(By.name("cnfrm-submit")).click();
	
	//collecting application number from popup
	Alert alert=driver.switchTo().alert();
	String text=alert.getText();
	alert.accept();
	String appNo="";
	for(int i=0;i<text.length();i++)
	{
		if(Character.isDigit(text.charAt(i)))
		{
			appNo=appNo+text.charAt(i);
		}
	}
	
	//staff login
	driver.findElement(By.linkText("Staff Login")).click();
	driver.findElement(By.name("staff_id")).sendKeys(STAFFUSERNAME);
	driver.findElement(By.name("password")).sendKeys(STAFFPASSWORD);
	driver.findElement(By.name("staff_login-btn")).click();
	
	//approving account
	driver.findElement(By.name("apprvac")).click();
	driver.findElement(By.name("application_no")).sendKeys(appNo);
	driver.findElement(By.name("search_application")).click();	
	try
	{
	driver.findElement(By.name("approve_cust")).click();	
	driver.switchTo().alert().accept();
	}
	catch(Exception e)
	{
		System.err.println("Failed");
	}
	
	//view active cust and fetch acc no
	driver.findElement(By.name("home")).click();
	driver.findElement(By.name("viewdet")).click();
	String expectedPanNo=mapOpenAcc.get("pan_no");
	
    String accNo = driver.findElement(By.xpath("//tr/td[.='"+expectedPanNo+"']/preceding-sibling::td[5]")).getText();
	mapDebitCard.put("acc_no", accNo);
	
	driver.findElement(By.name("logout_btn")).click();
	driver.findElement(By.xpath("//img[@class='logo_img']")).click();
	
	
	//apply for debit card
	driver.findElement(By.xpath("//li[.='Apply Debit Card']")).click();
	
	for(Entry<String, String> set:mapDebitCard.entrySet())
	{
		if(set.getKey().equals("dob"))
		{
			 WebElement calenderPopUp1 = driver.findElement(By.name("dob"));
			 JavascriptExecutor js1=(JavascriptExecutor) driver;
			 js.executeScript("arguments[0].value='12122000'", calenderPopUp1);
		}
		else
		{
		driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		}
	}
	
	driver.findElement(By.name("dbt_crd_submit")).click();
	
	driver.quit();
	
	}
	

}
