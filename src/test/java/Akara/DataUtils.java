package Akara;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataUtils {
	 
	private static XSSFSheet excelsheet;
	private static 	XSSFWorkbook  excelworkbook;
	private static XSSFCell cell;
	private static XSSFRow row;
	private static 	XSSFWorkbook excelworkbookgeneral;
	private static XSSFSheet excelsheetgeneral;
	private static XSSFCell cellgeneral;

//This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method

public static void setExcelFile() throws Exception {

		try {
			//HSSFWorkbook myExcelBook = new HSSFWorkbook(new FileInputStream(file));
			FileInputStream ExcelFileToRead = new FileInputStream("C:\\Users\\Thinksysuser\\Desktop\\Maven\\tutorial-selenium-java-visualgrid\\TestData.xlsx");
			excelworkbook = new XSSFWorkbook(ExcelFileToRead);
			excelsheet = excelworkbook.getSheetAt(0);
			
		} catch (Exception e){

			throw (e);

		}

}

//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num

public static String getCellData(int RowNum, int ColNum) throws Exception{

		try{
System.out.println("Inside getcelldaya");

			cell = excelsheet.getRow(RowNum).getCell(ColNum);
System.out.println("hxksjh");
			String CellData = cell.getStringCellValue();
			System.out.println(CellData);
			return CellData;

			}catch (Exception e){

			return"";

			}

}


public static void setExcelFileGeneralData() throws Exception {

	try {
		//HSSFWorkbook myExcelBook = new HSSFWorkbook(new FileInputStream(file));
		FileInputStream ExcelFileToRead = new FileInputStream(System.getProperty("user.dir") +"/TestData.xlsx");
		excelworkbookgeneral = new XSSFWorkbook(ExcelFileToRead);
		excelsheetgeneral = excelworkbookgeneral.getSheetAt(3);
		
	} catch (Exception e){

		throw (e);

	}

}
public static String getGeneralCellData(int RowNum, int ColNum) throws Exception{

	try{
		System.out.println("Inside getGeneralcelldaya");
		cellgeneral = excelsheetgeneral.getRow(RowNum).getCell(ColNum);
		System.out.println("General cell Data");
		String CellData = cellgeneral.getStringCellValue();
		System.out.println(CellData);
		return CellData;

		}catch (Exception e){

		return"";

		}

}

//This method is to write in the Excel cell, Row num and Col num are the parameters

public static void setCellData(String Result,  int RowNum, int ColNum) throws Exception	{

		try{

			row  = excelsheet.getRow(RowNum);

		    cell = row.getCell(ColNum);

		if (cell == null) {

			cell = row.createCell(ColNum);

			//cell.setCellValue(Result);

			} else {

				//cell.setCellValue(Result);

			}

// Constant variables Test Data path and Test Data file name

				FileOutputStream fileOut = new FileOutputStream(System.getProperty("user.dir")+"/TestDataResult.xlsx");

				excelworkbook.write(fileOut);

				fileOut.flush();

				fileOut.close();

			}catch(Exception e){

				throw (e);

		}

	}



}