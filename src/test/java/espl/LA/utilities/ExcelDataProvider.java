package espl.LA.utilities;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook workbook;
	
/*	public ExcelDataProvider()
	{
	File src=new File("./TestData/TestData.xlsx");
	
	
	FileInputStream file;
	try {
		file = new FileInputStream(src);
		
	    workbook= new XSSFWorkbook(file);
		}
		
		catch (Exception e)
		{
			System.out.println("Unable to read Excel file"+e.getMessage());
		}
	
	}*/	

	public void ExcelDataProvider(String filepath)
	{
	File src=new File(filepath);
	
	
	FileInputStream file;
	try {
		file = new FileInputStream(src);
		
	    workbook= new XSSFWorkbook(file);
		}
		
		catch (Exception e)
		{
			System.out.println("Unable to read Excel file"+e.getMessage());
		}
	
	}
	
	
	public String getStringData(int sheetIndex,int row,int column)
	{
		return workbook.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
		
	}
	
	public String getStringData(String sheetName,int row,int column)
	{
		return workbook.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
		
	}
	
	
	public double getNumericData(String sheetName,int row,int column)
	{
		return workbook.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();

	}


	}
	
	
	
	
	
	
	
	
	
	
