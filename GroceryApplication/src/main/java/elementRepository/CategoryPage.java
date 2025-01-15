package elementRepository;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class CategoryPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	
	public CategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(id = "category")
	WebElement categoryField;
	@FindBy(id= "134-selectable")
	WebElement discountButton;
	@FindBy(id ="main_img")
	WebElement  imageField;
	@FindBy(xpath ="//button[text()='Save']")
	WebElement saveButton;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alertMessage;
	@FindBy(name = "un")
	WebElement categoryFieldInsideSearch;
	@FindBy(name ="Search")
	WebElement searchButtonInsideSearch;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr")
	WebElement searchListtablerow;

	
	public void createNewCategory(String catagory, String imagePath) throws AWTException{
		newButton.click();
		categoryField.sendKeys(catagory + gu.generateCurrentDateAndTime());
		discountButton.click();	
		gu.pageScroll(200, 400, driver);
		imageField.sendKeys(imagePath);
		gu.clickJavaScriptExecutor(driver, saveButton);		
	}
	public String getAlertMessage() {
		return alertMessage.getText();
	}
	
	public void searchCategory(String catagory){
		searchButton.click();
		categoryFieldInsideSearch.sendKeys(catagory);
		searchButtonInsideSearch.click();			
	}
	
	public String searchResult() {		
		return searchListtablerow.getText();
	}

}
