package GenericLibraryOrUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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

public class data {
    public static void main(String[] args) {
        WebDriver driver = null;
        FileInputStream fis = null;
        FileOutputStream fos = null;
        Workbook book = null;
        try {
            // Set up WebDriver
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.get("https://swift.ngage.services/display/view");
            driver.findElement(By.xpath("//input[@placeholder='User']")).sendKeys("swiftadmin_TEST");
            driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Test@2024");
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            driver.findElement(By.xpath("(//a[text()='Displays'])[2]")).click();

            ArrayList<String> nameMenu = new ArrayList<>();
            fis = new FileInputStream("C:\\selenium\\book1.xlsx");

            // Load Excel workbook and sheet
            book = WorkbookFactory.create(fis);
            Sheet sh = book.getSheet("Sheet1");
            DataFormatter df = new DataFormatter();

            // Read data from Excel file
            for (int i = 1; i <= sh.getLastRowNum(); i++) {
                Row r = sh.getRow(i);
                String s = df.formatCellValue(r.getCell(0));
                nameMenu.add(s);
            }

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            fos = new FileOutputStream("C:\\selenium\\book.xlsx");

            // Search data on the webpage and write results back to Excel
            for (int i = 0; i < nameMenu.size(); i++) {
                driver.findElement(By.xpath("//input[@id='display']")).clear();
                driver.findElement(By.xpath("//input[@id='display']")).sendKeys(nameMenu.get(i));
                Thread.sleep(3000);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[@class='table-success odd']/td[3]")));

                WebElement defaultLayout = driver.findElement(By.xpath("//tr[@class='table-success odd']/td[3]"));
                String value = defaultLayout.getText();
                System.out.println(value);

                Row row = sh.getRow(i + 1);
                if (row == null) row = sh.createRow(i + 1);
                Cell cell = row.createCell(1); // Write result in the second column
                cell.setCellValue(value);
            }

            // Write the updated workbook to file
            book.write(fos);
            fos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) fis.close();
                if (fos != null) fos.close();
                if (book != null) book.close();
                if (driver != null) driver.quit();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
