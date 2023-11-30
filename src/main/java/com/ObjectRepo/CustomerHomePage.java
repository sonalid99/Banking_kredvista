package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.onlinebanking.kredvista.GenericUtils.WebDriverUtils;

public class CustomerHomePage extends WebDriverUtils {

	@FindBy(xpath="//li[text()='Open Account']")
	private WebElement openAccTab;
	
	@FindBy(linkText="Apply Debit Card")
	private WebElement debitCardTab;
	
	@FindBy(linkText="Fund Transfer")
	private WebElement fundTransferTab;
	
	@FindBy(className="ebanking")
	private WebElement internetBankingTab;
	
	@FindBy(linkText="Register")
	private WebElement internetBRegisterTab;
	
	@FindBy(xpath="//li[contains(text(),'Login')]")
	private WebElement internetBLoginTab;
	
	@FindBy(xpath="//a[text()='Staff Login']")
	private WebElement staffLoginBtn;
	
	@FindBy(linkText="Home")
	private WebElement homeBtn;
	
	//Initialization
	public CustomerHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);;
	}

	public WebElement getstaffLoginBtn()
	{
		return staffLoginBtn;
		
	}
	
	public WebElement getOpenAccTab() {
		return openAccTab;
	}

	public WebElement getDebitCardTab() {
		return debitCardTab;
	}

	public WebElement getFundTransferTab() {
		return fundTransferTab;
	}

	public WebElement getInternetBankingTab() {
		return internetBankingTab;
	}
	
	public WebElement getRegisterTab() {
		return internetBRegisterTab;
	}

	public WebElement getLoginTab() {
		return internetBLoginTab;
	}
	
	
	
	//====business logic====
	
	public void openAccount()
	{
		openAccTab.click();
	}
	
	public void debitCard()
	{
	    debitCardTab.click();
	}
	
	public void fundTransfer()
	{
		fundTransferTab.click();
	}
	
	public void internetBankingRegister(WebDriver driver) 
	{
		mouseHover(driver, internetBankingTab);
		internetBRegisterTab.click();
	}
	
	public void internetBankingLogin(WebDriver driver, WebDriverUtils wLib)
	{
		wLib.mouseHover(driver, internetBankingTab);
		internetBLoginTab.click();
	}
	
	public void staffLoginButton()
	{
		staffLoginBtn.click();
	}
	
	public void homeButton()
	{
		homeBtn.click();
	}
	
}
