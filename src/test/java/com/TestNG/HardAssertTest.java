package com.TestNG;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class HardAssertTest {

	@Test
	public void hardAssert() {
		String expected="hiiiii";
		System.out.println(">_< ====TS1==== >_<");
		System.out.println(">_< ====TS2==== >_<");
		assertEquals("bye", expected);
		System.out.println(">_< ====TS3==== >_<");
		System.out.println(">_< ====TS4==== >_<");

	}
	
	@Test
	public void hardAssertTest() {
		
		int a=10;
		System.out.println(">_< ====TS5==== >_<");
		System.out.println(">_< ====TS6==== >_<");
		assertNotNull(a, "Expects some value in a");
		System.out.println(">_< ====TS7==== >_<");
		System.out.println(">_< ====TS8==== >_<");

	}
}
