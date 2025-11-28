package Locaters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scenarios8 {
	public static void main(String[] args) throws Exception {
		ChromeDriver driver = new ChromeDriver();
		Thread.sleep(2000);
		driver.manage().window().maximize();

		driver.get("https://www.flipkart.com/");
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.className("//input[@class='Pke_EE']"));
		element.sendKeys("iphone 11 ");
		//Thread.sleep(2000);
		element.submit();
		//Thread.sleep(2000);
		String plpURL = driver.getCurrentUrl();
		System.out.println(plpURL);
		driver.close();
	}
}
