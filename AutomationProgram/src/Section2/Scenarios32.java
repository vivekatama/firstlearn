package Section2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;

public class Scenarios32 {
public static void main(String[] args) throws Exception {
	Select s = null;
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	driver.get("https://demoapps.qspiders.com/ui?scenario=1");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//section[text()='Dropdown']")).click();
	Thread.sleep(3000);
	WebElement phone = driver.findElement(By.xpath("//select[@id='select1']"));
	s = new Select(phone);
	s.selectByIndex(3);
	
	Thread.sleep(3000);
	WebElement gender = driver.findElement(By.xpath("//select[@id='select2']"));
	s = new Select(gender);
	s.selectByValue("male");
	
	Thread.sleep(2000);
	WebElement countrycd = driver.findElement(By.xpath("//select[@id='select3']"));
	Thread.sleep(2000);
	s = new Select(countrycd);
	s.selectByVisibleText("Germany");
	
}
}
