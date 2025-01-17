package testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageNewsPage;

public class ManageNewsTest extends BaseClass {
	
	LoginPage lp;
	HomePage hp;
	ManageNewsPage mnp;
	
	@Test(enabled = false)
	public void verifyMessageoOnDeleteAllNews() throws IOException, Exception  {		
		lp = new LoginPage(driver);
		hp = lp.login(groceryApplicationData(1, 1), groceryApplicationData(1, 2));
		mnp = hp.clickOnManageNewsMenu();
		mnp.deleteAllNews();
		boolean alertStatus = mnp.getMessage().contains("RESULT NOT FOUND");
		Assert.assertEquals(alertStatus, true, "Result not as expected");
	}
	
	@Test(enabled = true)
	public void verifyAlertMessageOnCreateNews() throws IOException, Exception  {		
		lp = new LoginPage(driver);
		hp = lp.login(groceryApplicationData(1, 1), groceryApplicationData(1, 2));
		mnp = hp.clickOnManageNewsMenu();
		mnp.AddNews(groceryApplicationData(49, 1), groceryApplicationData(49, 2));
		boolean alertStatus = mnp.getAlertMessage().contains("News Created Successfully");
		Assert.assertEquals(alertStatus, true, "Result not as expected");
	}
	
	@Test(enabled = false)
	public void verifyRemoveDuplicateNews() throws IOException, Exception  {		
		lp = new LoginPage(driver);
		hp = lp.login(groceryApplicationData(1, 1), groceryApplicationData(1, 2));
		mnp = hp.clickOnManageNewsMenu();
		mnp.removeDuplicateNews();
//		boolean alertStatus = mnp.getMessage().contains("News Created Successfully");
//		Assert.assertEquals(alertStatus, true, "Result not as expected");
	}
	
	
}
