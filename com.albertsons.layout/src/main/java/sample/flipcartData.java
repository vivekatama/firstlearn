package sample;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class flipcartData {
	public static void main(String[] args) throws Exception {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(3000);


		ArrayList<String> nameMenu = new ArrayList<>();

		FileInputStream fis = new FileInputStream("C:\\selenium\\data.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		Sheet sh = book.getSheet("Sheet1");
		DataFormatter df = new DataFormatter();

		for (int i = 1; i <= sh.getLastRowNum(); i++) {
			Row r = sh.getRow(i);
			for (int j =0; j <= r.getLastCellNum()-1; j++) {
				String s = df.formatCellValue(r.getCell(j));
				nameMenu.add(s);
			}
		}

		//	WebElement search = driver.findElement(By.xpath("//input[@name='q']"));
		//	search.sendKeys("nameMenu");
		//	search.submit();
		//	Thread.sleep(2000);

		//FileOutputStream fos = new FileOutputStream("C:\\selenium\\data.xlsx");
		for(int i=1;i<nameMenu.size();i++)
		{
			driver.findElement(By.xpath("//input[@name='q']")).clear();
			WebElement search=driver.findElement(By.xpath("//input[@name='q']"));
			search.sendKeys(nameMenu.get(i));
			search.submit();
			Thread.sleep(3000);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class=\\\"yKfJKb row\\\"]//div//div/ul)[1]")));

			WebElement element=driver.findElement(By.xpath("(//div[@class=\\\"yKfJKb row\\\"]//div//div/ul)[1]"));

			String value=element.getText();
			System.out.println(value);

			
			
			sh.createRow(i+1).createCell(i+2).setCellValue(value);
			FileOutputStream fos = new FileOutputStream
					("C:\\\\selenium\\\\data.xlsx");
			book.write(fos);

			
//			Row row = sh.getRow(i + 1);
//			if (row == null) row = sh.createRow(i + 1);
//			Cell cell = row.createCell(i+2);
//			cell.setCellValue(value);
//			book.write(fos);
			//fos.flush();
		}
		driver.close();
	}


}

