package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InternetBankingHomePage {

	@FindBy(className="link4")
	private WebElement fundTransferTab;
	
	@FindBy(xpath="//li[text()='My Account']")
	private WebElement myAccountTab;
	
	@FindBy(xpath="//label[contains(text(),'Available Balance :$')]")
	private WebElement currBalance;
	
	@FindBy(name="logout_btn")
	private WebElement logoutBtn;
	
	public InternetBankingHomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getCurrBalance() {
		return currBalance;
	}

	public WebElement getMyAcountTab() {
		return myAccountTab;
	}

	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

	public WebElement getFundTransferTab() {
		return fundTransferTab;
	}
	
	//Business Logic
	public void fundTransfer() {
		fundTransferTab.click();
	}
	
	public void myAccount() {
		myAccountTab.click();
	}
	
	public String currentBalance() {
		return currBalance.getText();
	}
	
	public void logoutButton() {
		logoutBtn.click();
	}
	
	
}
