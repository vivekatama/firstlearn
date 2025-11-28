package stepDefinationFile;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;

public class HomeStepDefination {
static WebDriver driver = null;
@Given("Launch the given bowser with the given URL and maximize the window")
public void launch_the_given_bowser_with_the_given_url_and_maximize_the_window() {
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

}

}
