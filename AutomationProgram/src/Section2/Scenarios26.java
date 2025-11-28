package Section2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenarios26 {
public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	driver.get("https://demoapps.qspiders.com/ui?scenario=1");
	driver.findElement(By.xpath("//section[text()='Mouse Actions']")).click();
	driver.findElement(By.xpath("//section[text()='Drag & Drop']")).click();
	Actions act = new Actions(driver);
	WebElement element =driver.findElement(By.xpath("//a[text()='Drag Position']"));
	act.click(element).perform();
	WebElement mobAccessories = driver.findElement(By.xpath(""));
	
	
}
}
