package com.learnautomation.dataproviders;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtility {
	static XSSFWorkbook wb;
	
	public static Object[][] getDataFromSheet(String sheetname){
		
		Object[][] arr=null;
		
		try {
			
			//wb= new XSSFWorkbook(new FileInputStream(new File(System.getProperty("user.dir"+"/TestData/excelsheet.xlsx"))));
			wb=new XSSFWorkbook(new FileInputStream(new File(System.getProperty("user.dir")+"/TestData/OrangeHRMData.xlsx")));
			
			int row= wb.getSheet(sheetname).getPhysicalNumberOfRows();
			int col = wb.getSheet(sheetname).getRow(0).getPhysicalNumberOfCells();
			arr =new Object[row-1][col];
			
			for(int i=1;i<row;i++) {
				
				for(int j=0;j<col;j++) {
					
					arr[i-1][j]=getData(sheetname,i,j);
				}
			}
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr;
	}
	
	public static String getData(String sheetname, int row, int col) {
		
		XSSFCell cell = wb.getSheet(sheetname).getRow(row).getCell(col);
		
		String Data="";
		
		if(cell.getCellType()== CellType.STRING) {
			Data= cell.getStringCellValue();
		}
		else if(cell.getCellType()== CellType.NUMERIC){
			Data= String.valueOf(cell.getNumericCellValue());
		}
		else if(cell.getCellType()==CellType.BLANK) {
			Data="";
		}
		return Data;
	}
	

}
