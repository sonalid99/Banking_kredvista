package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomerPage {

	@FindBy(name="Cust_ac_no")
	private WebElement custAccNotbx;
	
	@FindBy(name="Cust_ac_Id")
	private WebElement custIdtbx;
	
	@FindBy(name="reason")
	private WebElement reasontbx;
	
	@FindBy(name="delete")
	private WebElement deleteBtn;
	
	public DeleteCustomerPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	public WebElement getCustAccNotbx() {
		return custAccNotbx;
	}

	public WebElement getCustIdtbx() {
		return custIdtbx;
	}

	public WebElement getReasontbx() {
		return reasontbx;
	}

	public WebElement getDeleteBtn() {
		return deleteBtn;
	}
	
	//business logic
	public void deleteButton() {
		deleteBtn.click();
		
	}
	
}
