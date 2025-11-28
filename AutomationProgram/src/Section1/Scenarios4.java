package Section1;

import java.sql.Driver;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scenarios4 {
	public static void main(String[] args) throws Exception {
		//	Step 1:	Launch Chrome Browser
		ChromeDriver driver = new ChromeDriver();
		Thread.sleep(3000);
		//	Step 2:	Access Flipkart
		driver.get("https://www.flipkart.com/");
		Thread.sleep(3000);
		//	Step 3:	Maximize the window
		driver.manage().window().maximize();
		Thread.sleep(3000);
		//	Step 4:	resize the window
		driver.manage().window().setSize(new Dimension(100,200));
		Thread.sleep(3000);
		//	Step 5:	relocate the window
		driver.manage().window().setPosition(new Point(200, 300));
		Thread.sleep(3000);
		//	Step 6: close the window
		driver.close();
		
	}
	
}
