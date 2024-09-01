package Akara.Reoprt;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Logger {
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	static WebDriver driver;
	String destdir ;
	String newimage;
	
	public Logger(WebDriver driver) {
		destdir = makedirectory();
		startReport();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	  public String makedirectory(){
          final String destinationdirectory;
          File destinationDir = new File(System.getProperty("user.dir")+"/test-output/image/"+getTime());
          boolean successful = destinationDir.mkdir();
          if (successful) {
            // System.out.println("Image dir created successfully");
          }
          
      destinationdirectory = destinationDir.getAbsolutePath();
      return destinationdirectory;
  }

  public String getTime(){
      Date myDate = new Date();
      String  time = (new SimpleDateFormat("yyyy_dd_MM_hh_mm").format(myDate));        
      return time;
  }   
	 
	
	public String capture(String name ) {
        try {
        	
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File(destdir+"/"+name);
            FileUtils.moveFile(scrFile, dest);
            newimage = dest.getAbsolutePath();
            System.out.println(newimage);
  
        }catch (Exception e) {e.printStackTrace();}
        return newimage;
    }
	
	public void startReport()
	{   
		System.out.println("Initialize start");
	    htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/Reports/Applitool_Results/"+"_"+getTime()+"_ApplitoolsReport.html");
	    extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("OS", "Window 10");
		extent.setSystemInfo("Host Name","automation");
		extent.setSystemInfo("Environment", "QA-Automation");
		extent.setSystemInfo("Developed By", "Automation Team");
		htmlReporter.config().enableTimeline(true);
		htmlReporter.config().setAutoCreateRelativePathMedia(true);
		htmlReporter.config().setCSS("css-string");
		//htmlReporter.config().setDocumentTitle("page title");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setJS("js-string");
		htmlReporter.config().setProtocol(Protocol.HTTPS);
		htmlReporter.config().setReportName("Test");
		//htmlReporter.config().setTheme(Theme.DARK);
		//htmlReporter.config().setViewStyle("alt-view");
		htmlReporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
		
		
		htmlReporter.config().setDocumentTitle("Akara");
		htmlReporter.config().setReportName("Akara  LinkChecker and Contact US Form");
		htmlReporter.config().setTheme(Theme.DARK);
		test = extent.createTest("AKARA AUTOMATION REPORT", "Akara Automation TestCase");
        System.out.println("Initliaze done");

		
	}
	
	   public void info(String...stats) throws Exception{
		 
		   if( stats.length == 2 && stats[1].toString().equalsIgnoreCase("PASS")){ 
			   test.log(Status.PASS, MarkupHelper.createLabel(stats[0], ExtentColor.GREEN));
		   }
		   if(stats.length == 3 && stats[1].toString().equalsIgnoreCase("PASS")) {
			   System.out.println("info" + stats[1]);
			   test.log(Status.PASS,stats[0], MediaEntityBuilder.createScreenCaptureFromPath(capture(stats[2])).build());
		   } 
		   if( stats.length == 2 && stats[1].toString().equalsIgnoreCase("FAIL")){ 
			   test.log(Status.FAIL, MarkupHelper.createLabel(stats[0], ExtentColor.RED));
		   }
		   if(stats.length == 3 && stats[1].toString().equalsIgnoreCase("FAIL")) {
			   test.log(Status.FAIL,stats[0], MediaEntityBuilder.createScreenCaptureFromPath(capture(stats[2])).build());
		   } 
	   }
	   
	   public void error(String... datas) throws IOException{
		   
			   if (datas.length == 3  && datas[1].toString().equalsIgnoreCase("fail") ) {
				   test.log(Status.FAIL,datas[0], MediaEntityBuilder.createScreenCaptureFromPath(capture(datas[2])).build());
			   }
			   if (datas.length == 2 && datas[1].toString().equalsIgnoreCase("fail")) {
				   test.log(Status.FAIL, MarkupHelper.createLabel(datas[0], ExtentColor.RED));
			   }
		   
	   }
	   
	   public void excp(String... datas) throws Exception
	   {
		   if (datas.length == 1  )  {
			   System.out.println(datas[0].toString());
			   test.log(Status.FAIL, MarkupHelper.createLabel(datas[0].toString(), ExtentColor.RED));
		   }
		   if (datas.length == 2  && datas[1].toString().contains(".png") || datas[1].toString().contains(".jpeg") )  {
			   System.out.println(datas[0].toString());
			   test.log(Status.FAIL,datas[0].toString(), MediaEntityBuilder.createScreenCaptureFromPath(capture(datas[1])).build());
		   }
	   }
	   
	   public void reportClose() {
		   if (extent != null) {
			   extent.flush();
		   }
	   }
	  	   
}
