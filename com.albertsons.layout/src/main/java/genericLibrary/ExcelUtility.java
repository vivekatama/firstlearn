package genericLibrary;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExcelUtility {
	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://swift.ngage.services/display/view");
		driver.findElement(By.xpath("//input[@placeholder='User']")).sendKeys("swiftadmin_TEST");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Test@2024");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("(//a[text()='Displays'])[2]")).click();
				
		
		
		FileInputStream fis = new FileInputStream
				("C:\\selenium\\book.xlsx");
		
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet("Sheet1");
		WebElement DefaltLayout=driver.findElement(By.xpath("//tbody/tr[1]/td[3]"));
		String value1=DefaltLayout.getText();
		System.out.println(value1);
		Thread.sleep(3000);
		WebElement DefaltLayout1=driver.findElement(By.xpath("//tbody/tr[2]/td[3]"));
		String value2=DefaltLayout1.getText();
		System.out.println(value2);
		Thread.sleep(3000);
		WebElement DefaltLayout3=driver.findElement(By.xpath("//tbody/tr[3]/td[3]"));
		String value3=DefaltLayout3.getText();
		System.out.println(value3);
		
		sh.createRow(1).createCell(2).setCellValue(value1);
		sh.createRow(2).createCell(2).setCellValue(value2);
		sh.createRow(3).createCell(2).setCellValue(value3);
		
		FileOutputStream fos = new FileOutputStream
				("C:\\selenium\\book.xlsx");
		book.write(fos);
		fos.flush();
		driver.close();
	}

}
