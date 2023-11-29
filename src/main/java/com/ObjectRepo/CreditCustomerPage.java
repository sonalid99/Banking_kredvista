package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreditCustomerPage {

	@FindBy(name="customer_account_no")
	private WebElement custAccNotbx;
	
	@FindBy(name="credit_amount")
	private WebElement creditAmounttbx;
	
	@FindBy(name="credit_btn")
	private WebElement creditBtn;
	
	public CreditCustomerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCustAccNotbx() {
		return custAccNotbx;
	}

	public WebElement getCreditAmounttbx() {
		return creditAmounttbx;
	}

	public WebElement getCreditBtn() {
		return creditBtn;
	}
	
	//business logic
	public void creditToCustomer() {
		custAccNotbx.sendKeys("1011951011621");
		creditAmounttbx.sendKeys("1000");
		creditBtn.click();
	}
	
	
}
