package com.staffModule;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC_15_DeleteAndViewCustomer {
	
	@Test
	public void staffModuleTest() throws IOException, InterruptedException {
		
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
	
	
	driver.findElement(By.name("password")).sendKeys(STAFFPASSWORD);
	
	driver.findElement(By.name("staff_login-btn")).click();
	
	driver.findElement(By.name("del_cust")).click();
	
    FileInputStream fs=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
    
    Workbook wb=WorkbookFactory.create(fs);
	
    Sheet sh = wb.getSheet("Deleteaccount");
    
    int count=sh.getLastRowNum();
    
    HashMap<String, String> map=new HashMap<String, String>();
    
    for(int i=0;i<=count;i++) {
    	
    	String key=sh.getRow(i).getCell(0).getStringCellValue();
 
    	String value=sh.getRow(i).getCell(1).getStringCellValue();
    	
    	map.put(key, value);
    	
    }
    
    for(Entry<String,String> set: map.entrySet()) {
    	
    	
    		driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
    	
    }
    
    driver.findElement(By.name("delete")).click();
    
	Alert a=driver.switchTo().alert();
	
	Thread.sleep(3000);
	
	a.accept();
	
	driver.findElement(By.name("home")).click();
	
	driver.findElement(By.name("viewdet")).click();
	
	try {
	driver.findElement(By.xpath("//td[text()='1011621011381']"));
	}
	catch(Exception e) {
		System.out.println("Customer Account is Successfully deleted");
	}
	
	driver.quit();

}
}