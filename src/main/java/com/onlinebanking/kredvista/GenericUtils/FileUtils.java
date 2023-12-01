package com.onlinebanking.kredvista.GenericUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtils {
	
	/**
	 * This method is used to read the property file
	 * @author Sonali
	 * @param key
	 * @return
	 * @throws IOException
	 */

	public String readDataInPropertyFile(String key) throws IOException {
		
		FileInputStream fis=new FileInputStream(IpathConstants.filePath);
		
		Properties p=new Properties();
		
		p.load(fis);
		
		String value=p.getProperty(key);
		
		return value;
			
		}
	}

