package com.practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class RmgYantraTest {

	public static void main(String[] args) throws SQLException, InterruptedException {
 
			
		String projectName="TY_OnlineBanking1_KredVista";
		String projectManager="Ashirbad";
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://rmgtestingserver:8084/");
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		//signin into rmgyantra
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		
		Thread.sleep(3000);
		//create project
		driver.findElement(By.linkText("Projects")).click();
		
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(projectName);
		
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys(projectManager);
		
		WebElement status = driver.findElement(By.xpath("//select[@name='status']"));
		
		Select s=new Select(status);
		s.selectByVisibleText("Created");
		
		driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();
			
		
		Driver driver1=new Driver();
		DriverManager.registerDriver(driver1);
		
		Connection con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
		
		Statement state=con.createStatement();
		String query= "select* from project;";
		
		ResultSet result = state.executeQuery(query);
		
		boolean flag=false;
		while(result.next())
		{
			if(result.getString(4).equalsIgnoreCase(projectName)) {
				System.out.println("Project is created successfully");
				flag=true;
				break;
			}
		}
		if(flag==false) {
			System.out.println("Project does not exist");
		}
		con.close();

	}

}
