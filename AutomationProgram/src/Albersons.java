import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.time.Duration;
import java.util.ArrayList;

public class Albersons {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
			driver.get("https://swift.ngage.services/display/view");
			driver.findElement(By.xpath("//input[@placeholder='User']")).sendKeys("swiftadmin_TEST");
			driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Test@2024");
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			driver.findElement(By.xpath("(//a[text()='Displays'])[2]")).click();
			driver.findElement(By.xpath("//button[@class='btn btn-outline-secondary']")).click();

			ArrayList<String> nameMenu = new ArrayList<>();

			try (FileInputStream fis = new FileInputStream("C:\\selenium\\book2.xlsx");
					Workbook book = WorkbookFactory.create(fis)) {

				Sheet sh = book.getSheet("Sheet8");
				DataFormatter df = new DataFormatter();

				for (int i = 1; i <= sh.getLastRowNum(); i++) {
					Row r = sh.getRow(i);
					for (int j = 1; j <= r.getLastCellNum()-1; j++) {
						String s = df.formatCellValue(r.getCell(j));
						nameMenu.add(s);
					}
				}

				try (FileOutputStream fos = new FileOutputStream("C:\\selenium\\book2.xlsx")) {
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

					for (int i = 0; i < nameMenu.size(); i++) {
						WebElement displayInput = driver.findElement(By.xpath("//input[@id='display']"));
						displayInput.clear();
						displayInput.sendKeys(nameMenu.get(i));

						// Use WebDriverWait instead of Thread.sleep
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[@class='table-success odd']/td[3]")));

						WebElement defaultLayout = driver.findElement(By.xpath("//tr[@class='table-success odd']/td[3]"));
						String value = defaultLayout.getText();
						System.out.println(value);

						Row row = sh.getRow(i + 1);
						if (row == null) row = sh.createRow(i + 1);
						Cell cell = row.createCell(i);
						cell.setCellValue(value);

						book.write(fos);
						fos.flush();
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//driver.quit();
		}
	}
}
