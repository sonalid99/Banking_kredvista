package com.TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAnnotationTest {

	@Test
	public void editTest()
	{
		System.out.println(">_< EDIT   >_<");
	}
	
	@Test(priority = 1, invocationCount = 2)
	public void createTest()
	{
		System.out.println(">_< CREATE >_<");
		
	}
	
	
	@Test(priority = 0, dependsOnMethods = {"modifyTest","createTest"})
	public void deleteTest()
	{
		System.out.println(">_< DELETE >_<");
	}
	
	@Test(priority = 1,dependsOnMethods = "createTest")
	public void modifyTest()
	{
		System.out.println(">_< MODIFY >_<");
	}
	

}
