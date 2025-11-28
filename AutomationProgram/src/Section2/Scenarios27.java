package Section2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenarios27 {
public static void main(String[] args) throws Exception {
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	driver.get("https://demoapps.qspiders.com/ui?scenario=1");
	driver.findElement(By.xpath("//section[text()='Mouse Actions']")).click();
	Actions act = new Actions(driver);
	driver.findElement(By.xpath("//section[text()='Click & Hold']")).click();
	WebElement clickAndHold = driver.findElement(By.xpath("//div[@id='circle']"));
	act.clickAndHold(clickAndHold).perform();
	Thread.sleep(2000);
	act.release(clickAndHold).perform();
}
}
