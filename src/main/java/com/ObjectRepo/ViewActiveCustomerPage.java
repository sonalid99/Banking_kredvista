package com.ObjectRepo;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.onlinebanking.kredvista.GenericUtils.ExcelUtil;

public class ViewActiveCustomerPage {
	
	//business logic
	public void validate(WebDriver driver) {
		try {
			driver.findElement(By.xpath("//td[text()='1011411011426']"));
			}
			catch(Exception e) {
				System.out.println("Customer Account is Successfully deleted");
			}
			
	}
	double balance=0;
	public void custDetailsAndBalance(WebDriver driver) {
	
		    //find account detail
			String	cusDetail=driver.findElement(By.xpath("//div[@class='active_customers_container']//td[text()='1011951011621']")).getText();
			
			//check current bal
			String bal=driver.findElement(By.xpath("//td[text()='1011951011621']/../td[8]")).getText();
			
			bal=bal.replace("$", "");
			
			double balance=Double.parseDouble(bal);
			
			System.out.println("Available balance = "+balance);
			
	}
	
	public void updatedCustomerBalance(WebDriver driver) {
		
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

	}
	
	public void validateCustByPAN(WebDriver driver ) throws EncryptedDocumentException, IOException {
		
		ExcelUtil eLib=new ExcelUtil();
		
		HashMap<String,String> map=eLib.readMultipleData("Openaccount", driver);

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
