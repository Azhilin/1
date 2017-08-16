package W13ZhilinComQALightOldByAnnotation.ComQALightOld;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class Zapisatsya {
	WebDriver driver;
	Logger log;
	public Zapisatsya(WebDriver localDriver){
		this.driver = localDriver;
		log = Logger.getLogger(getClass());
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = ".//select")
	WebElement ddKurs;
	
	@FindBy (name = "your-name")
	WebElement inputLastName;
	
	@FindBy (name = "text-68")
	WebElement inputFirstName;
	
	@FindBy (name = "text-297")
	WebElement inputPhoneNumber;
	
	@FindBy (name = "your-email")
	WebElement inputEmail;
	
	@FindBy (name = "text-71")
	WebElement inputSkype;
	
	@FindBy (xpath = ".//input[@type='submit']")
	WebElement submitButton;
	
	@FindBy (xpath = ".//*[contains(@class,'not-valid-tip-no-ajax')]")
	WebElement messageEmptyFieldsError;
	
	@FindBy (xpath = ".//*[contains(@class,'validation-errors')]")
	WebElement messageSendError;
	
	@FindBy (xpath = ".//*[contains(@class, 'mail-sent-ok')]")
	WebElement messageSendOk;

	public void openPage() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://old.qalight.com/zapisatsya-na-kurs/");
		log.info("Page and url have been opened!!!");
	}

	public void selectValueInDDKurs(String nameOfKurs) {
		try {
			Select valueFromDD = new Select(ddKurs);
			valueFromDD.selectByValue(nameOfKurs);
			log.info("Value " + nameOfKurs + "has been selected!!!");
		} catch (Exception e) {
			log.error("Can't work with DD");
			Assert.fail("Can't work with DD");
		}
		
	}

	public void inputTextIntoLastNameField(String localLastName) {
		try {
			inputLastName.sendKeys(localLastName);
			log.info("Last Name has been typed!!!");
		} catch (Exception e) {
			log.error("Can't work with LastName field!!!");
			Assert.fail("Can't work with LastName field!!!");
		}		
	}

	public void inputTextIntoFirstNameField(String localFirstName) {
		try {
			inputFirstName.sendKeys(localFirstName);
			log.info("First Name has been typed!!!");
		} catch (Exception e) {
			log.error("Can't work with FirstName field!!!");
			Assert.fail("Can't work with FirstName field!!!");
		}
		
	}

	public void inputTextIntoPhoneField(String localPhone) {
		try {
			inputPhoneNumber.sendKeys(localPhone);
			log.info("Phone number has been typed!!!");
		} catch (Exception e) {
			log.error("Can't work with phone field!!!");
			Assert.fail("Can't work with phone field!!!");
		}
		
	}

	public void inputTextIntoEmailField(String localEmail) {
		try {
			inputEmail.sendKeys(localEmail);
			log.info("Email has been typed!!!");
		} catch (Exception e) {
			log.error("Can't work with email field!!!");
			Assert.fail("Can't work with email field!!!");
		}
		
	}

	public void inputTextIntoSkypeField(String localSkype) {
		try {
			inputSkype.sendKeys(localSkype);
			log.info("Skype has been typed!!!");
		} catch (Exception e) {
			log.error("Can't work with skype field!!!");
			Assert.fail("Can't work with skype field!!!");
		}
		
	}

	public void submitButtonClick() {
		try {
			submitButton.click();
			log.info("Submit button has been clicked!!!");
		} catch (Exception e) {
			log.error("Can't click submit button!!!");
			Assert.fail("Can't click submit button!!!");
		}
		
	}
	
	public boolean isMessageSendOkPresent() {
		try {
			log.info("Message sent ok is present!!!");
			return messageSendOk.isDisplayed()&&messageSendOk.isEnabled();
		} catch (Exception e) {
			log.error("Message sent ok is not present!!!");
			return false;
		}
	}
	
	public boolean isMessageSendErrorPresent() {
		try {
			log.info("Message sent error is present!!!");
			return messageSendError.isDisplayed()&&messageSendError.isEnabled();
		} catch (Exception e) {
			log.error("Message sent error is not present!!!");
			return false;
		}
	}
	
	public boolean isMessageErrorEmptyFieldsPresent() {
		try {
			log.info("Message errorEmptyFields is present!!!");
			return messageEmptyFieldsError.isDisplayed()&&messageEmptyFieldsError.isEnabled();
		} catch (Exception e) {
			log.error("Message errorEmptyFields is not present!!!");
			return false;
		}
	}

	public void close() {
		driver.quit();
		
	}

	
	

}
