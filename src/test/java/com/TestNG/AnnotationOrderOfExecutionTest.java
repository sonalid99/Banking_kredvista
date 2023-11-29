package com.TestNG;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AnnotationOrderOfExecutionTest {

	@BeforeSuite
	public void DB() {
		System.out.println("---BeforeSuite----");
	}
	@BeforeClass
	public void openBrowser1() {
		System.out.println("---BeforeClass1----");
	}
	@BeforeClass
	public void openBrowser2() {
		System.out.println("---BeforeClass2----");
	}
	@BeforeMethod
	public void login1() {
		System.out.println("---BeforeMethod1----");
	}
	@BeforeMethod
	public void login2() {
		System.out.println("---BeforeMethod2----");
	}
	@BeforeMethod
	public void login3() {
		System.out.println("---BeforeMethod3----");
	}
	@Test
	public void test1() {
		System.out.println("---Test1----");
	}
	@Test
	public void test2() {
		System.out.println("---Test2----");
	}
	@AfterMethod
	public void AfterMethod1() {
		System.out.println("---AfterMethod1----");
	}
	@AfterMethod
	public void AfterMethod2() {
		System.out.println("---AfterMethod2----");
	}
	@AfterClass
	public void AfterClass1() {
		System.out.println("---AfterClass1----");
	}
	@AfterClass
	public void AfterClass2() {
		System.out.println("---AfterClass2----");
	}
	@AfterSuite
	public void AfterSuite() {
		System.out.println("---AfterSuite----");
	}
}
