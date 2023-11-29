package com.onlinebanking.kredvista.GenericUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtils {

	public int getRandomNo() {
		
		 Random r = new Random();
		 
		 int random=r.nextInt(500);
		 
         return random;  		
			
	}
	
	public String systemDate() {
		
		Date date = new Date();
		
		String sysDate=date.toString();
		
		return sysDate;
	}
	
	public String systemDateInFormat() 
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy HH-mm-ss");
		
		Date date = new Date();
		
		String sysDateInFormat=dateFormat.format(date);
		
		return sysDateInFormat;
		
	}
}
