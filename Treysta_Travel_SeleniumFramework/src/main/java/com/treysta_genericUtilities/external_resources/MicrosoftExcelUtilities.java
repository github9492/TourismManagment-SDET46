package com.treysta_genericUtilities.external_resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This class contains generic methods related to excel sheet
 * @author Dell
 *
 */
public class MicrosoftExcelUtilities {
	DataFormatter df;
	FileInputStream fis;
	Workbook wb;
	/**
	 * This is the default constructor.
	 */ 
	public MicrosoftExcelUtilities() {}
	/**
	 * This constructor used to initialize the path of excel sheet
	 * @param filePath
	 */

	public MicrosoftExcelUtilities(String filePath) {
		intialize(filePath);
	}
	/**
	 * This method will initialize the path of excel file 
	 * @param filePath
	 */
	@Deprecated
	public void intialize(String filePath) {
		df=new DataFormatter();
		try {
			fis = new FileInputStream(filePath);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/**
	 * This method will get the data in form of key, value and return the value  
	 * @param sheetName
	 * @param expectedTestScriptName
	 * @return
	 */
	public Map<String, String> getData(String sheetName , String expectedTestScriptName) {
		Sheet sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		Map<String, String> map=new HashMap<>();
		for (int i = 1; i <= rowCount; i++) {
			String testScriptName = df.formatCellValue(sheet.getRow(i).getCell(0));
			if(testScriptName.equalsIgnoreCase(expectedTestScriptName)) {
				short  cellCount = sheet.getRow(i).getLastCellNum();
				for (int j = 1; j < cellCount; j++) {    
					String key = df.formatCellValue(sheet.getRow(i).getCell(j));
					String value = df.formatCellValue(sheet.getRow(i+1).getCell(j));
					if(key.equals(""))break;
					map.put(key, value);
				}
				break;
			}
		}
		return map;

	}
	/**
	 * This method is used to fetch the data from excel file.
	 * @param sheetName
	 * @param expectedTestScriptName
	 * @param expectedKey
	 * @param exptestCaseName
	 * @return
	 */
	public String getData(String sheetName,String expectedTestScriptName, String expectedKey ) {

		Sheet sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		String value=" ";
		//int testScriptCounter=0;
		//int keyCounter =0;
		for (int i = 1; i <= rowCount; i++) {
			String testScriptName = df.formatCellValue(sheet.getRow(i).getCell(0));

			if(testScriptName.equalsIgnoreCase(expectedTestScriptName)) {
				//testScriptCounter++;
				for(int j=1; j<sheet.getRow(i).getLastCellNum();j++) {
					String key = df.formatCellValue(sheet.getRow(i).getCell(j));
					if(key.equalsIgnoreCase(expectedKey)) {
						//	keyCounter++;
						value = df.formatCellValue(sheet.getRow(i+1).getCell(j));
						break;
					}

				}
				break;
			}
		}
		return value;

	}

	/**
	 * This method is used to fetch the data from the excel file i.e index based.
	 * @param sheetName
	 * @param rowIndex
	 * @param cellIndex
	 * @return
	 */

	public String getData(String sheetName , int rowIndex, int cellIndex) {
		String value = df.formatCellValue(wb.getSheet(sheetName).getRow(rowIndex).getCell(cellIndex));
		return value;
	}
	public void close () {
		try {
			wb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to set the data to excel .
	 * @param sheetName
	 * @param rowIndex
	 * @param cellIndex
	 */
	public void setData(String sheetName , int rowIndex, int cellIndex) {
		wb.getSheet(sheetName).getRow(rowIndex).createCell(cellIndex);

	}
	/**
	 * this method is used to save the data to excel file
	 *
	 * @param fileOutputPath
	 */
	public void saveData(String fileOutputPath) {
		try {
			wb.write(new FileOutputStream(fileOutputPath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * This method is used to fetch mulpile data from excel sheet.
	 * @param sheetName
	 * @return
	 */
	public String[][] getData(String sheetName){
		Sheet sheet =wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		Short cellCount = sheet.getRow(0).getLastCellNum();
		String [][] arr = new String [rowCount][cellCount];
		for(int i =1;i<=rowCount; i++) {
			for(int j=0; j<cellCount;j++) {
				arr[i-1][j]= df.formatCellValue(sheet.getRow(i).getCell(j));
			}
		}
		return arr;
	}



}













