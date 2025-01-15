package testCase;


import java.io.IOException;
import org.testng.annotations.Test;

import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageContactPage;

public class ManageContactPageTest extends BaseClass {
	
	LoginPage lp;
	HomePage hp;
	ManageContactPage mcp;
	
	@Test(enabled = true)
	public void verifyCreateNewCategory() throws IOException  {
		lp = new LoginPage(driver);
		hp = lp.login(groceryApplicationData(1, 1), groceryApplicationData(1, 2));
		mcp = hp.clickOnManageContactMenu();
		mcp.editContact(groceryApplicationData(29, 1));
		
	}
}
