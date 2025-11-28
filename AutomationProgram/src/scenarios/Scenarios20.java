package scenarios;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scenarios20 {
public static void main(String[] args) throws Exception {
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.flipkart.com/");
	Thread.sleep(3000);
	WebElement search = driver.findElement(By.xpath("//input[@name='q']"));
	search.sendKeys("iphone 11");
	search.submit();
	Thread.sleep(2000);

	String expectedPlpVerification ="Showing";
	WebElement SearchResult =  driver.findElement(By.xpath("//span[contains(text(),'Showing')]"));
	String actualPlpVerification= SearchResult.getText();
	System.out.println(actualPlpVerification);
	if(actualPlpVerification.contains(expectedPlpVerification)) {
		System.out.println("PLP verified");
	}
	else {
		System.out.println("PLP validation fails");
	}
	Thread.sleep(2000);
//	driver.findElement(By.xpath("//label[@class='uu79Xy'][1]")).click();
//	driver.findElement(By.xpath("//label[@class='uu79Xy'][5]")).click();
//	driver.findElement(By.xpath("//label[@class='uu79Xy'][11]")).click();
//	driver.findElement(By.xpath("//label[@class='uu79Xy'][24]")).click();
	List<WebElement> elements = driver.findElements(By.xpath("//span[text()='Add to Compare']"));
	for(int i = 0; i<=elements.size()-1;i++)
	{
		if(i==0 || i==4 || i==elements.size()-1 || i==22) {
			elements.get(i).click();
		}
	}
	String expectedValue ="you have already selected 4 products";
	Thread.sleep(2000);
	String actualValue = driver.findElement(By.xpath("//div[.='you have already selected 4 products']")).getText();
	Thread.sleep(2000);
	if(actualValue.contains(expectedValue)) {
		System.out.println("pass!!");
	}
	else {
		System.out.println("Fail!!");
	}
}
}
