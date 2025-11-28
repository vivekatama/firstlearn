package scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class scenarios18 {
    public static void main(String[] args) throws Exception {

        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.flipkart.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement search = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.name("q"))
        );
        search.sendKeys("iphone 11");
        search.submit();

        // Wait for product title
        WebElement pnameEle = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//div[contains(@class,'_4rR01T') and contains(text(),'iPhone 11')]")
                )
        );

        String pname = pnameEle.getText();

        // Find price relative to same card
        WebElement priceEle = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//div[contains(@class,'_4rR01T') and contains(text(),'iPhone 11')]" +
                                "/ancestor::div[contains(@class,'_75nlfW')]//div[contains(@class,'Nx9bqj')]")
                )
        );

        String pprice = priceEle.getText();

        System.out.println(pname + " ---- " + pprice);

        driver.quit();
    }
}
