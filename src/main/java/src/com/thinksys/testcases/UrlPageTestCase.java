package src.com.thinksys.testcases;
  
import src.com.thinksys.pages.UrlPage;
import src.com.thinksys.utilities.Logger;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;

public class UrlPageTestCase {
    
	
	private UrlPage urlobj;
	private Logger logger ;

	public UrlPageTestCase(WebDriver driver, Logger logger ) {
		this.logger = logger;
	    System.out.println("UrlPageTestCase:"+ driver);
		urlobj = PageFactory.initElements(driver, UrlPage.class);
	}

	public void hiturlpage(String loginurl , String runTestOn) throws Exception {
		System.out.println("going to open URL");
		try {
			urlobj.get(loginurl,runTestOn,logger);
			System.out.println("hit done");
		}

		catch (Exception e) {
		//logger.excp("Error in URLPage TestCase "+e.getMessage());

		}
	}

}
