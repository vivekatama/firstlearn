package Section1;

import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Assignment {
	public static void main(String[] args) throws Exception {
		//System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver-win64");
		//step 1: to launch chrome browser
				ChromeDriver driver=new ChromeDriver();
				//EdgeDriver driver1 = new EdgeDriver();
				driver.manage().window().maximize();
				Thread.sleep(3000);
				driver.manage().window().minimize();
				Thread.sleep(3000);
				driver.manage().window().maximize();
				Thread.sleep(3000);
				//step 3: launch two web applications 
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
				// fetch url
				String url = driver.getCurrentUrl();
				System.out.println(url);
				driver.close();


}
}
