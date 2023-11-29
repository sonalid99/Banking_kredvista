package com.onlinebanking.kredvista.GenericUtils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils {

	/**
	 * This method is used to maximize the window
	 * @author Sonali
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
	 
		driver.manage().window().maximize();	
	}
	
	/**
	 * This method is used to minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * This method is used to synchronize page load the using implicit wait
	 * @param driver
	 * @param sec
	 */
	public void waitForPageLoad(WebDriver driver, int sec) {
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(sec));
	}
	
	/**
	 * This method is used to synchronize time until element is visible by using explicit wait
	 * @param driver
	 * @param element
	 * @param sec
	 */
	public void waitUntilEleIsVisible(WebDriver driver, WebElement element, int sec)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method is used to wait until element is clickable
	 * @param driver
	 * @param element
	 * @param sec
	 */
	public void waitUntilEleToBeClickable(WebDriver driver, WebElement element, int sec)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	//methodOverloading in Select class
	
	/**
	 * this method is used to select from dropdown using index
	 * @param element
	 * @param index
	 */
	public void dropdown(WebElement element, int index) {
		
		Select s=new Select(element);
		s.selectByIndex(index);
			
		}
	
	/**
	 * this method is used to select from dropdown using visible text
	 * @param element
	 * @param text
	 */
	public void dropdown(WebElement element, String text)
	{
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	
	/**
	 * this method is used to select from dropdown using value
	 * @param value
	 * @param element
	 */
	public void dropdown(String value,WebElement element)
		{
			Select s=new Select(element);
			s.selectByValue(value);
		}
	
	/**
	 * this method is used to mouse hover to particular element
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebDriver driver,WebElement element) 
	{
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
		
	}
	
	public void dragAndDrop(WebDriver driver, WebElement src, WebElement dest)
	{
		Actions a=new Actions(driver);
		a.dragAndDrop(src, dest).perform();
	}
	
	/**
	 * this method will double click on WebPage
	 * @param driver
	 */
	public void doubleClick(WebDriver driver) 
	{
		Actions a=new Actions(driver);
		a.doubleClick().perform();
	}
	
	/**
	 * this method is used to double click on a particular element
	 * @param driver
	 * @param element
	 */
	public void doubleClickOnElement(WebDriver driver, WebElement element)
	{
		Actions a=new Actions(driver);
		a.doubleClick(element).perform();
	}
	
	public void rightClickOnWebPage(WebDriver driver)
	{
		Actions a=new Actions(driver);
		a.contextClick().perform();
	}
	
	public void rightClickOnElement(WebDriver driver, WebElement element) 
	{
		Actions a=new Actions(driver);
		a.contextClick(element).perform();
	}
	
	public void keyPressUsingActions(WebDriver driver) {
		Actions a=new Actions(driver);
		a.sendKeys(Keys.ENTER).perform();
	}
	
	public void keyPressEnterRobot() throws Throwable
	{
	    Robot r=new Robot();
	    r.keyPress(KeyEvent.VK_ENTER);
	}
	
	public void keyReleaseEnterRobot()throws Throwable
	{
		Robot r=new Robot();
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	//method overloading in switchToFrame
	
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver, String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}
	
	public void switchToFrame(WebDriver driver, WebElement address)
	{
		driver.switchTo().frame(address);
	}
	
	/**
	 * this method will switch between windows
	 * @param driver
	 * @param windowName
	 */
	public void switchToWindow(WebDriver driver, String partialWindowTitle)
	{
		//step1: use getWindowHandles to capture all window ids
		Set<String> windowids=driver.getWindowHandles();
		
		//Step2: Iterate though the windows
		Iterator<String> iterator=windowids.iterator();
		
		//Step3: check whether there is next window
		while(iterator.hasNext())
		{
			//step4: capture current window id
			String winId= iterator.next();
			
			//step5: switch to current window and capture title
			String currentWindowTitle= driver.switchTo().window(winId).getTitle();
			
			//step6: check whether the current window is expected
			if(currentWindowTitle.contains(partialWindowTitle))
			{
				break;
			}
		}
		
	}
	
	public void alertPopupAccept(WebDriver driver ) 
	{
	    driver.switchTo().alert().accept();
			
	}
	
	public void alertPopupDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	public String alertPopupgetText(WebDriver driver)
	{
		Alert a=driver.switchTo().alert();
		String text = a.getText();
		return text;
	}
	
	public void alertPopupsendKeys(WebDriver driver, String value)
	{
		driver.switchTo().alert().sendKeys(value);
	}
	
	/**
	 * This method will take screenshot and store it in a file named screenshot
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws IOException
	 */
	public static String getScreenShot(WebDriver driver, String screenShotName) throws IOException 
	{
		TakesScreenshot t=(TakesScreenshot) driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		String path="./Screenshot/"+screenShotName+".png";
		File dest = new File(path);
		FileUtils.copyFile(src, dest);
		
		return path;
	}	
	
	public void scrollAction(WebDriver driver)
	{
		JavascriptExecutor j=(JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0,500)", "");
	}
	
	public void ScrollAction(WebDriver driver, WebElement element)
	{
		JavascriptExecutor j=(JavascriptExecutor) driver;
		int y=element.getLocation().getY();
		j.executeScript("window.scrollBy(0,"+y+")", element);
		
	}
}
