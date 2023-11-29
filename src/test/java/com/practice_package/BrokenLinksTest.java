package com.practice_package;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksTest {

	public static void main(String[] args) throws IOException {

		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://ojee.nic.in/");
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		List<WebElement> allLinks= driver.findElements(By.xpath("//a"));
		
		System.out.println(allLinks.size());
		
		//create empty array to store all broken links
		ArrayList<String> arrLinks= new ArrayList<String>();
		
		for(int i=0;i<allLinks.size();i++) {
			String eachLink=allLinks.get(i).getAttribute("href");
						
			int statuscode=0;
			URL url=null;
			
		try {
	        url=new URL(eachLink);
			HttpsURLConnection httpurlConn= (HttpsURLConnection)url.openConnection();
			statuscode=httpurlConn.getResponseCode();
			
			if(statuscode>=400) {
				arrLinks.add(eachLink);
				System.out.println(eachLink+"==>"+statuscode);
			}
		} catch (MalformedURLException e) {
			
			arrLinks.add(eachLink);
			System.out.println(eachLink+"==>"+statuscode);
			continue;

		}
		}
		
	}

}
