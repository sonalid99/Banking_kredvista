package com.TestNG;

import org.testng.annotations.Test;

import com.onlinebanking.kredvista.GenericUtils.BaseClass;

public class SampleTest extends BaseClass {

	@Test
	public void sample1() {
		System.out.println("===sample1===");
	}
	
	@Test(groups = "smoke")
	public void sample2() {
		System.out.println("===sample2===");
	}
}
