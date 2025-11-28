package Section2;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowPopupHandling36 {
	public static void main(String[] args) throws Exception {
		// Step :1	Launch chrome browser
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		// Step :2	access flipkart 
		driver.get("https://www.flipkart.com/");
		Thread.sleep(2000);
		// step :3	search for any product
		WebElement search = driver.findElement(By.xpath("//input[@name='q']"));
		search.sendKeys("iphone 11");
		search.submit();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='KzDlHZ']")).click();

		String parentId = driver.getWindowHandle();
		Set<String> allIds = driver.getWindowHandles();

		for(String ids : allIds) {
			if(!parentId.equals(ids)) {
				driver.switchTo().window(ids);
			}
		}

		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(@class,'QqFHMw vslbG+ I')]")).click();
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath("//a[text()='Apple iPhone 11 (White, 64 GB) (Includes EarPods, Power Adapter)']"));
		System.out.println(element.getText());
		//driver.quit();
	}
}
