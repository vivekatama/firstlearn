package genericLibrary;

import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.time.Duration;
import java.util.ArrayList;

public class WriteData {

    private static final String EXCEL_FILE_PATH = "C:\\selenium\\abc.xlsx";
    private static final String URL = "https://swift.ngage.services/display/view";
    private static final String USERNAME = "swiftadmin_TEST";
    private static final String PASSWORD = "Test@2024";

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        try {
            // Setup WebDriver
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.get(URL);

            // Perform login
            performLogin(driver);

            // Navigate to the desired page
            navigateToDisplaysPage(driver);

            // Read from Excel and process data
            ArrayList<String> nameMenu = readFromExcel();

            // Process each item from the list and write back to Excel
            processAndWriteData(driver, nameMenu);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Ensure the WebDriver is closed
            driver.quit();
        }
    }

    private static void performLogin(WebDriver driver) {
        driver.findElement(By.xpath("//input[@placeholder='User']")).sendKeys(USERNAME);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(PASSWORD);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    private static void navigateToDisplaysPage(WebDriver driver) {
        driver.findElement(By.xpath("(//a[text()='Displays'])[2]")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-outline-secondary']")).click();
    }

    private static ArrayList<String> readFromExcel() throws IOException {
        ArrayList<String> nameMenu = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(EXCEL_FILE_PATH);
             Workbook book = WorkbookFactory.create(fis)) {

            Sheet sheet = book.getSheet("Sheet1");
            DataFormatter df = new DataFormatter();

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                for (int j = 1; j <= row.getLastCellNum(); j++) {
                    String cellValue = df.formatCellValue(row.getCell(j));
                    nameMenu.add(cellValue);
                }
            }
        }

        return nameMenu;
    }

    private static void processAndWriteData(WebDriver driver, ArrayList<String> nameMenu) throws IOException {
        try (FileInputStream fis = new FileInputStream(EXCEL_FILE_PATH);
             Workbook book = WorkbookFactory.create(fis);
             FileOutputStream fos = new FileOutputStream(EXCEL_FILE_PATH)) {

            Sheet sheet = book.getSheet("Sheet1");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            for (int i = 0; i < nameMenu.size(); i++) {
                WebElement displayInput = driver.findElement(By.xpath("//input[@id='display']"));
                displayInput.clear();
                displayInput.sendKeys(nameMenu.get(i));

                // Wait for the element to be visible
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr/td[3]")));

                WebElement defaultLayout = driver.findElement(By.xpath("//tbody/tr/td[3]"));
                String value = defaultLayout.getText();
                System.out.println(value);

                Row row = sheet.getRow(i + 1);
                if (row == null) row = sheet.createRow(i+1);

                Cell cell = row.createCell(2); // Assume the data goes into the second column
                cell.setCellValue(value);
            }

            book.write(fos);
        }
    }
}

