package com.openAccount;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
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
import org.testng.annotations.Test;

public class TC_01_OpenApproveViewActiveCustomerTest {
	
	@Test()
	public void TC_01() throws IOException, InterruptedException
	{
	//property file handling for common data
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\BankingCommonData.properties.txt");
	Properties p=new Properties();
	p.load(fis);
	
	String URL=p.getProperty("url");
	String STAFFUSERNAME=p.getProperty("staffid");
	String STAFFPASSWORD=p.getProperty("staffpassword");
	
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
	String aplNo="";
	for(int i=0;i<text.length();i++)
	{
		if(Character.isDigit(text.charAt(i)))
		{
			aplNo=aplNo+text.charAt(i);
		}
	}
	
	
	driver.findElement(By.linkText("Staff Login")).click();
	driver.findElement(By.name("staff_id")).sendKeys(STAFFUSERNAME);
	driver.findElement(By.name("password")).sendKeys(STAFFPASSWORD);
	driver.findElement(By.name("staff_login-btn")).click();
	
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
	

	String expectedPanNo=map.get("pan_no");
	
	
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
	}
	
	
	
	
	
	}
	
	

}
