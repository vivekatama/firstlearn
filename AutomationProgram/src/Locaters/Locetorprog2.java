package Locaters;

import org.openqa.selenium.chrome.ChromeDriver;

public class Locetorprog2 {
	public static void main(String[] args) throws Exception {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.get("https://www.flipkart.com/account/login?ret=/");
		Thread.sleep(2000);
		
	}
}
