package Akara;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Akara.Reoprt.Logger;


public class Smoke {
	private static XSSFSheet excelsheet;
	private static 	XSSFWorkbook  excelworkbook;

	private static XSSFCell cell;
	private static XSSFRow row;
	public static String loginurl;
 //	WebDriver driver;
	public static WebDriver driver;
	 static Logger logger;
	
	//public static void main(String[] args) throws Exception {
	 
	 @Test
	public void launch() throws Exception {

		try {	
			logger = new Logger(driver);  
			//HSSFWorkbook myExcelBook = new HSSFWorkbook(new FileInputStream(file));
			FileInputStream ExcelFileToRead = new FileInputStream(System.getProperty("user.dir") +"/TestData.xlsx");
			excelworkbook = new XSSFWorkbook(ExcelFileToRead);
			excelsheet = excelworkbook.getSheetAt(0);
			System.out.println(excelsheet.getLastRowNum());
			for (int j = 1; j <= excelsheet.getLastRowNum(); j++) {
				//System.out.println("HELLO");
				cell = excelsheet.getRow(j).getCell(1);
				System.out.println("Going to launch URL");
							String loginurl = cell.getStringCellValue();
							System.out.println(loginurl);
							
						
							/*logger.info("Opening the URL: "+loginurl, "PASS" );
							Contact home = new Contact();
							home.runTest(loginurl, logger);
							Thread.sleep(4000);*/
							
							logger.info("Opening the URL: "+loginurl, "PASS" );
							Gallery gallery = new Gallery();
							gallery.runTest(loginurl, logger);
							Thread.sleep(4000);
							
							
							
						}			
			ExcelFileToRead.close();
			logger.reportClose();
						 }catch (Exception e) { 
							e.printStackTrace();
						}
	}
	
	
	

}
