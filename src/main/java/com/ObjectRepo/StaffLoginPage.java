package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.onlinebanking.kredvista.GenericUtils.WebDriverUtils;

public class StaffLoginPage {

	//declaration
	@FindBy(name="staff_id")
	private WebElement staffId;
	
	@FindBy(name="password")
	private WebElement staffpassword;
	
	@FindBy(name="staff_login-btn")
	private WebElement loginBtn;
	
	public StaffLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getStaffId() {
		return staffId;
	}

	public WebElement getStaffpassword() {
		return staffpassword;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//Business logic
	public void staffLogin(String username, String password) {
		staffId.sendKeys(username);
		staffpassword.sendKeys(password);
		loginBtn.click();
	}
	
}
