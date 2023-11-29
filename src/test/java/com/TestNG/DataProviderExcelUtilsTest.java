package com.TestNG;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.onlinebanking.kredvista.GenericUtils.ExcelUtil;

public class DataProviderExcelUtilsTest {

	@Test(dataProvider = "getDataFromExcel")
	public void getData(String org, String loc) {
		System.out.println(org+"-->"+loc);
		System.out.println("hiiii");
		System.out.println("helloooooo");
	}
	
	@DataProvider
	public Object[][] getDataFromExcel() throws EncryptedDocumentException, IOException {
		ExcelUtil eLib=new ExcelUtil();
		Object[][] value = eLib.getMultipleSetOfDataByDataProvider();
		return value;
	}
}
