package testCase;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.CategoryPage;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.SubCategoryPage;

public class CategoryPageTest extends BaseClass {

	LoginPage lp;
	HomePage hp;
	CategoryPage cp;

	@Test(enabled = true)
	public void verifyCreateNewCategory() throws IOException, AWTException {
		lp = new LoginPage(driver);
		hp = lp.login(groceryApplicationData(1, 1), groceryApplicationData(1, 2));
		cp = hp.clickOnCatagoryMenu();
		String imagePath = System.getProperty("user.dir") + "\\src\\test\\resources\\Images\\image (40).png";		
		cp.createNewCategory(groceryApplicationData(18, 1), imagePath);
		boolean alertStatus = cp.getAlertMessage().contains("Category Created Successfully");
		Assert.assertEquals(alertStatus, true, "Alert message not as expected");
	}
	@Test(enabled = false)
	public void verifySearchSubCategory() throws IOException {
		lp = new LoginPage(driver);
		hp = lp.login(groceryApplicationData(1, 1), groceryApplicationData(1, 2));
		cp = hp.clickOnCatagoryMenu();		
		cp.searchCategory(groceryApplicationData(19, 1));
		boolean alertStatus = cp.searchResult().contains(groceryApplicationData(19, 1));
		Assert.assertEquals(alertStatus, true, "Result not as expected");
	}
	
}