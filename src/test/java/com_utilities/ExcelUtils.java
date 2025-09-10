package com_utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static FileInputStream fis;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	// get row count
	public static int getRowCount(String excelfile, String excelsheet) throws IOException {
		
		 fis = new FileInputStream(excelfile);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(excelsheet);
		int rowcount = sheet.getLastRowNum();
		wb.close();
		fis.close();
		
		return rowcount;
			
	}
	
	//get the cell count
	
	public static int getCellCount(String excelfile, String excelsheet, int rownum) throws IOException {
	fis = new FileInputStream(excelfile);
	wb = new XSSFWorkbook(fis);
	sheet = wb.getSheet(excelsheet);
	row = sheet.getRow(rownum);
	int cellcount = row.getLastCellNum();
	return cellcount;
	}
	
	//get cell data
	

	public static String getCellData(String excelfile, String excelsheet, int rownum, int cellnum) throws IOException {
		fis = new FileInputStream(excelfile);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(excelsheet);
		row = sheet.getRow(rownum);
		cell = row.getCell(cellnum);
		
		DataFormatter format = new DataFormatter();
		String celldata = format.formatCellValue(cell);
		
		
		wb.close();
		fis.close();
		return celldata;
		
	}
	
	
	
	
}