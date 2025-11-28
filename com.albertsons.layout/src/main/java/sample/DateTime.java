package sample;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import genericLibrary.XLUtility;

public class DateTime {
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

		ArrayList<String> nameMenu=new ArrayList<String>();
		String path = "C:\\selenium\\Book1.xlsx";
		XLUtility xlutil=new XLUtility(path);

		int totalrows=xlutil.getRowCount("Sheet4");
		int totalcols=xlutil.getCellCount("Sheet4", 0);


		for(int i=0; i<=totalrows; i++) {
			//Row r=sh.getRow(i);
			for(int j=0; j<=totalcols-1;j++) {
				//String value = df.formatCellValue(r.getCell(j));
				String insertData=xlutil.getCellData("Sheet4", i, j);
				System.out.println(insertData);
				

				nameMenu.add(insertData);
			}
		}
		for(int r=0; r<=nameMenu.size(); r++) 
		{

			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='display']")).clear();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id=\"display\"]")).sendKeys(nameMenu.get(r));
			Thread.sleep(2000);
			Actions act = new Actions(driver);
			WebElement dropdown=	driver.findElement(By.xpath("//div[@title='Row Menu']"));
			act.moveToElement(dropdown).perform();	
			Thread.sleep(2000);
			WebElement element=	driver.findElement(By.xpath("(//button[@data-toggle=\"dropdown\"])[1]"));
			act.click(element).perform();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@x-placement='top-end']//a[2]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//b[@role='presentation'])[1]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[@class=\"select2-results\"]//ul/li[4]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[text()='Save']")).click();

			// Get the current date and time
			LocalDateTime currentDateTime = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			String formattedDateTime = currentDateTime.format(formatter);
			
			xlutil.setCellData("Sheet4", r, 1,formattedDateTime );
		}
		driver.close();
	}

}
