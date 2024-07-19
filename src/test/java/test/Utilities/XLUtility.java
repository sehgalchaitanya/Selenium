package test.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtility {
	
	FileInputStream fi;
	FileOutputStream fo;
	public HSSFWorkbook workbook;
	public HSSFSheet sheet;
	public HSSFRow row;
	public HSSFCell cell;
	
	String path;

	public XLUtility(String path)
	{
		this.path = path;
	}
	
	public int getRowCount(String sheetName) throws IOException
	{   
		fi = new FileInputStream(path);
		workbook = new HSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		int rowcount = sheet.getLastRowNum();
		workbook.close();
		fi.close();
		return rowcount;
	}

    public int getCellCount(String sheetName, int rownum) throws IOException
    {
    	fi = new FileInputStream(path);
    	workbook = new HSSFWorkbook(fi);
    	sheet = workbook.getSheet(sheetName);
    	row = sheet.getRow(rownum);
    	int cellcount = row.getLastCellNum();
    	workbook.close();
    	fi.close();
    	return cellcount;   		
    }
    
    public String getCellData(String sheetName, int rownum, int colnum) throws IOException
    {
    	fi = new FileInputStream(path);
    	workbook = new HSSFWorkbook(fi);
    	sheet = workbook.getSheet(sheetName);
    	row = sheet.getRow(rownum);
    	cell = row.getCell(colnum);
    
    	DataFormatter formatter = new DataFormatter();
    	
    	String data;
    	try
    	{
    	data = formatter.formatCellValue(cell);
    	}
    	catch(Exception e)
    	{
    		data = "";
    	}
    	workbook.close();
    	fi.close();
    	return data;
    }


}