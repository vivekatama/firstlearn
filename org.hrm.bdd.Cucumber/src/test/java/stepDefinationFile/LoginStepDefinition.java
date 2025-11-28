package stepDefinationFile;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;

public class LoginStepDefinition {
	static WebDriver driver = null;
	
	
	@Given("Launch the given bowser with the given URL and maximize the window")
	public void launch_the_given_bowser_with_the_given_url_and_maximize_the_window() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	}
//	@Given("Provide valid username and password and click on the login button")
//	public void provide_valid_username_and_password_and_click_on_the_login_button() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
	
//@Given("Launch the given browser with the given URL and maximize the window")
//public void Launch_the_given_browser_with_the_given_URL_and_maximize_the_window() {
//	driver = new ChromeDriver();
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	driver.manage().window().maximize();
//	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//}
//	@Given("provide valid username and password")
//	public void provide_valid_username_and_password() {
//		driver.findElement(By.xpath("//input[@name=\"username\"]"))
//		.sendKeys("Admin", Keys.TAB, "admin123");
//	}
//	

//@given ("provide valid {string}and{string}")	
//public void provide_valid_and(String username, String password) {
//	driver.findelement(by.xpath("//input[@name]"))
//}
	

//@Given("provide valid {string}and{string}")	
//public void provide_valid_and(String username, String password) {
//	driver.findElement(By.xpath("//input[@name='username']"))
//	.sendKeys(username, Keys.TAB, password);
//}

//@Given("provide valid {string}and{string}")	
//public void provide_valid_and(String string, String string2, DataTable dataTable) {
//	List<List<String>> data = dataTable.asLists(String.class);
//	driver.findElement(By.xpath("//input[@name='username']"))
//	.sendKeys(data.get(0).get(0), Keys.TAB, data.get(0).get(1));
//}

//@Given("provide valid usernaem and password")	
//public void provide_valid_and(String string, String string2, DataTable dataTable) {
//	List<List<String>> data = dataTable.asLists(String.class);
//	driver.findElement(By.xpath("//input[@name='username']"))
//	.sendKeys(data.get(0).get(0), Keys.TAB, data.get(0).get(1));
//}

	@Given("Provide valid username and password")
	public void provide_valid_username_and_password(DataTable dataTable) {
	   
		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		driver.findElement(By.xpath("//input[@name='username']"))
		.sendKeys(data.get(1).get("username"), Keys.TAB, data.get(1).get("password"));
	}

@Given("click on the login button")
public void click_on_the_login_button() {
	driver.findElement(By.xpath("//button[text()= ' Login ' ] ")).click();
}
	
}
