package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageContactPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	
	public ManageContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//i[@class='fas fa-edit']")
	WebElement editButton;
	@FindBy(id = "phone")
	WebElement phoneNumberField;
	@FindBy(name = "Update")
	WebElement updateButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertMessage;
	
	public void editContact(String phone) {
		editButton.click();
		phoneNumberField.clear();		
		phoneNumberField.sendKeys(phone);
		gu.clickJavaScriptExecutor(driver, updateButton);
	}
	public String getAlertMessage() {
		return alertMessage.getText();
	}


}
