package testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.SubCategoryPage;

public class SubCategoryPageTest extends BaseClass {
	LoginPage lp;
	HomePage hp;
	SubCategoryPage scp;

	@Test(enabled = true)
	public void verifyAlertMessageOnCreatingNewSubCategory() throws IOException {
		lp = new LoginPage(driver);
		hp = lp.login(groceryApplicationData(1, 1), groceryApplicationData(1, 2));
		scp = hp.clickOnSubCatagoryMenu();
		scp.addSubCategory(groceryApplicationData(7, 1), groceryApplicationData(7, 2));
		boolean alertStatus = scp.getAlertMessage().contains("Sub Category Created Successfully");
		Assert.assertEquals(alertStatus, true, "Alert message not as expected");
	}

	@Test(enabled = true)
	public void verifySubCategorySearchDisplaysCorrectResults() throws IOException {
		lp = new LoginPage(driver);
		hp = lp.login(groceryApplicationData(1, 1), groceryApplicationData(1, 2));
		scp = hp.clickOnSubCatagoryMenu();
		scp.searchSubCategory(groceryApplicationData(8, 1), groceryApplicationData(8, 1));
		boolean alertStatus = scp.searchResult().contains(groceryApplicationData(8, 1));
		Assert.assertEquals(alertStatus, true, "Result not as expected");
	}

	@Test(enabled = true)
	public void verifyAlertMessageOnChangingStatusOfSelectedSubCategory() throws IOException {
		lp = new LoginPage(driver);
		hp = lp.login(groceryApplicationData(1, 1), groceryApplicationData(1, 2));
		scp = hp.clickOnSubCatagoryMenu();
		scp.changeStatusOfSelectedSubCategory(groceryApplicationData(9,2));
		boolean alertStatus = scp.getAlertMessage().contains("Sub Category Status Changed Successfully");
		Assert.assertEquals(alertStatus, true, "Alert message not as expected");
	}
	
	@Test(enabled = true)
	public void verifyAlertMessageForEditingSubCategory() throws IOException {
		lp = new LoginPage(driver);
		hp = lp.login(groceryApplicationData(1, 1), groceryApplicationData(1, 2));
		scp = hp.clickOnSubCatagoryMenu();
		scp.editSelectedSubCategory(groceryApplicationData(10, 2), groceryApplicationData(10, 3));
		boolean alertStatus = scp.getAlertMessage().contains("Sub Category Updated Successfully");
		Assert.assertEquals(alertStatus, true, "Alert message not as expected");
	}
	
	@Test(enabled = true)
	public void deleteSubCategoryItemAndVerifyItemIsRemoved() throws IOException {
		lp = new LoginPage(driver);
		hp = lp.login(groceryApplicationData(1, 1), groceryApplicationData(1, 2));
		scp = hp.clickOnSubCatagoryMenu();
		scp.deleteSelectedSubCategory(groceryApplicationData(11, 2));
		scp.searchSubCategory(groceryApplicationData(11, 1), groceryApplicationData(11, 2));
		boolean deleteAlertStatus = scp.deleteMessage().contains(".........RESULT NOT FOUND.......");
		Assert.assertEquals(deleteAlertStatus, true, "Delete alert message not as expected");
	}

}
