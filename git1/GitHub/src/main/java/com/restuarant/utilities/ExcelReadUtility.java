package com.restuarant.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.restuarant.base.BaseClass;

public class ExcelReadUtility extends BaseClass  {

	String str= null;
	String value =null;
	public ExcelReadUtility(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	/*
	 * public static void main(String[] args) throws IOException { ExcelReadUtility
	 * rc=new ExcelReadUtility(); String voutput=rc.ReadCellData(1,0);
	 * System.out.println(voutput);
	 * 
	 * }
	 */

	public String ReadCellData(int vrow, int vcoloumn) 
	{
		//String value=null;//variable for store the cellvalue
		Workbook wb=null;//initialize the workbook null
		
		try
		{
			//read data from a file in the form of bytes
			FileInputStream fs=new FileInputStream("D:\\workspace-DemoProject\\DemoProject\\src\\main\\resources\\Excel\\ExcelUrl.xlsx");
			wb=new XSSFWorkbook(fs);//constructs an xssfworkbook object,by buffering the whole stream into m/y
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
		}
		
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMYYYY_HHmmsss");
		String timestamp = sdf.format(d);
		Sheet sheet=wb.getSheetAt(1);//get the xssfsheet obj
		Row row=sheet.getRow(vrow);//return the local row
		Cell cell=row.getCell(vcoloumn);//get the cell representing the given coloumn
		switch (cell.getCellType()) 
        {
            case Cell.CELL_TYPE_NUMERIC:
               value  =cell.getNumericCellValue() +timestamp;
                break;
            case Cell.CELL_TYPE_STRING:
               value =cell.getStringCellValue() ;
                break;
        }
		return value;
		
	}
}
