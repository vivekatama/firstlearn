package Section2.ScreenShotFolder;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class TakeSS {
public static void main(String[] args) throws Exception {
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	driver.get("https://www.flipkart.com/");
	
WebElement search=	driver.findElement(By.xpath("//input [@name='']"));
	search.sendKeys("i Phone 11 ");
	search.submit();
	
	TakesScreenshot ts = (TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File dest = new File(".\\SSFolder\\"+"abs.png");
	Files.copy(src, dest);
	
}
}
