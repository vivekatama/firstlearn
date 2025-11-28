package genericLibrary;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReWriteToExcel {
	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://swift.ngage.services/display/view");
		driver.findElement(By.xpath("//input[@placeholder='User']")).sendKeys("swiftadmin_TEST");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Test@2024");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("(//a[text()='Displays'])[2]")).click();

		ArrayList<String> nameMenu=new ArrayList<String>();
		
		String path = "C:\\selenium\\book2.xlsx";
		XLUtility xlutil=new XLUtility(path);
		
	
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		int totalrows=xlutil.getRowCount("sheet8");
//		System.out.println(totalrows);

		

		for(int i=1; i<=totalrows;i++) {

			int totalcols=xlutil.getCellCount("sheet8", i);
//			System.out.println(totalcols);
			for(int j=1; j<totalcols;j++) {
				String insertData=xlutil.getCellData("sheet8", i, j);
				System.out.println(insertData);
				
				nameMenu.add(insertData);
			}
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='display']")).clear();
		WebElement table =driver.findElement(By.xpath("(//div[@class='row'])[4]//tbody"));
		int rows =table.findElements(By.xpath("tr")).size();

		for(int r=1; r<=nameMenu.size(); r++) 
		{
			// read data from web table 

			driver.findElement(By.xpath("//input[@id='display']")).clear();
			driver.findElement(By.xpath("//input[@id=\"display\"]")).sendKeys(nameMenu.get(r));
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr/td[3]")));
			String Layout=table.findElement(By.xpath("tr["+r+1+"]/td[3]")).getText();
			System.out.println(Layout);
			// write the data in excel sheet

			xlutil.setCellData("Sheet8", r+1, 2, Layout);

		}
		System.out.println("web scrapping is done succesfully......");
		//driver.close();
		//driver.quit();

	}

}
