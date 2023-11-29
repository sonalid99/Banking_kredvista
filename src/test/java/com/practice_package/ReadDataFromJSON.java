package com.practice_package;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDataFromJSON {

	public static void main(String[] args) throws IOException, ParseException {

		FileReader filePath=new FileReader(".\\src\\test\\resources\\JSONRead.json");
				
		//JSONParser is used to read/write json formatted file
		JSONParser jsonp = new JSONParser();
		Object obj = jsonp.parse(filePath);
		
		//read data from json file
		JSONObject map = (JSONObject) obj;
		
		System.out.println(map.get("browser"));
		
		System.out.println(map.get("url"));
		
		System.out.println(map.get("username"));
		
		System.out.println(map.get("password"));
		
		
		
	}

}
