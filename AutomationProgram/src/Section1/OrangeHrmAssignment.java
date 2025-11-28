package Section1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHrmAssignment {
public static void main(String[] args) throws Exception {
	String expectedValue = "login"; 
	// Step 1:	launch the chrome browser
	ChromeDriver driver = new ChromeDriver();
	// Step 2:	maximize the window
	driver.manage().window().maximize();
	// Step 3:	Access the orangeHRM.com
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	driver.manage().window().maximize();
	Thread.sleep(2000);
	String actualValue = driver.findElement(By.xpath("//h5[text()='Login']")).getText();
	if(actualValue.contains(expectedValue)) {
		System.out.println("Validation pass!!");
	}
	else {
		System.out.println("Validaton fail!!");
	}
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
	Thread.sleep(2000);
	driver.findElement(By.xpath("button[@type='submit']")).click();
	Thread.sleep(2000);
	String expectedDashboard = "Dashboard";
	String actualValueDashboard=driver.findElement(By.xpath("//h6[text()='Dashboard']")).getText();
	if(actualValueDashboard.contains(expectedDashboard)) {
		System.out.println("Dashboard page verified");
	}
	else
	{
		System.out.println("Dashboard page not verified");
	}
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[text()='Admin']")).click();
	Thread.sleep(2000);
	String expectedAdmin = "Admin";
	String actualValueAdmin=driver.findElement(By.xpath("//h6[text()='Admin']")).getText();
	Thread.sleep(2000);
	if(actualValueAdmin.contains(expectedAdmin)) {
		System.out.println("Admin page verified");
	}
	else
	{
		System.out.println("Admin page verified");	
	}
	Thread.sleep(2000);
	driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[text()='Logout']")).click();
	Thread.sleep(2000);
	driver.close();
}
}
