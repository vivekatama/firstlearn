package Locaters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssSelector {
public static void main(String[] args) throws Exception {
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://demoapps.qspiders.com/ui?scenario=1");
	Thread.sleep(2000);
	driver.findElement(By.cssSelector("input[placeholder='Enter your name']")).sendKeys("Vivek");
	Thread.sleep(2000);
	driver.findElement(By.cssSelector("input[placeholder='Enter Your Email']")).sendKeys("Vivekatama@gmail.com");
	Thread.sleep(2000);
	driver.findElement(By.cssSelector("input[type='password']")).sendKeys("Vivekatama@123");
	Thread.sleep(2000);
WebElement register = driver.findElement(By.cssSelector("button[type='submit']"));
register.click();
}
}
