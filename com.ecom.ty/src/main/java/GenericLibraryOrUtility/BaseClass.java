package GenericLibraryOrUtility;
/*
 * this the base class for all the common features 
 * @author vivek singh
 * @version 5.1.1
 */

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import objectRepository.DashboasrdPage;
import objectRepository.LoginPage;

public class BaseClass {
	public static WebDriver driver = null;
	public PropertiesUtility PUTIL = new PropertiesUtility();

	@BeforeSuite(alwaysRun = true)
	public void connectDatabae() {
		System.out.println("Db connection succesfull..");
	}
	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void launchBrowser(String browser ) throws Exception {
		String URL = PUTIL.getDataFromProperties("url");
		if(browser.equals("chrome")) {
			driver = new ChromeDriver();
		}
		if(browser.equals("Edge")) {
			driver = new EdgeDriver();
		}
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(URL);
		System.out.println("browser launched successfully!!");
	}

	@BeforeMethod(alwaysRun = true)
	public void loginUser() throws Exception {
		String USERNAME = PUTIL.getDataFromProperties("username");
		String PASSWORD = PUTIL.getDataFromProperties("password");
		LoginPage lp = new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);
		System.out.println("Login successfull!!");
	}

	@AfterMethod(alwaysRun = true)
	public void logoutUser() {
		DashboasrdPage dp = new DashboasrdPage(driver);
		dp.logoutOperation();
		System.out.println("logout succesfull");
	}

	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
		System.out.println("browser closed successfully!!!");
	}

	@AfterSuite(alwaysRun = true)
	public void closeDbConnection() {
		System.out.println("Db connection closed successfully!!");
	}
}
