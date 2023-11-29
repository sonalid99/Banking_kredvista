package com.ObjectRepo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenAccountPage {
	
	@FindBy(name="dob")
	private WebElement calendarPopup;
	
	@FindBy(name="submit")
	private WebElement submitbtn;
	
	@FindBy(name="cnfrm-submit")
	private WebElement confirmSubmitbtn;
	
	public OpenAccountPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCalendarPopup() {
		return calendarPopup;
	}

	public WebElement getSubmitbtn() {
		return submitbtn;
	}

	public WebElement getConfirmSubmitbtn() {
		return confirmSubmitbtn;
	}
	
	public void dobCalendarPopup() throws AWTException {
		calendarPopup.click();
		
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
	
	}
	
	public void submitButton() {
		submitbtn.click();
	}
	
	public void confirmSubmitButton() {
		confirmSubmitbtn.click();
	}
}
