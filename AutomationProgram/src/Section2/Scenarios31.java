package Section2;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// drop down handling with keys class and robot class
public class Scenarios31 {
	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		WebElement element = driver.findElement(By.xpath("//input[@name='username']"));
		element.sendKeys("Admin", Keys.TAB, "admin123", Keys.ENTER);
		driver.findElement(By.xpath("//span[text()='Leave']")).click();
	WebElement element1 =	driver.findElement(By.xpath("(//div[text()='-- Select --'])[1]"));
		element1.click();
		Thread.sleep(3000);
		// with keys class
		element1.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
		// with robot class 
		Robot r = new Robot ();
		for(int i=1; i<7; i++) {
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		}
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
	}
}
