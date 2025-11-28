package Section2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenarios29 {
	public static void main(String[] args) throws Exception {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		WebElement search = driver.findElement(By.xpath("//input[@name='q']"));
		search.sendKeys("iphone 11");
		search.submit();
		Actions act = new Actions(driver);
		Thread.sleep(3000);
		WebElement product = driver.findElement(By.xpath("//div[text()='Apple iPhone 11 (Black, 128 GB)']"));
		act.scrollToElement(product).perform();
	}
}
