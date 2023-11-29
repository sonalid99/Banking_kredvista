package com.TestNG;

import org.testng.annotations.Test;

import com.onlinebanking.kredvista.GenericUtils.BaseClass;

public class SimpleTest extends BaseClass {

	@Test(groups = "regression")
	public void simple1() {
		System.out.println("====simple1====");
	}
	
	@Test
	public void simple2() {
		System.out.println("===simple2===");
	}
}
