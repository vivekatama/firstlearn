package Section2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DateAndTimePicker {
	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/ui?scenario=1");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//section[text()='Date & Time Picker']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//section[text()='Date Picker']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Dropdown DatePicker']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//*[local-name()='svg'])[1]")).click();
		driver.findElement(By.xpath("//span[@class='react-datepicker__month-read-view--down-arrow']")).click();
		
	}
}
