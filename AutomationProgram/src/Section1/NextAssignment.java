package Section1;

import javax.naming.directory.SearchResult;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// senarios no 12
// launch chrome browser 
// access flipkart 
// search for any product 
// fetch the result from PLP page and validate the result
// close the window
public class NextAssignment {
public static void main(String[] args) throws Exception {
	String expectedValue="Showing";
	// Step 1:	launch chrome browser
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	Thread.sleep(2000);
	// Step 2:
	driver.get("https://www.flipkart.com/");
	Thread.sleep(2000);
	// Step 3:	Search for any product 
	WebElement search = driver.findElement(By.xpath("//input[@name='q']"));
	search.sendKeys("mi tv");
	search.submit();
	Thread.sleep(2000);
	// Step 4:
	WebElement SearchResult =  driver.findElement(By.xpath("//span[contains(text(),'Showing')]"));
	String actualValue= SearchResult.getText();
	System.out.println(actualValue);
	if(actualValue.contains(expectedValue)) {
		System.out.println("Validation pass");
	}
	else {
		System.out.println("validation fails");
	}
	// Step 5:	close the window 
	driver.quit();
}
}
