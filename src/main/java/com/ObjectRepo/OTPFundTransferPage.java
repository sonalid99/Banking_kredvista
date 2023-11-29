package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OTPFundTransferPage {

	@FindBy(xpath = "//label[@class='OTP_msg']")
	private WebElement OTPtexts;
	
	@FindBy(name="otpcode")
	private WebElement OTPtbx;
	
	@FindBy(name="verify-btn")
	private WebElement verifyBtn;

	public OTPFundTransferPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOTPtext() {
		return OTPtexts;
	}
	

	public WebElement getOTPtbx() {
		return OTPtbx;
	}

	public WebElement getVerifyBtn() {
		return verifyBtn;
	}
	
	//business logic
	public void OTPverify() {
		String text = OTPtexts.getText();
        String[] texts = text.split(":");
        String otp = texts[1];
        int num=Integer.parseInt(otp);
        System.out.println(num);
        
        OTPtbx.sendKeys(otp);
        
        verifyBtn.click();
	}
}
