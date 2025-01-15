package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;// instance variable

	// create a constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// with PageFactory(PageFactory is used @findBy notation), initElement -
												// PageFactory static method
	}
	
    //WebElement declaration
	@FindBy(xpath = "//input[@name ='username']")
	WebElement userNameField;
	@FindBy(name = "password")
	WebElement passwordField;
	@FindBy(xpath = "//button[text() ='Sign In']")
	WebElement signInButton;	
	@FindBy(xpath="//h5[text()=' Alert!']")
	WebElement errorMessage;	
	
	
    //function
	public HomePage login(String userName, String password) {
		userNameField.sendKeys(userName);
		passwordField.sendKeys(password);
		signInButton.click();
		return new HomePage(driver);
	}
	
	public String readErrorMessage() {
		return errorMessage.getText();
	}

}
