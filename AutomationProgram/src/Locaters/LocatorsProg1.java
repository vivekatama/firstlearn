package Locaters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsProg1 {
	public static void main(String[] args) throws Exception {
		// Step:1	Launch Chrome browser 
		ChromeDriver driver = new ChromeDriver();
		// Step:2	maximize the window 
		driver.manage().window().maximize();
		Thread.sleep(2000);
		// Step:3	Access demoapps.qspider.com
		driver.get("https://demoapps.qspiders.com/ui?scenario=1");
		Thread.sleep(2000);
		// Step:4	provide name, email, password in the text box
		driver.findElement(By.id("name")).sendKeys("Vivekatama");
		Thread.sleep(2000);
		driver.findElement(By.id("email")).sendKeys("vivekatama@gmail.com");
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.id("password"));
		element.sendKeys("Bsdk@123");
		Thread.sleep(2000);
		// Step:5	click on register 
		element.submit();
		Thread.sleep(2000);
		// Step:6	close the browser 
		driver.close();
	}
}
