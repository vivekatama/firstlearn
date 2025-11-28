package Section2;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// DropDownHandlingNormalApproach
public class Scenarios30 {
public static void main(String[] args) throws Exception {
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	WebElement element = driver.findElement(By.xpath("//input[@name='username']"));
	element.sendKeys("Admin", Keys.TAB, "admin123", Keys.ENTER);
	driver.findElement(By.xpath("//span[text()='Leave']")).click();
	driver.findElement(By.xpath("(//div[text()='-- Select --'])[1]")).click();
	Thread.sleep(3000);
//List<WebElement> elements	=driver.findElements(By.xpath("//div[@class='oxd-select-option']"));
//	Iterator<WebElement> itr = elements.iterator();
//	Thread.sleep(3000);
//	while(itr.hasNext())
//	{
//		String allOptions = itr.next().getText();
//		System.out.println(allOptions);
//	}
	List<WebElement> elements1	=driver.findElements(By.xpath("//div[@role='listbox']"));
	Iterator<WebElement> itr2 = elements1.iterator();
	Thread.sleep(3000);
	while(itr2.hasNext())
	{
		String allOptions = itr2.next().getText();
		System.out.println(allOptions);
	}
	
	driver.findElement(By.xpath("//span[text()='CAN - FMLA']")).click();
	
//driver.close();

}
}
