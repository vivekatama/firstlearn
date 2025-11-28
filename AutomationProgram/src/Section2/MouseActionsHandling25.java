package Section2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseActionsHandling25 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		WebElement element = driver.findElement(By.xpath("//span[text()='Fashion']"));
		Thread.sleep(3000);
		WebElement element2 = driver.findElement(By.xpath("//span[text()='Mobiles']"));
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		Thread.sleep(3000);
		act.moveToElement(element2).perform();
		
	}

}
