package src.com.thinksys.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import src.com.thinksys.driver.Driver;
import src.com.thinksys.utilities.Logger;

public class UrlPage {

	private final WebDriver driver;
	private static Dimension d;

	public UrlPage(WebDriver driver) {
		this.driver = driver;

	}

	public UrlPage get(String loginurl,String runTestOn, Logger logger) throws Exception {
		try {
			driver.get(loginurl);
			
			
			System.out.println("RUNTESTON " +runTestOn);
			
			
			switch(runTestOn)
		     {
		    case "MobileDriver":
		    	System.out.println("Inside MobileDriver Case");
		    	driver.manage().window().maximize();
		    	break;
			case "ChromeDriver":
			 	System.out.println("Inside ChromeDriver Case");
			 	driver.manage().window().maximize();
				break;
			case "ChromeSize310,500":
			 	System.out.println("Inside ChromeSize310,500 Case");
				 d = new Dimension(470,640);
		     	//Resize current window to the set dimension
		     	   driver.manage().window().setSize(d);
				break;
			case "ChromeSize470,640":
			 	System.out.println("Inside ChromeSize470,640 Case");
				d = new Dimension(470,640);
		     	//Resize current window to the set dimension
		     	   driver.manage().window().setSize(d);
				break;
			  
		        default:
			  System.out.println("No Driver Defined in the General sheet");
		      }
			

			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

			 driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
			logger.info("Url Page Open Successfully and URL is: " + loginurl + ".", "PASS");

			return this;
		} catch (Exception e) {

		}
		return null;

	}
}
