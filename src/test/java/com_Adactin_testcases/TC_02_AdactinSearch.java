package com_Adactin_testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com_Adactin_pageobjects.Adactin_Searchpage;
import com_utilities.ExcelUtils;

public class TC_02_AdactinSearch extends TC_01_AdactinLogin {

	public Adactin_Searchpage search;
	
	
	@Test(dataProvider ="Adactin")
	public void searchpage(String indate, String outdate) {
		search = new Adactin_Searchpage(driver);
		search.incheck(indate);
		search.outcheck(outdate);
		
	}
	
	@DataProvider(name="Adactin")
	String [][] getData() throws IOException{
		
		
	//	String path = System.getProperty(("user.dir")+"\\testdata\\Adactin.xlsx");
		String path = "./testdata/Adactin.xlsx";
		
		//row count
		int rownum = ExcelUtils.getRowCount(path, "Sheet1");
		
		// cellcount
		int cellnum= ExcelUtils.getCellCount(path, "Sheet1", 1);
		
		String LoginData[][]= new String[rownum][cellnum];
		for(int i=1;i<= rownum; i++) {
			for (int j=0; j<cellnum;j++) {
				LoginData[i-1][j]=ExcelUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return LoginData;
	}
	
	
	
	
	
	
}
