package src.com.thinksys.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import src.com.thinksys.pages.ContactUsPage;
import src.com.thinksys.utilities.Logger;

public class SterlingcontactUS {
	private ContactUsPage urlobj;
	private Logger logger ;

	public SterlingcontactUS(WebDriver driver, Logger logger ) {
		this.logger = logger;
	    System.out.println("UrlPageTestCase:"+driver);
		urlobj = PageFactory.initElements(driver, ContactUsPage.class);
	}
	
	public void contactUstestcase(String firstname ,String lastname, String phone, String email , String message ,  String runTestOn) throws Exception
	{
		System.out.println("This is inside contactUstestcase test case page");
		try {
			
			urlobj.formFill(firstname,lastname, phone, email,message , runTestOn, logger );
		}
		catch (Exception e)
		{
		e.printStackTrace();
		}
	}
}
