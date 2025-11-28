package Section1;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment16 {
	public static void main(String[] args) throws Exception {
		ChromeDriver driver=new ChromeDriver();
		Thread.sleep(2000);
		driver.get("https://www.flipkart.com/");
		Thread.sleep(2000);
		WebElement search = driver.findElement(By.xpath("//input[@name='q']"));
		search.sendKeys("iphone 11");
		search.submit();
		Thread.sleep(2000);
		List<WebElement> products = driver.findElements(By.xpath("//div[@class='KzDIHZ']"));
		Thread.sleep(3000);
		Iterator<WebElement> itr = products.iterator();
		Thread.sleep(3000);
		while(itr.hasNext()) {
			String allNames = itr.next().getText();
			System.out.println(allNames);
		}
		/*
		 * for(WebEelement names : products)
		 * {
		 * String allNames = names.getText();
			System.out.println(allNames);
		 */
		driver.quit();


	}
}
