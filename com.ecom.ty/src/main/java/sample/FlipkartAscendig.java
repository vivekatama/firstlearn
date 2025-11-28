package sample;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FlipkartAscendig {
	public static void main(String[] args) throws Exception {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(3000);
		WebElement electronic = driver.findElement(By.xpath("//span[text()='Electronics']"));
		Thread.sleep(3000);
		Actions act = new Actions(driver);
		act.moveToElement(electronic).perform();
		List<WebElement> a = driver.findElements(By.xpath("//a[@class='_3490ry']"));
		
		
		//List<WebElement> element = driver.findElements(By.xpath("//span[@class='_3Pzn-c']"));
		ArrayList<String> a1 = new ArrayList<String>();
		Iterator<WebElement> itr = a.iterator();
		Thread.sleep(3000);
		while(itr.hasNext()) 
		{
			String s = itr.next().getText();
			a1.add(s);
			//System.out.println(s);
		}
		Collections.sort(a1);
		
		System.out.println(a1);
		
		
		//driver.close();
	}
}
