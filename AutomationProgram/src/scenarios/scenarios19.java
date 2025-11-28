package scenarios;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class scenarios19 {
	public static void main(String[] args) throws Exception {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.get("https://www.flipkart.com/");
		Thread.sleep(2000);
		WebElement search = driver.findElement(By.xpath("//input[@name='q']"));
		search.sendKeys("iphone 11");
		search.submit();
		Thread.sleep(2000);
		String expectedValue="Showing";
		WebElement SearchResult =  driver.findElement(By.xpath("//span[contains(text(),'Showing')]"));
		String actualValue= SearchResult.getText();
		System.out.println(actualValue);
		if(actualValue.contains(expectedValue)) {
			System.out.println("PLP verified");
		}
		else {
			System.out.println("PLP validation fails");
		}
		Thread.sleep(2000);
		List<WebElement> pname = driver.findElements
				(By.xpath("//div[contains(@class,'KzDlHZ')]"));
		Thread.sleep(2000);
		List<WebElement> pprice = driver.findElements(By.xpath("//div[contains(@class,'KzDlHZ')]/../following-sibling::div/div[contains(@class,'cN')]/div[contains(@class,'hl')]/div[contains(@class,'Nx')]"));



//		for(int i=0; i<=pname.size()-1;i++)
//		{
//			System.out.println(pname.get(i).getText()+"----"+pprice.get(i).getText());
//		}
		Iterator<WebElement> itr1 = pname.iterator();
		Iterator<WebElement> itr2= pprice.iterator();
		Thread.sleep(2000);
		while(itr1.hasNext()&& itr2.hasNext())
		{
			String allnames = itr1.next().getText();
			String allprices = itr2.next().getText();
			System.out.println(allnames+"---"+allprices);
		}
	}
	
	
}
