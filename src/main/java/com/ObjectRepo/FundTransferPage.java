package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.onlinebanking.kredvista.GenericUtils.WebDriverUtils;

public class FundTransferPage extends WebDriverUtils {

	@FindBy(name="add_beneficiary")
	private WebElement addBeneficaryBtn;
	
	@FindBy(name="view_beneficiary")
	private WebElement viewBeneficiaryBtn;

	@FindBy(name="beneficiary")
	private WebElement selectBenificiaryDD;
	
	@FindBy(name="trnsf_amount")
	private WebElement amountTbx;
	
	@FindBy(name="trnsf_remark")
	private WebElement remarkTbx;
	
	@FindBy(name="fnd_trns_btn")
	private WebElement sendBtn;
	
	public FundTransferPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getViewBeneficiaryBtn() {
		return viewBeneficiaryBtn;
	}

	public WebElement getAddBeneficaryBtn() {
		return addBeneficaryBtn;
	}

	public WebElement getSelectBenificiaryDD() {
		return selectBenificiaryDD;
	}

	public WebElement getAmountTbx() {
		return amountTbx;
	}

	public WebElement getRemarkTbx() {
		return remarkTbx;
	}

	public WebElement getSendBtn() {
		return sendBtn;
	}
	
	//Business logic
	public void addBeneficiaryButton()
		{
			addBeneficaryBtn.click();
		}
	
	public void selectBeneficierySendAmount() {
		dropdown(selectBenificiaryDD, " Sarfaraz-101111011393 ");
		amountTbx.sendKeys("500");
		remarkTbx.sendKeys("sending 500");
		sendBtn.click();


	}
	
	public void viewBeneficiary() {
		viewBeneficiaryBtn.click();
	}
	
	
}
