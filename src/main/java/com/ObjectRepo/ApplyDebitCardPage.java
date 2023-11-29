package com.ObjectRepo;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplyDebitCardPage {
	
	@FindBy(name="dbt_crd_submit")
	private WebElement submitBtn;

	public ApplyDebitCardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void applyDebitCard(HashMap<String, String> mapDebitCard, WebDriver driver) {
	for(Entry<String, String> set:mapDebitCard.entrySet())
	{
		if(set.getKey().equals("dob"))
		{
			 WebElement calenderPopUp1 = driver.findElement(By.name("dob"));
			 JavascriptExecutor js=(JavascriptExecutor) driver;
			 js.executeScript("arguments[0].value='12122000'", calenderPopUp1);
		}
		else
		{
		driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		}
	}
	}
	
	public void submitButton() {
		submitBtn.click();
	}
}

