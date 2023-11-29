package com.TestNG;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class PracticeTestNGAnnotationTest {

	@Test()
	public void createTest()
	{
		System.out.println(">_< CREATE >_<");
		Assert.fail();
	}
	
	@Test(dependsOnMethods = "modifyTest")
	public void editTest()
	{
		System.out.println(">_< EDIT   >_<");
	}
	
	@Test(dependsOnMethods = "createTest")
	public void deleteTest()
	{
		System.out.println(">_< DELETE >_<");
	}
	
	@Test(invocationCount = 2)
	public void modifyTest()
	{
		System.out.println(">_< MODIFY >_<");
	}
	
}
