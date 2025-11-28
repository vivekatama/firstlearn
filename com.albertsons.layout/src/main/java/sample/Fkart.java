package sample;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import genericLibrary.XLUtility;

public class Fkart {
	public static void main(String[] args) throws Exception {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(3000);

		ArrayList<String> nameMenu=new ArrayList<String>();
		String path = "C:\\selenium\\data1.xlsx";
		XLUtility xlutil=new XLUtility(path);

		int totalrows=xlutil.getRowCount("Sheet2");
		int totalcols=xlutil.getCellCount("Sheet2", 1);


		for(int i=0; i<=totalrows; i++) {
			//Row r=sh.getRow(i);
			for(int j=0; j<=totalcols-1;j++) {
				//String value = df.formatCellValue(r.getCell(j));
				String insertData=xlutil.getCellData("Sheet2", i, j);
//				System.out.println(insertData);
//				System.out.println("*************************************");

				nameMenu.add(insertData);
			}
		}
		for(int r=0; r<=nameMenu.size(); r++) 
		{
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@name='q']")).clear();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='q']")).sendKeys(nameMenu.get(r));
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
			
			Thread.sleep(2000);
			
			String PDetails = driver.findElement(By.xpath("(//div[@class=\"yKfJKb row\"]//div//div/ul)[1]")).getText();
	//			System.out.println(PDetails);
	//			System.out.println("***********************************");
			//String value=search.getText();
			Thread.sleep(2000);
			String PPrice=driver.findElement(By.xpath("(//div[@class=\"col col-5-12 BfVC2z\"]//div//div//div)[1]")).getText();
			System.out.println(PPrice);
			System.out.println("***************************************");
			Thread.sleep(2000);
			xlutil.setCellData("Sheet2", r, 1, PDetails,2, PPrice);


			//driver.close();
		}
	}

}
