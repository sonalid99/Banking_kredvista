package com.TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.onlinebanking.kredvista.GenericUtils.BaseClass;

public class DemoTest extends BaseClass {

	@Test(groups = "regression")
	public void Demo1() {
		System.out.println("====demo1====");
		Assert.fail();
	}
	
	@Test
	public void Demo2() {
		System.out.println("===demo2===");
	}
}
