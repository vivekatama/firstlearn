package Section1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebElement;

//scenarios no 11
//1. launch Chrome browser
// access Flipkart 
// search for iphone 11
// verify iphone 11 plp page is displayed
// click on apple iphone11 white 64Gb
// close both the windows 
//note- in between all the operation provide 2seconds time interval 
public class Assignment3 {
public static void main(String[] args) throws Exception {
	String expectedValue="search";
	// Step 1: Launch Chrome browser
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	Thread.sleep(2000);
	// Step 2:	Access Flipkart 
	Thread.sleep(2000);
	driver.get("https://www.flipkart.com/");
	// Step 3:	verify iphone 11 plp page is displayed
	Thread.sleep(2000);
	WebElement search = driver.findElement(By.xpath("//input[@name='q']"));
	search.sendKeys("iphone 11");
	search.submit();
	Thread.sleep(2000);
	String actualValue = driver.getCurrentUrl();
	
	if(actualValue.contains(expectedValue))
	{
		System.out.println("validation successfull!!");
	}
	else
	{
		System.out.println("validation fails!!");
	}
	Thread.sleep(2000);
	// Step click on apple iphone11 white 64Gb
	WebElement element = driver.findElement(By.xpath("//div[text()='Apple iPhone 11 (White, 64 GB) (Includes EarPods, Power Adapter)']"));
	element.click();
	Thread.sleep(5000);
	driver.quit();
	//driver.close();	

}
}
