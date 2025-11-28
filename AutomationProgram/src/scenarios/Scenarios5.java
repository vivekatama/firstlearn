package scenarios;

import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scenarios5 {
	public static void main(String[] args) throws Exception {
		ChromeDriver driver = new ChromeDriver();
		Navigation nav = driver.navigate();
//		nav.to("https://www.flipkart.com/");
//		Thread.sleep(3000);
//		nav.to("https://demoapps.qspiders.com/ui?scenario=1");
//		Thread.sleep(3000);
//		nav.back();
//		Thread.sleep(3000);
//		nav.forward();
//		Thread.sleep(3000);
//		nav.refresh();
//		driver.close();
		driver.navigate().to("https://www.flipkart.com/");
		Thread.sleep(3000);
		driver.navigate().to("https://demoapps.qspiders.com/ui?scenario=1");
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000);
		driver.navigate().forward();
		Thread.sleep(3000);
		driver.navigate().refresh();
		driver.close();
	}
}
