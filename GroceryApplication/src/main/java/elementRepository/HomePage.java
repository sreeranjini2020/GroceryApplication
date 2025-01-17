package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;// instance variable

	// create a constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// with PageFactory(PageFactory is used @findBy notation), initElement -
												// PageFactory static method
	}
	@FindBy(xpath="//span[text()='7rmart supermarket']")
	WebElement homePageHeading;	
	@FindBy(xpath="//a//p[text()='Category']")
	WebElement categoryMenu;	
	@FindBy(xpath="//a//p[text()='Sub Category']")
	WebElement subCatagoryMenu;
	@FindBy(xpath="//p[text()='Manage Contact']")
	WebElement manageContactMenu;
	@FindBy(xpath="//p[text()='Manage News']")
	WebElement manageNewsMenu;
	
	
	public String getHomePageHeading() {
		return homePageHeading.getText();		
	}
	
	public CategoryPage clickOnCatagoryMenu() {
		categoryMenu.click();
		return new CategoryPage(driver);
	}
	
	public SubCategoryPage clickOnSubCatagoryMenu() {
		subCatagoryMenu.click();
		return new SubCategoryPage(driver);
	}
	
	public ManageContactPage clickOnManageContactMenu() {
		manageContactMenu.click();
		return new ManageContactPage(driver);
	}
	public ManageNewsPage clickOnManageNewsMenu() {
		manageNewsMenu.click();
		return new ManageNewsPage(driver);
	}
	

}
