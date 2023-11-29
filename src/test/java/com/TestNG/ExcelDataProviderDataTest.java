package com.TestNG;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class ExcelDataProviderDataTest {
	
	@Test(dataProvider = "data")
	public void getExcelData(String org, String loc) {
		System.out.println(org+"--->"+loc);
	}
	
@DataProvider
public Object[][] data() throws EncryptedDocumentException, IOException {

	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("Sheet2");
	int rowCount=sh.getLastRowNum(); //to get number of count of rows sh.getPhysicalNumberOfRows();
	int cellCount=sh.getRow(0).getLastCellNum();
	
	Object[][] obj=new Object[rowCount+1][cellCount];
	
	for(int i=0;i<=rowCount;i++) {
		for(int j=0;j<cellCount;j++) {
			
			obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			
		}
	}
	
	return obj;
}
}
