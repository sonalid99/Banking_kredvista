package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApproveCustomerPage {

	@FindBy(name="application_no")
	private WebElement applicationNoTbx;
	
	@FindBy(name="search_application")
	private WebElement searchBtn;
	
	@FindBy(name="approve_cust")
	private WebElement approveBtn;
	
	public ApproveCustomerPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getApplicationNotbx() {
		return applicationNoTbx;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getApproveBtn() {
		return approveBtn;
	}
	
	public void approveCustomerText(String applNo)
	{
		applicationNoTbx.sendKeys(applNo);
		searchBtn.click();
	}
	
	public void approveCustomerBtn() {
		approveBtn.click();

	}

		
	
}
