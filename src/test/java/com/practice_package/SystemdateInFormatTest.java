package com.practice_package;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SystemdateInFormatTest {

	public static void main(String[] args) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("G E dd/MM/yyyy HH-mm-ss-SS a z");
		
		Date date = new Date();
		
		String sysDateInFormat=dateFormat.format(date);
		
		System.out.println(sysDateInFormat);
		

		/*Date date = new Date();
		
		String sysDate=date.toString();
		
		System.out.println(sysDate);*/
	}

}
