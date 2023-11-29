package com.practice_package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SpicejetNewTest {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		
        WebDriver driver=new ChromeDriver(option);
		
		driver.manage().window().maximize();
		
		driver.get("https://www.spicejet.com/");
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		Thread.sleep(2000); 		
		
		//roundtrip radio button
		driver.findElement(By.xpath("//div[text()='round trip']/ancestor::div[@class='css-1dbjc4n r-1awozwy r-1loqt21 r-18u37iz r-117bsoe r-1otgn73']//div[@class='css-1dbjc4n r-zso239']")).click();
		
		Thread.sleep(2000);
		
		//To textfield
		driver.findElement(By.xpath("//div[text()='To']/..")).click();
		
		//autosuggestion
		driver.findElement(By.xpath("//div[text()='Delhi']")).click();
		
		
		String month="January";
		int year=2024;
		int date=9;
	
		for(;;) {
			
		try {
		//departure date
		driver.findElement(By.xpath("//div[contains(text(),'"+month+"') and text()='"+year+"']/ancestor::div[@class='css-1dbjc4n r-1mdbw0j r-ymttw5 r-b2dl2 r-mzjzbw r-wk8lta r-tvv088']/descendant::div[text()='"+date+"']")).click();
		break;
		}
		
		catch(Exception e) {
		//next arrow
		driver.findElement(By.xpath("//div[@class='r-1loqt21 r-u8s1d r-11xbo3g r-1v2oles r-1otgn73 r-16zfatd r-1i6wzkk r-lrvibr r-184en5c css-1dbjc4n']//*[name()='svg' and @data-testid='svg-img']")).click();
		}
		}
		
		//String returnMonth="December";
		int returnDate=12;
		
        
		Thread.sleep(2000);

		//return date
		driver.findElement(By.xpath("//div[contains(text(),'"+month+"' and text()='"+year+"']/ancestor::div[@class='css-1dbjc4n r-1mdbw0j r-ymttw5 r-b2dl2 r-mzjzbw r-wk8lta r-tvv088']/descendant::div[text()='"+returnDate+"']")).click();
		
		//passengers
		driver.findElement(By.xpath("//div[text()='Passengers']")).click();
		Thread.sleep(2000);

		//add passengers
		driver.findElement(By.xpath("//div[text()='Adult']/ancestor::div[@class='css-1dbjc4n r-18u37iz r-1wtj0ep r-1x0uki6']//div[@class='css-1dbjc4n r-1awozwy r-19m6qjp r-y47klf r-1loqt21 r-eu3ka r-1777fci r-1otgn73 r-eafdt9 r-1i6wzkk r-lrvibr r-1aockid']")).click();
		Thread.sleep(2000);
		
		//select currency
		driver.findElement(By.xpath("//div[text()='Currency']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[text()='USD']")).click();

		//select type armed force
		driver.findElement(By.xpath("//div[text()='Armed Forces']/ancestor::div[@class='css-1dbjc4n r-1awozwy r-1loqt21 r-18u37iz r-15d164r r-1otgn73']//*[name()='svg' and @data-testid='svg-img']")).click();
		Thread.sleep(2000);
		
		//click on search
		driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-1g94qm0 r-1w50u8q r-ah5dr5 r-1otgn73']")).click();
		
	}

}
