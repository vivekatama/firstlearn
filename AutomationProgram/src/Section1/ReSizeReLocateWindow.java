package Section1;

import java.awt.Dimension;

import org.openqa.selenium.chrome.ChromeDriver;

public class ReSizeReLocateWindow {
	public static void main(String[] args) {
		// Step 1:	Create a instance of ChromeDriver 
		ChromeDriver driver = new ChromeDriver();
		// Step 2:	Access Flipkart 
		driver.get("https://www.flipkart.com/");
		// Step 3:	Maximize the window 
		driver.manage().window().maximize();
		// Step 4:	Resize the window
		//driver.manage().window().setSize(org.openqa)
	}
}
