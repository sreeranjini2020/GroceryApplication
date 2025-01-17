package testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;

public class LoginPageTest extends BaseClass {
	LoginPage lp;
	HomePage hp;

	@Test(priority=1)
	public void LoginWithValidCredential() throws Exception {
		lp = new LoginPage(driver);
		// hp = new HomePage(driver);
		//hp = lp.login("admin", "admin");
		hp = lp.login(groceryApplicationData(1, 1), groceryApplicationData(1, 2));
		String actual = hp.getHomePageHeading();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constant.lp_verifyLoginWithValidCredential);// assertion to compare 2 values
																						// , here actual and expected
																						// are compared
		// Assertion 2 type : hard(above assertion) and soft

	}

	@Test (priority=2, dataProvider = "data-provider")
	public void LoginWithInvalidCredential(String username, String password) throws Exception {
		lp = new LoginPage(driver);
		hp = lp.login(username, password);
		String actual = lp.readErrorMessage();
		String expected = "Alert!";
		Assert.assertEquals(actual, expected, "::Verify login message not as expected");

	}

	@DataProvider(name = "data-provider")
	public Object[][] dpMethod() throws IOException {
		return new Object[][] { 
			{groceryApplicationData(2,1), groceryApplicationData(2,2)},
			{groceryApplicationData(3,1), groceryApplicationData(3,2)}, 
			{groceryApplicationData(4,1), groceryApplicationData(4,2)}		 
			};
	}

}
