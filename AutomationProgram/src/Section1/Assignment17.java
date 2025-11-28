package Section1;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment17 {
	public static void main(String[] args) throws Exception {
		Random r = new Random();
		int number = r.nextInt(1000);
		String mail = "vivekatama"+number+"@gamil.com";
		String password = "welcome";
		ChromeDriver driver = new ChromeDriver();
		Thread.sleep(2000);
		driver.get("https://demoapps.qspiders.com/ui?scenario=1");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		// Step 3:	perform the registration expression with the help of XPath
			driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Vivek Kumar Singh");
			Thread.sleep(2000);
		WebElement email =	driver.findElement(By.xpath("//input[@id='email']"));
		email.sendKeys(mail);
			Thread.sleep(2000);
			
		WebElement pass = driver.findElement(By.xpath("//input[@id='password']"));
				pass.sendKeys("VivekAtama@123");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[.='Register']")).click();
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//section[.='Text Box']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[.='Login Now']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys(mail);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[.='Login']")).click();
			Thread.sleep(3000);
			boolean signinverify = 
					driver.findElement(By.xpath("//div[.='Signin successfull']")).isDisplayed();
			System.out.println("signin in verify is : "+ signinverify);
			
					
					
	}
	

	
}
