package Section2;

import java.time.Duration;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MakeMyTrip39 {
	public static void main(String[] args)throws Exception  {

		//Calendar cal = Calendar.getInstance();

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
//	WebElement date = driver.findElement(By.xpath("//div[@class=\"DayPicker-Months\"]/div/div[@class=\"DayPicker-Body\"]/div/div[@aria-disabled=\"false\" and @aria-selected=\"true\"]/div[@class=\"dateInnerCell\"]"));
//		String days = date.getText();
//		//System.out.println(days);
//	WebElement TicketPrice = driver.findElement(By.xpath("//div[@class=\"DayPicker-Months\"]/div/div[@class=\"DayPicker-Body\"]/div/div[@aria-disabled=\"false\" and @aria-selected=\"true\"]/div/p[@class=\" todayPrice\"]"));
//		String price = TicketPrice.getText();
//		System.out.println(days+" ---- "+price);
//		
	
		//List<WebElement> date = driver.findElements(By.xpath("//div[@class=\"DayPicker-Months\"]/div/div[@class=\"DayPicker-Body\"]/div/div[@aria-disabled=\"false\" and @aria-selected=\"true\"]/div[@class=\"dateInnerCell\"]"));
		List<WebElement> date = driver.findElements(By.xpath("//div[@class=\"DayPicker-Months\"]"
				+ "/div/div[@class=\"DayPicker-Body\"]/div/div[@aria-disabled=\"false\" ]"
				+ "/div[@class=\"dateInnerCell\"]"));
		
		//List<WebElement> date = driver.findElements(By.xpath("//div[@class='dateInnerCell']"));
		
		//List<WebElement> TicketPrice = driver.findElements(By.xpath("//div[@class=\"DayPicker-Months\"]/div/div[@class=\"DayPicker-Body\"]/div/div[@aria-disabled=\"false\" and @aria-selected=\"true\"]/div/p[@class=\" todayPrice\"]"));
				
		List<WebElement> TicketPrice = driver.findElements(By.xpath("//div[@class=\"DayPicker-Months\"]"
				+ "/div/div[@class=\"DayPicker-Body\"]/div/div[@aria-disabled=\"false\" ]"
				+ "/div/p[@class=\" todayPrice\"]"));
		
//		for(int i=0; i<=date.size()-1;i++)
//		{
//			System.out.println(date.get(i).getText()+" :- "+TicketPrice.get(i).getText());
//		}
		
		Iterator<WebElement> itr1 = date.iterator();
		Iterator<WebElement> itr2= TicketPrice.iterator();
		Thread.sleep(2000);
		while(itr1.hasNext()&& itr2.hasNext())
		{
			String allDates = itr1.next().getText();
			String allprices = itr2.next().getText();
			System.out.println(allDates +" :- "+ allprices);
		}
			
		//driver.close();
	}
}
