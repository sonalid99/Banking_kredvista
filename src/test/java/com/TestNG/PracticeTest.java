package com.TestNG;

import org.testng.annotations.Test;

import com.onlinebanking.kredvista.GenericUtils.BaseClass;

public class PracticeTest extends BaseClass {

	@Test(groups = "smoke")
	public void practice1() {
		System.out.println("===practice1===");
	}
	
	@Test(groups = {"regression","smoke"})
	public void practice2() {
		System.out.println("===practice2===");
	}
}
