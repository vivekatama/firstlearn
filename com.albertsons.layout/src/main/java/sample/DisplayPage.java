package sample;

import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DisplayPage {
	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://swift.ngage.services/display/view");
		driver.findElement(By.xpath("//input[@placeholder='User']")).sendKeys("swiftadmin_TEST");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Test@2024");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[text()='Displays'])[2]")).click();
		driver.findElement(By.xpath("//button[@id=\"folder-tree-select-folder-button\"]")).click();
		Thread.sleep(1000);
		FileInputStream fis =new FileInputStream("C:\\selenium\\Book3.xlsx");
		Workbook book =WorkbookFactory.create(fis);
		Sheet sh=book.getSheet("Sheet1");
		DataFormatter df = new DataFormatter();
		
		
		for(int i=0; i<=sh.getLastRowNum(); i++) {
			Row r=sh.getRow(i);
			for(int j=0; j<=r.getLastCellNum()-1;j++) {
				String value = df.formatCellValue(r.getCell(j));
				System.out.println(value);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@id='display']")).clear();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@id=\"display\"]")).sendKeys(value);
				Thread.sleep(2000);
				Actions act = new Actions(driver);
			WebElement dropdown=	driver.findElement(By.xpath("//div[@title='Row Menu']"));
			act.moveToElement(dropdown).perform();	
			Thread.sleep(2000);
			WebElement element=	driver.findElement(By.xpath("(//button[@data-toggle=\"dropdown\"])[1]"));
				
				act.click(element).perform();
				//driver.findElement(By.xpath("(//div[@class='row'])[4]//div//div//button[@data-toggle='dropdown']")).click();
				Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@x-placement='top-end']//a[2]")).click();
		//	act.click(edit).perform();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//b[@role='presentation'])[1]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//span[@class=\"select2-results\"]//ul/li[4]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//button[text()='Save']")).click();
			}
		}
		
		
		book.close();
		fis.close();
		driver.quit();
		
		
		
	}
}
