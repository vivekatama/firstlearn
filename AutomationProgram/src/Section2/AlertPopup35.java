package Section2;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertPopup35 {
	public static void main(String[] args) throws Exception {
		Alert alt = null;
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/ui?scenario=1");
		
		driver.findElement(By.xpath("//section[text()='Popups']")).click();
		driver.findElement(By.xpath("//section[text()='Javascript']")).click();
		driver.findElement(By.xpath("//button[text()='Alert Box']")).click();
		
		alt = driver.switchTo().alert();
		// for default alert 
		String altmsg = alt.getText();
		System.out.println(altmsg);
		Thread.sleep(2000);
		alt.accept();
		/*for confirm alert*/
		driver.findElement(By.xpath("//a[text()='Confirm']")).click();
		driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
		alt = driver.switchTo().alert();
		Thread.sleep(2000);
		System.out.println(alt.getText());
		alt.dismiss();
		
	}
}
