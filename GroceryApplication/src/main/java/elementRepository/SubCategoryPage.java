package elementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtilities;

public class SubCategoryPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	WaitUtilities wu = new WaitUtilities();

	public SubCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(xpath = "//select[@id='cat_id']")
	WebElement categoryField;
	@FindBy(xpath = "//input[@id ='subcategory']")
	WebElement subCategoryField;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveButton;
	@FindBy(xpath = " //div[@class='alert alert-success alert-dismissible']")
	WebElement alertMessage;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;
	@FindBy(xpath = "//select[@id='un']")
	WebElement categoryFieldInsideSearch;
	@FindBy(xpath = "//input[@name='ut']")
	WebElement subCategoryInsideSearch;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	WebElement searchButtonInsideSearch;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	WebElement subCategoryNameFromSearchList;
	@FindBy(xpath = "//div[@class='card-body table-responsive p-0']//table//tbody//tr//td[1]")
	List<WebElement> tableSize;
	@FindBy(xpath = "//button[text()='Update']")
	WebElement updateButton;
	@FindBy(xpath = "//span[@id='res']//Center")
	WebElement deleteMessage;
	

	public void addSubCategory(String category, String subCategory) {
		newButton.click();
		gu.selectDropdownWithVisibleText(categoryField, category);
		subCategoryField.sendKeys(subCategory + gu.generateCurrentDateAndTime());
		saveButton.click();
	}

	public String getAlertMessage() {
		return alertMessage.getText();
	}

	public void searchSubCategory(String category, String subCategory) {
		searchButton.click();
		gu.selectDropdownWithVisibleText(categoryFieldInsideSearch, category);
		subCategoryInsideSearch.sendKeys(subCategory);
		searchButtonInsideSearch.click();
	}

	public String searchResult() {
		return subCategoryNameFromSearchList.getText();
	}

	public void changeStatusOfSelectedSubCategory(String subCategory) {
		for (int i = 0; i < tableSize.size(); i++) {
			if (tableSize.get(i).getText().equals(subCategory)) {
				String statusElement = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+ (i + 1) + "]//td[4]//a//span";
				WebElement statusButton = driver.findElement(By.xpath(statusElement));
				gu.clickJavaScriptExecutor(driver, statusButton);
			}
		}
	}

	public void editSelectedSubCategory(String subCategory, String editValue) {
		for (int i = 0; i < tableSize.size(); i++) {
			if (tableSize.get(i).getText().equals(subCategory)) {
				String editElement = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+ (i + 1) + "]//td[5]//a[1]";
				WebElement editButton = driver.findElement(By.xpath(editElement));
				gu.clickJavaScriptExecutor(driver, editButton);
				subCategoryField.sendKeys(editValue);
				gu.clickJavaScriptExecutor(driver, updateButton);							
			}
		}
	}
	
	public void deleteSelectedSubCategory(String subCategory) {
		for (int i = 0; i < tableSize.size(); i++) {
			if (tableSize.get(i).getText().equals(subCategory)) {
				String deleteElement = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+ (i + 1) + "]//td[5]//a[2]";
				WebElement deleteButton = driver.findElement(By.xpath(deleteElement));
				gu.clickJavaScriptExecutor(driver, deleteButton);
				gu.alertAccept(driver);
			}
		}
	}

	public String deleteMessage() {
		return deleteMessage.getText();
	}

}

/*
 * String path =
 * "//div[@class='card-body table-responsive p-0']//table//tbody//tr["+gu.
 * selectRowNumberFromDynamicTable(tableSize, subCategoryName)+"]//td[5]//a[2]";
 * WebElement element = driver.findElement(By.xpath(path)); element.click();
 */
