package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaffHomePage {

	@FindBy(name="viewdet")
	private WebElement viewActiveCustTab;
	
	@FindBy(name="view_cust_by_ac")
	private WebElement viewCustByAccNoTab;
	
	@FindBy(name="apprvac")
	private WebElement approveAccTab;
	
	@FindBy(name="del_cust")
	private WebElement delCustTab;
	
	@FindBy(name="credit_cust_ac")
	private WebElement creditCustTab;
	
	@FindBy(name="home")
	private WebElement homeBtn;
	
	@FindBy(name="logout_btn")
	private WebElement staffLogoutBtn;
	
	public StaffHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getViewActiveCustTab() {
		return viewActiveCustTab;
	}

	public WebElement getViewCustByAccNoTab() {
		return viewCustByAccNoTab;
	}

	public WebElement getApproveAccTab() {
		return approveAccTab;
	}

	public WebElement getDelCustTab() {
		return delCustTab;
	}

	public WebElement getCreditCustTab() {
		return creditCustTab;
	}
	
	public WebElement getHomeBtn() {
		return homeBtn;
	}
	
	public WebElement getLogoutBn() {
		return staffLogoutBtn;
	}
	
	public void viewActiveCustomer()
	{
		viewActiveCustTab.click();
	}
	
	public void viewCustomerByAccNo()
	{
		viewCustByAccNoTab.click();
	}
	
	public void approveCustomer()
	{
		approveAccTab.click();
	}
	
	public void deleteCustomer()
	{
		delCustTab.click();
	}
	
	public void creditCustomer()
	{
		creditCustTab.click();
	}
	
	public void homeButton()
	{
	    homeBtn.click();		
	}
	
	public void staffLogoutButton()
	{
		staffLogoutBtn.click();
	}
	
}
