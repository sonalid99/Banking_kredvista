package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InternetBankingLoginPage {

	@FindBy(name="customer_id")
	 private WebElement customerIdtbx;
	
	@FindBy(name="password")
	private WebElement customerPwdtbx;
	
	@FindBy(name="login-btn")
	private WebElement loginBtn;
	
	public InternetBankingLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCustomerId() {
		return customerIdtbx;
	}

	public WebElement getCustomerPwd() {
		return customerPwdtbx;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	public void LoginTointernetBanking(String username, String password)
	{
		customerIdtbx.sendKeys(username);
		customerPwdtbx.sendKeys(password);
		loginBtn.click();
	}
}
