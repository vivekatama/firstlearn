package Section1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {
	public static void main(String[] args) throws Exception {
		String expected = "login"; 
		// Step 1:	launch the chrome browser
		ChromeDriver driver = new ChromeDriver();
		// Step 2:	maximize the window
		driver.manage().window().maximize();
		// Step 3:	Access the orangeHRM.com
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebElement username = driver.findElement(By.cssSelector("input[placeholder=\"Username\"]"));
		username.sendKeys("Admin");
		Thread.sleep(2000);
		WebElement password = driver.findElement(By.cssSelector("input[placeholder=\"Password\"]"));
		password.sendKeys("admin123");
		WebElement login = driver.findElement(By.cssSelector("button[type='submit']"));
		login.click();

		Thread.sleep(2000);

	}
}
