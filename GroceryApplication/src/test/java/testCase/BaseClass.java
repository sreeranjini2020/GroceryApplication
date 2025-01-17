package testCase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.EncryptDecryptUtility;
import utilities.ExcelUtilities;
import utilities.ScreenShotCapture;

public class BaseClass {
	WebDriver driver;
	ScreenShotCapture sc;
	public static Properties pro;

	public static String groceryApplicationData(int row, int column) throws IOException {
		String data = ExcelUtilities.readStringData(row, column,
				System.getProperty("user.dir") + "\\src\\main\\resources\\Excel\\loginCredientials.xlsx", "Sheet_1");
		return data;
		// C:\Users\minnu\eclipse-workspace\GroceryApplication=System.getProperty("user.dir")
		// C:\Users\minnu\eclipse-workspace\GroceryApplication\src\main\resources\Excel\loginCredientials.xlsx
	}	

	public static void testBasic() throws IOException {

		pro = new Properties();
		FileInputStream fp = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Properties\\config.properties");
		pro.load(fp);
	}

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void beforeMethod(String browserName) throws IOException {
		testBasic();
		if (browserName.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equals("edge")) {
			driver = new EdgeDriver();
		}
		// driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.get(pro.getProperty("BaseUrl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));// Polymorphism- method overloading
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethode(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			sc = new ScreenShotCapture();
			sc.captureFailureScreenShot(driver, iTestResult.getName());
		}
		driver.quit();

	}

}
