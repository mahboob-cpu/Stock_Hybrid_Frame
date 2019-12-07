package Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class xlutils


{
Workbook wb;
public  xlutils() throws Exception

{	

	FileInputStream fi=new FileInputStream("C:\\Users\\mahboob.m\\Desktop\\Copy of InputSheet.xlsx");
	
	Workbook wb=new XSSFWorkbook(fi);
	
}
public int rowcount(String sheetname)
{

	return wb.getSheet(sheetname).getLastRowNum();
	
}
	public int colcount(String sheetname)
	{
	return wb.getSheet(sheetname).getRow(0).getLastCellNum();	
		
	}
	
	@SuppressWarnings("deprecation")
	public String gatdata(String sheetname,int rowcount,int colcount)
	{
		String Data = null;
		if(wb.getSheet(sheetname).getRow(rowcount).getCell(colcount). getCellType()==Cell.CELL_TYPE_NUMERIC)
		{
			int Celldata=(int) wb.getSheet(sheetname).getRow(rowcount).getCell(colcount).getNumericCellValue();
			Data=String.valueOf(Celldata);
			
		}else
		{
		wb.getSheet(sheetname).getRow(rowcount).getCell(colcount).getStringCellValue();
		}
		return Data;
		
		
	}
	

public void setdata(String sheetname,int row,int column,String status) throws Exception
	
	{
		Sheet sh=wb.getSheet(sheetname);
		Row rownum=sh.getRow(row);
		Cell cell=rownum.getCell(column);
		cell.setCellValue(status);
		
		
		
		
		if(status.equalsIgnoreCase("pass")){
			CellStyle style=wb.createCellStyle();	
			Font font=wb.createFont();
			font.setColor(IndexedColors.GREEN.getIndex());
			font.setBold(true);
			style.setFont(font);
			rownum.getCell(column).setCellStyle(style);
			
		
			
		}else 
			if(status.equalsIgnoreCase("not executed"))
			{
				CellStyle style=wb.createCellStyle();
				Font font=wb.createFont();
				font.setColor(IndexedColors.RED.getIndex());
				font.setBold(true);
				style.setFont(font);
				rownum.getCell(column).setCellStyle(style);
			}
		FileOutputStream fos=new FileOutputStream("C:\\Users\\mahboob.m\\Desktop\\Copy of InputSheet.xlsx");
		wb.write(fos);
		fos.close();
	}
	
	
}
