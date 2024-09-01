package src.com.thinksys.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Driver {

	public static WebDriver driver;
	public static String  currentroot = System.getProperty("user.dir");

	public static WebDriver chromedriver() {
		try {
			String path = "C:\\Users\\thinksysuser\\Desktop\\Applications\\Drivers\\chromedriver_win32\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", path);
			driver = new ChromeDriver();
			System.out.println("Going to initilize chrome driver");
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			//driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.out.println("Driver is not initiated due to : ");
			e.printStackTrace();
		}

		return driver;
	}
	public static WebDriver mobiledriver() {
		try {
			String path = "C:\\Users\\thinksysuser\\Desktop\\Applications\\Drivers\\chromedriver_win32\\chromedriver.exe";
			Map<String, String> mobileEmulation = new HashMap<String, String>();
			mobileEmulation.put("deviceName", "Nexus 5");
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
			System.setProperty("webdriver.chrome.driver", path);
			 driver = new ChromeDriver(chromeOptions);
			System.out.println("Going to initilize Mobile driver");
			
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		
/* 
Map<String, Object> deviceMetrics = new HashMap<>();
deviceMetrics.put("width", 360);
deviceMetrics.put("height", 640);
deviceMetrics.put("pixelRatio", 3.0);
Map<String, Object> mobileEmulation = new HashMap<>();
mobileEmulation.put("deviceMetrics", deviceMetrics);
mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19");
ChromeOptions chromeOptions = new ChromeOptions();
chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
WebDriver driver = new ChromeDriver(chromeOptions);

 */
					
		} catch (Exception e) {
			System.out.println("Driver is not initiated due to : ");
			e.printStackTrace();
		}

		return driver;
	}
}