package src.com.thinksys.testsuite;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterClass;
import src.com.thinksys.driver.Driver;
import src.com.thinksys.testcases.SterlingcontactUS;
import src.com.thinksys.testcases.UrlPageTestCase;
import src.com.thinksys.utilities.DataUtil;
//import src.com.thinksys.utilities.DataUtil;
//import src.com.thinksys.utilities.Logger;
import src.com.thinksys.utilities.Logger;

public class Smoke {

	public WebDriver driver;
	private static XSSFSheet excelsheet;
	private static 	XSSFWorkbook  excelworkbook;
	private static XSSFCell cell;
	private static XSSFRow row;
	public static String runTestOn;
	Logger logger;

	 @BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {

		try {
			System.out.println("************ WelCome Sterling Website************");
	
			DataUtil.setExcelFileGeneralData();
		    runTestOn  = DataUtil.getGeneralCellData(1,0);
			System.out.println(runTestOn);
			
			switch(runTestOn)
		     {
		    case "MobileDriver":
		    	System.out.println("Inside MobileDriver Case");
		    	driver = Driver.mobiledriver();
		    	break;
			case "ChromeDriver":
			 	System.out.println("Inside ChromeDriver Case");
				driver = Driver.chromedriver();
				break;
			case "ChromeSize310,500":
			 	System.out.println("Inside ChromeSize310,500 Case");
				driver = Driver.chromedriver();
				break;
			case "ChromeSize470,640":
			 	System.out.println("Inside ChromeSize470,640 Case");
				driver = Driver.chromedriver();
				break;
			  
		        default:
			  System.out.println("No Driver Defined in the General sheet");
		      }
			
			
			
			logger = new Logger(driver);   
			DataUtil.setExcelFileContactUsURL();
			System.out.println("Smoke:" + driver);

		} catch (Exception e) {
			throw new IllegalStateException("Can't start Web Driver", e);
		}
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			logger.reportClose();
			driver.close();

			driver.quit();
			System.out.println("Done");

		}
	}

	@Parameters({ "firstname" , "lastname", "phone" , "email" , "message"})
	@Test(description = "Main")
	
		public void testDrive(String firstname , String lastname,  String phone, String email , String message)throws Exception
	{
		/*
		 * logger = extent.createTest("ContactUs form"); logger.log(Status.INFO,
		 * "Going to click on ContactUs form");
		 */
		runTestOn  = DataUtil.getGeneralCellData(1,0);
		FileInputStream ExcelFileToRead = new FileInputStream("C:\\Users\\thinksysuser\\Desktop\\Personal\\RazzSitesAutomation\\RazzSitesAutomation\\TestData.xlsx");
		excelworkbook = new XSSFWorkbook(ExcelFileToRead);
		excelsheet = excelworkbook.getSheetAt(1);
		for (int j = 1; j <= excelsheet.getLastRowNum(); j++) {
			cell = excelsheet.getRow(j).getCell(1);
			System.out.println("Going to print data");
						String loginurl = cell.getStringCellValue();
						System.out.println(loginurl);
						
						openURLPage(loginurl , runTestOn);
						doFillContactUsForm(firstname, lastname, phone, email, message, runTestOn);
						logger.info(" Test Done Successfully Successfully", "PASS" );
						
						
						
		} 
		ExcelFileToRead.close();
		excelworkbook.close();
		
	}
	
	//@Test(description = "Launches the URL Page")
		public void openURLPage(String loginurl, String runTestOn)throws Exception {
			
			UrlPageTestCase urlpageobj = new UrlPageTestCase(driver , logger);
			urlpageobj.hiturlpage(loginurl, runTestOn);
		
		}

	//@Test(description = "Launches the ContactUS Page")
	public void doFillContactUsForm(String firstname , String lastname,  String phone, String email , String message,String runTestOn) throws Exception {
		SterlingcontactUS contactuspage = new SterlingcontactUS(driver ,logger);
		contactuspage.contactUstestcase(firstname,lastname, phone,email,message,runTestOn);
		
	}

	//@Test(description = "Going to check lightbox at Home")


	}


