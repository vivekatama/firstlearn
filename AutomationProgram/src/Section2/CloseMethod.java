package Section2;

import java.util.Set;

import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CloseMethod {

	private static final int Set = 0;
	private static final int String = 0;

	public static void main(String[] args) throws Exception {
	 // step 1 Launch the chrome browser
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
//		EdgeDriver driver1 = new EdgeDriver();
		driver.manage().window().maximize();
		//Thread.sleep(3000);
		driver.switchTo().newWindow(WindowType.TAB);
		//driver.switchTo().newWindow(WindowType.WINDOW);
		//Thread.sleep(3000);
		driver.get("https://www.flipkart.com/");
		//Thread.sleep(3000);
		//driver.get("https://facebook.com/");
		 Set<String> windowIds = driver.getWindowHandles();
		for(String id:windowIds)
		{
			Thread.sleep(4000);
			driver.switchTo().window(id);
			driver.close();
		}
				
}
}
