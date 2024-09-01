package Akara;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.selenium.fluent.Target;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;
import Akara.Reoprt.Logger;


public class Contact {
	
		

		public static WebDriver webDriver;
		public static Eyes initializeEyes(VisualGridRunner runner) throws Exception {
			
			DataUtils.setExcelFileGeneralData();
			String API = DataUtils.getGeneralCellData(1,0);
			Eyes eyes = new Eyes(runner);
			eyes.setApiKey(API);
			eyes.setForceFullPageScreenshot(true);
			Configuration sconf = new Configuration();
			sconf.setAppName("Real Estate");
			sconf.setTestName("ContactPage");
			eyes.setConfiguration(sconf);
			return eyes;
		}
		
		public void runTest(String loginurl ,  Logger logger) throws Exception {
			// Create a runner with concurrency of 10
			VisualGridRunner runner = new VisualGridRunner(10);

			// Initialize Eyes with Ultrafast Grid Runner
			Eyes eyes = initializeEyes(runner);
			String exePath = "C:\\Users\\thinksysuser\\Desktop\\Applications\\Drivers\\chromedriver_win32\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", exePath);

			webDriver = new ChromeDriver();
			logger.info("Inside Contact US Page", "PASS");
			webDriver.get(loginurl);
			logger.info("Url Page Open Successfully and URL is : " + loginurl, "PASS");			
			webDriver.manage().window().maximize();
			Thread.sleep(20000);
			JavascriptExecutor js = (JavascriptExecutor) webDriver;
			webDriver.navigate().to(loginurl);
			Thread.sleep(3000);
			eyes.open(webDriver);
			System.out.println("GOing to click Contact button ");
			webDriver.findElement(By.xpath("//*[@href='/contact']")).click();
			Thread.sleep(5000);			
			System.out.println("Button clicked");
			Thread.sleep(5000);
			eyes.check(Target.window().fully().withName("Contact Page"));	
			
			

			
			webDriver.quit();
			logger.info(
					"Please wait... we are now: \\n1. Uploading resources, \\n2. Rendering in Ultrafast Grid, and \\n3. Using Applitools A.I. to validate the checkpoints. \\nIt'll take about 30 secs to a minute...",
					"PASS");
			System.out.println("Please wait... we are now: \n1. Uploading resources, \n2. Rendering in Ultrafast Grid, and \n3. Using Applitools A.I. to validate the checkpoints. \nIt'll take about 30 secs to a minute...");
			eyes.closeAsync();

		
			
		}


}
