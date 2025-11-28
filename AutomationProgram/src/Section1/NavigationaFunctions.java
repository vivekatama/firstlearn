package Section1;

import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationaFunctions {
	public static void main(String[] args) throws Exception {
		// step 1:- launch the browser 
		ChromeDriver driver=new ChromeDriver();
		// step 2:- Access web app
		
		Navigation nav = driver.navigate();
		nav.to("https://www.flipkart.com/");
		Thread.sleep(3000);
		nav.to("https://facebook.com/");
		Thread.sleep(3000);
		nav.back();
		Thread.sleep(3000);
		nav.forward();
		Thread.sleep(3000);
		nav.refresh();
		
//		driver.navigate().to("https://www.flipkart.com/");
//		driver.navigate().to("https://www.facebook.com/");
//		driver.navigate().back();
//		driver.navigate().forward();
//		driver.navigate().refresh();
	}
}
