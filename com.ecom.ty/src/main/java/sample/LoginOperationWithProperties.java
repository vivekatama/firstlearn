package sample;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import GenericLibraryOrUtility.PropertiesUtility;

public class LoginOperationWithProperties {
	public static void main(String[] args) throws Exception {
		PropertiesUtility PUTIL = new PropertiesUtility();
		String URL = PUTIL.getDataFromProperties("url");
		String USERNAME = PUTIL.getDataFromProperties("username");
		String PASSWORD = PUTIL.getDataFromProperties("password");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get(URL);
		
		driver.findElement(By.xpath("//input[@placeholder='Username']"))
		.sendKeys(USERNAME, Keys.TAB, PASSWORD, Keys.ENTER);
		//driver.close();
	}
}
