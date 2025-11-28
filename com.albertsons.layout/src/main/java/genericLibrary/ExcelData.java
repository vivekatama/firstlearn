package genericLibrary;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExcelData {
    public static void main(String[] args) {
        WebDriver driver = null;
        FileInputStream fis = null;
        FileOutputStream fos = null;
        Workbook book = null;

        try {
            // Initialize WebDriver
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.get("https://swift.ngage.services/display/view");
            driver.findElement(By.xpath("//input[@placeholder='User']")).sendKeys("swiftadmin_TEST");
            driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Test@2024");
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            driver.findElement(By.xpath("(//a[text()='Displays'])[2]")).click();

            // Read Excel file
            fis = new FileInputStream("C:\\selenium\\book2.xlsx");
            book = WorkbookFactory.create(fis);
            Sheet sh = book.getSheet("Sheet3");

            // Extract values from the web page
            WebElement defaltLayout1 = driver.findElement(By.xpath("//tbody/tr[1]/td[3]"));
            String value1 = defaltLayout1.getText();
            System.out.println(value1);
            Thread.sleep(3000);

            WebElement defaltLayout2 = driver.findElement(By.xpath("//tbody/tr[2]/td[3]"));
            String value2 = defaltLayout2.getText();
            System.out.println(value2);
            Thread.sleep(3000);

            WebElement defaltLayout3 = driver.findElement(By.xpath("//tbody/tr[3]/td[3]"));
            String value3 = defaltLayout3.getText();
            System.out.println(value3);

            // Write values to Excel file
            if (sh.getRow(1) == null) sh.createRow(1).createCell(2).setCellValue(value1);
            else sh.getRow(1).createCell(2).setCellValue(value1);

            if (sh.getRow(2) == null) sh.createRow(2).createCell(2).setCellValue(value2);
            else sh.getRow(2).createCell(2).setCellValue(value2);

            if (sh.getRow(3) == null) sh.createRow(3).createCell(2).setCellValue(value3);
            else sh.getRow(3).createCell(2).setCellValue(value3);

            // Save and close the Excel file
            fos = new FileOutputStream("C:\\selenium\\book2.xlsx");
            book.write(fos);
            fos.flush();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Proper cleanup
            try {
                if (fos != null) fos.close();
                if (fis != null) fis.close();
                if (book != null) book.close();
                if (driver != null) driver.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

