package com.onlinebanking.kredvista.GenericUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExcelUtil {
	
	/**
	 * This method is used to read the excel file
	 * @author Sonali
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
 
	public String readDataFromExcel(String sheetName,int row,int cell) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis=new FileInputStream(IpathConstants.excelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		String value=sh.getRow(row).getCell(cell).getStringCellValue();
		return value;
		
	}
	
	/**
	 * This method is used to write data into excel
	 * @author Sonali
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @param data
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataIntoExcel(String sheetName,int row,int cell,String data) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis=new FileInputStream(IpathConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		FileOutputStream fos=new FileOutputStream(IpathConstants.excelPath);
		Sheet sh = wb.getSheet(sheetName);
		sh.createRow(row).createCell(cell).setCellValue(data);
		wb.write(fos);
		wb.close();
	}
	
	/**
	 * This method is used to get the total row count
	 * @author Sonali
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getLastRowNo(String sheetName) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis=new FileInputStream(IpathConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		int count=sh.getLastRowNum();
		return count;
	}
	/**
	 * This method is use to read multiple data from excel file
	 * @author Sonali
	 * 
	 * @param sheetName
	 * @param driver
	 * @return 
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public HashMap<String, String> readMultipleData(String sheetName,WebDriver driver) throws EncryptedDocumentException, IOException {
		JavaUtils jLib=new JavaUtils();
		FileInputStream fis=new FileInputStream(IpathConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int count=sh.getLastRowNum();
		int cellCount=sh.getRow(0).getLastCellNum();
		
		
		HashMap<String, String> map= new HashMap<String,String>();
		
		for(int i=0;i<=count;i++) {
			for(int j=0;j<cellCount;j++) {
				
			String key=sh.getRow(i).getCell(j).getStringCellValue();
			String value=sh.getRow(i).getCell(j).getStringCellValue();
			map.put(key, value);
			}
			
		}
		
		for(Entry<String,String> set:map.entrySet()) 
		{
			//driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
			if(set.getKey().equals("pan_no"))
			{
				int random=jLib.getRandomNo();
				map.put(set.getKey(), set.getValue()+random);
				
				driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
			}
			else
			{
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		
			}
		}
		return map;
	}
	
	/**
	 * This method is used read data using dataProvider
	 * @param  
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] getMultipleSetOfDataByDataProvider() throws EncryptedDocumentException, IOException {
	
		FileInputStream fis=new FileInputStream(IpathConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet2");
		int rowCount = sh.getPhysicalNumberOfRows();
		int cellCount = sh.getRow(0).getLastCellNum();
		
		Object[][] obj = new Object[rowCount][cellCount];
		
		for(int i=0;i<rowCount;i++)
		{
			for(int j=0;j<cellCount;j++)
			{
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		
		return obj;
	}
	
}
