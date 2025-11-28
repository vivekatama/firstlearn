package genericUtilityOrLibrary;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.github.dockerjava.api.model.Driver;

import objectRepository.HomePage;
import objectRepository.LoginPage;

/*
 * this is the base class for the common features of this application
 */

public class BaseClass {
	WebDriver driver = null;
	SeleniumUtility SUTIL = null;
	PropertiesUtility PUTIL = new PropertiesUtility();
	
	@BeforeSuite(alwaysRun=true)
	public void createConnection() {
		System.out.println("connection established");
	}
	
	@BeforeClass(alwaysRun=true)
	public void launchBrowser() throws Exception{
		String URL = PUTIL.getDataFromProperties("url");
		SUTIL = new SeleniumUtility();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(URL);
		System.out.println("lunching successfull");
	}
		
	
	@BeforeMethod(alwaysRun=true)
	public void loginApp() throws Exception{
		String USERNAME = PUTIL.getDataFromProperties("username");
		String PASSWORD = PUTIL.getDataFromProperties("password");
		LoginPage LP = new LoginPage(driver);
		LP.login(USERNAME,PASSWORD);
		System.out.println("logi successfull");
	}
	

	@AfterMethod(alwaysRun=true)
	public void logoutApp()throws Exception{
		HomePage hp = new HomePage(driver);
		hp.logoutOperation();
		System.out.println("logout successfull");
	}
	
	@AfterClass(alwaysRun=true)
	public void closeApp(){
		driver.close();
		System.out.println("browser closed successfull");
	}
	
	@AfterSuite(alwaysRun=true)
	public void closeConnection(){
		System.out.println("browser closed successfull");
	}
	
	
	}
