package Section2;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadPopup {
	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/ui?scenario=1");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//section[text()='Popups']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//section[text()='File Uploads']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Custom Button']")).click();
		Thread.sleep(3000);
		//WebElement Element = driver.findElement(By.xpath("//input[@type='file']"));
		WebElement element = driver.findElement(By.xpath("//div[text()='Upload File']"));
		element.click();
		Thread.sleep(3000);
		Robot r = new Robot();
		StringSelection path = new StringSelection("C:\\selenium\\Sudha_Nellepalli_Resume.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(path, null);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		//driver.findElement(By.xpath("(//*[local-name()='svg'])[1]")).click();
		// fetch url
//		String url = driver.getCurrentUrl();
//		System.out.println(url);
//		String title = driver.getTitle();
//		System.out.println(title);


//		driver.quit();

	}
}
