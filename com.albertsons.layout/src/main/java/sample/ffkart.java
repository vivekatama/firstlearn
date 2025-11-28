package sample;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.ArrayList;

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

public class ffkart {
    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/");

//        // Close the login pop-up if it appears
//        try {
//            WebElement closeButton = driver.findElement(By.xpath("//button[contains(text(),'✕')]"));
//            closeButton.click();
//        } catch (Exception e) {
//            // Pop-up did not appear
//        }

        ArrayList<String> nameMenu = new ArrayList<>();

        // Read data from Excel file
        try (FileInputStream fis = new FileInputStream("C:\\selenium\\data1.xlsx");
             Workbook book = WorkbookFactory.create(fis)) {

            Sheet sheet = book.getSheet("Sheet1");
            DataFormatter df = new DataFormatter();

            // Read each cell value from the Excel sheet
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                for (int j = 1; j < row.getLastCellNum(); j++) {
                    String cellValue = df.formatCellValue(row.getCell(j));
                    nameMenu.add(cellValue);
                }
            }

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            for (int i = 0; i < nameMenu.size(); i++) {
                driver.findElement(By.xpath("//input[@name='q']")).clear();
                WebElement search = driver.findElement(By.xpath("//input[@name='q']"));
                search.sendKeys(nameMenu.get(i));
                search.submit();
                

                // Wait until the results are visible
                //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("(//div[@class=\"yKfJKb row\"])[1]")));

                // Assuming the first product element contains the necessary text
                WebElement element = driver.findElement(By.cssSelector("(//div[@class=\"yKfJKb row\"]//div//div/ul)[1]"));
                String value = element.getText();
                System.out.println(value);

                // Write the result back to the Excel file
                Row row = sheet.getRow(i + 1);
                if (row == null) row = sheet.createRow(i + 1);
                row.createCell(1).setCellValue(value); // Adjust column index as needed
            }

            // Write changes to the Excel file
            try (FileOutputStream fos = new FileOutputStream("C:\\selenium\\data1.xlsx")) {
                book.write(fos);
            }
        }

        driver.quit();
    }
}
