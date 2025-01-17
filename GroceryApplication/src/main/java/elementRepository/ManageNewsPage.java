package elementRepository;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.GeneralUtilities;
import utilities.WaitUtilities;

public class ManageNewsPage {

	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	WaitUtilities wu = new WaitUtilities();

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='card-body table-responsive p-0']//table//tbody//tr//td[1]")
	List<WebElement> newsList;
	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-danger btncss']")
	List<WebElement> deleteButtons;
	@FindBy(xpath="//center[text()='.........RESULT NOT FOUND.......']")
	WebElement resultNotFoundText;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(id = "news")
	WebElement newsTextField;
	@FindBy(xpath="//button[text()='Save']")
	WebElement saveButtonInsideNew;
	@FindBy(xpath = " //div[@class='alert alert-success alert-dismissible']")
	WebElement alertMessage;
	

	public void deleteAllNews() {
		while (true) {
			if (deleteButtons.isEmpty()) {
				break;
			}
			WebElement deleteButton = deleteButtons.get(0);
			gu.clickJavaScriptExecutor(driver, deleteButton);
			wu.waitForAlertIsPresent(driver, 20);
			driver.switchTo().alert().accept();
		}
	}
	
	public String getMessage() {
		return resultNotFoundText.getText();
	}
	
	public void AddNews(String news, String number){
		newButton.click();
		int count = Integer.parseInt(number); 
		for(int i = 0; i < count; i++) {		
		newsTextField.sendKeys(news);
		saveButtonInsideNew.click();
		}		
	}
	
	public String getAlertMessage() {
		return alertMessage.getText();
	}

	public void removeDuplicateNews() {
		Set<String> seenNews = new HashSet<>();

		// Loop from the end to avoid index shifting when deleting items
		for (int i = newsList.size() - 1; i >= 0; i--) {
			String currentNews = newsList.get(i).getText().trim();

			// If already seen, delete it; else, add to seen set
			if (seenNews.contains(currentNews)) {
				String deleteButtonXPath = "//div[@class='card-body table-responsive p-0']//table//tbody//tr[" + (i + 1)
						+ "]//td[2]//a[2]";
				WebElement deleteButton = driver.findElement(By.xpath(deleteButtonXPath));
				gu.clickJavaScriptExecutor(driver, deleteButton);
				driver.switchTo().alert().accept(); // Confirm deletion
			} else {
				seenNews.add(currentNews);
			}
		}
	}

}
