package genericLibrary;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableToXL {
	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://swift.ngage.services/display/view");
		driver.findElement(By.xpath("//input[@placeholder='User']")).sendKeys("swiftadmin_TEST");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Test@2024");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("(//a[text()='Displays'])[2]")).click();
		
		//ArrayList<String> nameMenu=new ArrayList<String>();
		//public String [][] getData()throws IOException{	
		String path = "C:\\selenium\\book2.xlsx";
		XLUtility xlutil=new XLUtility(path);
		
		
		
	
		WebElement table =driver.findElement(By.xpath("(//div[@class='row'])[4]//tbody"));
		int rows =table.findElements(By.xpath("tr")).size();
		
		for(int r=1; r<=rows; r++) 
		{
			// read data from webtable 
			Thread.sleep(3000);
			String Layout=table.findElement(By.xpath("tr["+r+"]/td[3]")).getText();
			System.out.println(Layout);
			// write the data in excel sheet
			
			xlutil.setCellData("Sheet3", r, 2, Layout);
			
		}
		System.out.println("web scrapping is done succesfully......");
		driver.close();
		
	}
	
}
