package com.practice_package;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		 Workbook wb= WorkbookFactory.create(fis);
		 
		 String data=wb.getSheet("sheet1").getRow(1).getCell(0).getStringCellValue();
		 
		 System.out.println(data);
	}

}
