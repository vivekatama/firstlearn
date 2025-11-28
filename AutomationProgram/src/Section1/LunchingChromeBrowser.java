package Section1;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LunchingChromeBrowser {

	public static void main(String[] args) {
		//step 1: provide key and path of chromeDriver(optional)
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver-win64");
		//step 2: to launch chrome browser
		ChromeDriver driver=new ChromeDriver();
		EdgeDriver driver1 = new EdgeDriver();
		//step 3: to access to a web application 
		driver.get("https://www.facebook.com/");
		driver1.get("https://www.flipkart.com/");
	}
}
