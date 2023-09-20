package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.WebDriver;

public class excelReader2 {
	
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	FileInputStream file;
	String path;
	
	public excelReader2(String path) throws IOException
	{
		this.path=path;
		file = new FileInputStream(path);
		workbook = new XSSFWorkbook(file);
	}
	
	public int getRowCount(String sheetname) 
	{
		
		sheet = workbook.getSheet(sheetname);
		int totalRows = sheet.getLastRowNum();
		return totalRows;
	}
	
	public int getCellCount(String sheetname, int rowNumber) 
	{
		sheet = workbook.getSheet(sheetname);
		int totalCells= sheet.getRow(rowNumber).getLastCellNum();
		return totalCells;
	}
	
	public String getCellData(String sheetname, int rownumber, int cellnumber)
	{
		sheet = workbook.getSheet(sheetname);
		row= sheet.getRow(rownumber);
		cell = row.getCell(cellnumber);
		String celldata=cell.toString();
		return celldata;
		
	}

}
