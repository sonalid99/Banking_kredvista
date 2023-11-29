package com.ObjectRepo;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.onlinebanking.kredvista.GenericUtils.JavaUtils;

public class AddBeneficieryPage {

	@FindBy(name="beneficiary_name")
	private WebElement beneficiaryNametbx;
	
	//@FindBy(name="beneficiary_acno")
	//private WebElement beneficiaryAccNo;
	
	//@FindBy(name="Ifsc_code")
	//private WebElement ifscCode;
	
	@FindBy(name="beneficiary_acc_type")
	private WebElement beneficieryAccTypeDD;
	
	@FindBy(name="add_beneficiary_btn")
	private WebElement addBtn;
	
	public AddBeneficieryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	
	
	//business logic
	/*public void toReadMultipleDataFromExcel(WebDriver driver, JavaUtils jLib, HashMap<String, String> map) { 
	for(Entry<String,String> set:map.entrySet()) 
	{
		
		if(set.getKey().equals("pan_no"))
		{
			int random=jLib.getRandomNo();
			map.put(set.getKey(), set.getValue()+random);
			
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		}
		else
		{
		driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		}
	}

	}*/
	
	public void addBenefieciaryButton() {
		addBtn.click();
		}

	
}
