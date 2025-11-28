package Section2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scenarios23 {
	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver ();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath("//input[@name='username']"));
		element.sendKeys("Admin", Keys.TAB, "admin123",Keys.ENTER );
	}
}
