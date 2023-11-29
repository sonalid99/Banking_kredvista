package com.ObjectRepo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InternetBankingRegistrationPage {

	@FindBy(name="holder_name")
	private WebElement nametbx;
	
	@FindBy(name="accnum")
	private WebElement accNumbertbx;
	
	@FindBy(name="dbtcard")
	private WebElement debitCardNotbx;
	
	@FindBy(name="dbtpin")
	private WebElement debitCardPintbx;

	@FindBy(name="mobile")
	private WebElement mobileNotbx;

	@FindBy(name="pan_no")
	private WebElement panNotbx;
	
	@FindBy(name="dob")
	private WebElement dobCalendarPopup;
	
	@FindBy(name="last_trans")
	private WebElement lastTransactiontbx;

	@FindBy(name="password")
	private WebElement passwordtbx;
	
	@FindBy(name="cnfrm_password")
	private WebElement confirmPasswordtbx;

	@FindBy(name="submit")
	private WebElement submitBtn;
	
	public InternetBankingRegistrationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getNametbx() {
		return nametbx;
	}

	public WebElement getAccNumbertbx() {
		return accNumbertbx;
	}

	public WebElement getDebitCardNotbx() {
		return debitCardNotbx;
	}

	public WebElement getDebitCardPintbx() {
		return debitCardPintbx;
	}

	public WebElement getMobileNotbx() {
		return mobileNotbx;
	}

	public WebElement getPanNotbx() {
		return panNotbx;
	}

	public WebElement getDobtbx() {
		return dobCalendarPopup;
	}

	public WebElement getLastTransactiontbx() {
		return lastTransactiontbx;
	}

	public WebElement getPasswordtbx() {
		return passwordtbx;
	}

	public WebElement getConfirmPasswordtbx() {
		return confirmPasswordtbx;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	//business Logic
	public void registerToInternetBanking() {
		
		nametbx.sendKeys("Sonali dash");
		
		accNumbertbx.sendKeys("1011401011840");
		
		debitCardNotbx.sendKeys("421313007660");
		
		debitCardPintbx.sendKeys("6357");
		
		mobileNotbx.sendKeys("9078019941");
		
		panNotbx.sendKeys("pan012325");
		
		lastTransactiontbx.sendKeys("$0");
		
		passwordtbx.sendKeys("01234567");
		
		confirmPasswordtbx.sendKeys("01234567");
	}
	
	public void dobCalendar() throws AWTException {
		dobCalendarPopup.click();
		
		Robot rbt = new Robot();
		rbt.keyPress(KeyEvent.VK_DOWN);
		rbt.keyRelease(KeyEvent.VK_DOWN);
		
		rbt.keyPress(KeyEvent.VK_TAB);
		rbt.keyRelease(KeyEvent.VK_TAB);
		
		rbt.keyPress(KeyEvent.VK_UP);
		rbt.keyRelease(KeyEvent.VK_UP);
		
		rbt.keyPress(KeyEvent.VK_TAB);
		rbt.keyRelease(KeyEvent.VK_TAB);
		
		for(int i=1;i<=21;i++)
		{
			rbt.keyPress(KeyEvent.VK_DOWN);
			rbt.keyRelease(KeyEvent.VK_DOWN);
		}
		
		submitBtn.click();
		
	}
	
	
	
}
