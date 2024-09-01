package src.com.thinksys.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import src.com.thinksys.utilities.Logger;

public class ContactUsPage {

	private WebDriver driver;

	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(linkText = "Contact Us")
	private WebElement contactUsButtonHeader;

	@FindBy(xpath = "//div/div[2]/div/div/div/div[2]/a[5]/span")
	private WebElement contactUsButtonFooterLink;

	@FindBy(xpath = "//div[@id='footer']/div/div[2]/div/div[3]/div/div/a[2]/span")
	private WebElement contactUsButtonFooterButton;

	@FindBy(id = "firstname")
	private WebElement firstNameTextField;

	@FindBy(id = "lastname")
	private WebElement lastNameTextField;

	@FindBy(id = "phone")
	private WebElement phoneTextField;

	@FindBy(id = "email")
	private WebElement emailTextField;

	@FindBy(id = "message")
	private WebElement messageTextField;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitButton;

	@FindBy(xpath = "//span[@id='recaptcha-anchor']/div")
	private WebElement captchaCheckBox;
	
	@FindBy(xpath = "//select[@id='interested']" )
	private WebElement bedroom;
	
	@FindBy(css = "svg.svg-inline--fa.fa-bars.fa-w-14" )
	private WebElement threeBar;

	public ContactUsPage setFirstName(String firstname) {
		firstNameTextField.clear();
		firstNameTextField.sendKeys(firstname);
		return this;
	}

	public ContactUsPage setLastName(String lastname) {
		lastNameTextField.clear();
		lastNameTextField.sendKeys(lastname);
		return this;
	}

	public ContactUsPage setphone(String phone) {
		phoneTextField.clear();
		phoneTextField.sendKeys(phone);
		return this;
	}

	public ContactUsPage setemail(String email) {
		emailTextField.clear();
		emailTextField.sendKeys(email);
		return this;
	}
	public ContactUsPage setbedroom() {
		
		Select sel = new Select(bedroom);
		sel.selectByValue("Studio");
		return this;
	}

	public ContactUsPage setcomment(String comment) {
		messageTextField.clear();
		messageTextField.sendKeys(comment);
		return this;
	}

	public ContactUsPage formFill(String firstname, String lastname, String phone, String email,String comment , String runTestOn , Logger logger)
			throws Exception {

		try {
			logger.info("Inside ContactUS Page" , "PASS");
			System.out.println("Inside Contact us form fill Page");
			logger.info("Going to fill form by clicking on ContactUS button present on Header " , "PASS");
			
			
			
			switch(runTestOn)
		     {
		    case "MobileDriver":
		    	System.out.println("Inside MobileDriver Case");
		    	//driver.findElement(By.cssSelector("svg.svg-inline--fa.fa-bars.fa-w-14")).click();
		    	threeBar.click();
				Thread.sleep(2000);
		    	break;
			case "ChromeDriver":
			 	System.out.println("Inside ChromeDriver Case");
			
				break;
			case "ChromeSize310,500":
			 	System.out.println("Inside ChromeSize310,500 Case");
			 	//driver.findElement(By.cssSelector("svg.svg-inline--fa.fa-bars.fa-w-14")).click();
			 	threeBar.click();
				Thread.sleep(2000);
				break;
			case "ChromeSize470,640":
			 	System.out.println("Inside ChromeSize470,640 Case");
			 	//driver.findElement(By.cssSelector("svg.svg-inline--fa.fa-bars.fa-w-14")).click();
			 	threeBar.click();
				Thread.sleep(2000);
				break;
			  
		        default:
			  System.out.println("Indisde default");
		      
		     }
			
			
//			if(runTestOn.contains("MobileDriver"))
//			{
//				driver.findElement(By.cssSelector("svg.svg-inline--fa.fa-bars.fa-w-14")).click();
//				Thread.sleep(2000);
//			}
//			else {
//				System.out.println("CONTINUE...");
//			}
			
			//contactUsButtonHeader.click();
			Thread.sleep(4000);
			setFirstName(firstname);
			Thread.sleep(1000);

			setLastName(lastname);
			Thread.sleep(1000);

			setphone(phone);
			Thread.sleep(1000);

			setemail(email);
			Thread.sleep(1000);
			
			WebDriverWait wait = new WebDriverWait(driver,1000);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("interested")));
			
			setbedroom();
			Thread.sleep(1000);

			setcomment(comment);
			Thread.sleep(1000);

//			driver.switchTo().frame(0);
//			Thread.sleep(3000);
//			captchaCheckBox.click();
			Thread.sleep(4000);
			logger.info("Filled all the details on the form " , "PASS");
			
			captchaCheckBox.click();
			Thread.sleep(5000);
			
			

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Failed in filling all the details on the form " , "FAIL");
		}
		return this;
	}

}
