package testCase;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageContactPage;

public class ManageContactPageTest extends BaseClass {
	
	LoginPage lp;
	HomePage hp;
	ManageContactPage mcp;
	
	@Test(enabled = true)
	public void verifyCreateNewCategory() throws IOException, Exception  {
		lp = new LoginPage(driver);	
		String password = lp.decryptPassword(groceryApplicationData(42, 0));
		hp = lp.login(groceryApplicationData(1, 1), password);
		mcp = hp.clickOnManageContactMenu();
		mcp.editContact(groceryApplicationData(29, 1));
		boolean alertStatus = mcp.getAlertMessage().contains("Contact Updated Successfully");
		Assert.assertEquals(alertStatus, true, "Alert message not as expected");
		
	}
}
