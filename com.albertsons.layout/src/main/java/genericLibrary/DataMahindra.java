
package genericLibrary;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DataMahindra {
	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://mahindracms.com/web/login");
		driver.findElement(By.xpath("//input[@placeholder=\"User\"]")).sendKeys(" ");
		driver.findElement(By.xpath("//input[@placeholder=\"Password\"]")).sendKeys("");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("(//div[@class=\"m_title_icon\"])[5]")).click();
		driver.findElement(By.xpath("//a[text()='Displays']")).click();
		

		ArrayList<String> nameMenu=new ArrayList<String>();
		
		String path = "C:\\selenium\\book7.xlsx";
		XLUtility xlutil=new XLUtility(path);
		
	
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		int totalrows=xlutil.getRowCount("sheet2");
		int totalcols=xlutil.getCellCount("sheet2", 1);

		

		for(int i=1; i<=totalrows;i++) {

			for(int j=0; j<totalcols;j++) {
				String insertData=xlutil.getCellData("sheet2", i, j);
				System.out.println(insertData);
				
				nameMenu.add(insertData);
			}
		}
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//input[@id='display']")).clear();
//		WebElement table =driver.findElement(By.xpath("(//div[@class='row'])[4]//tbody"));
//		int rows =table.findElements(By.xpath("tr")).size();

		for(int r=1; r<=nameMenu.size(); r++) 
		{
			// read data from web table 

			driver.findElement(By.xpath("//input[@id='display']")).clear();
			driver.findElement(By.xpath("//input[@id=\"display\"]")).sendKeys(nameMenu.get(r));
		//	Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@class=\"btn dropdown-toggle\"]")).click();
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("\"//button[@class=\\\"btn dropdown-toggle\\\"]")));
		//	Thread.sleep(2000);
			driver.findElement(By.xpath("//a[text()='Version Information']")).click();
		//	Thread.sleep(2000);
			driver.findElement(By.xpath("//select[@id='mediaId']")).click();
		//	Thread.sleep(2000);
			driver.findElement(By.xpath("//option[text()='com.lg.app.signage (4).ipk']")).click();
			//Thread.sleep(2000);
			driver.findElement(By.xpath("//button[text()='Save']")).click();
			Thread.sleep(3000);
		
			//String Layout=table.findElement(By.xpath("tr["+r+"]/td[3]")).getText();
		//	System.out.println(Layout);
			// write the data in excel sheet
			

			xlutil.setCellData("Sheet2", r, 2, "Done");

		}
		System.out.println("web scrapping is done succesfully......");
		driver.close();
		driver.quit();

	}

}
