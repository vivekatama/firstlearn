package scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.page.Page.GetAppManifestResponse;

public class scenarios21 {
public static void main(String[] args) throws Exception {
	ChromeDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	Thread.sleep(3000);
	driver.get("https://demoapps.qspiders.com/ui/radio?sublist=0");
	Thread.sleep(2000);
	WebElement btn = driver.findElement(By.xpath("//section[text()='Radio Button']"));
	Thread.sleep(3000);
	boolean visible = btn.isDisplayed();
	System.out.println("button is visible"+ visible);
	Thread.sleep(3000);
	boolean enable = btn.isEnabled();
	System.out.println("button is enable"+ enable);
	Thread.sleep(3000);
	boolean select = btn.isSelected();
	System.out.println("button is selected"+ select);
	
	String tagname = btn.getTagName();
	System.out.println("tagname is "+ tagname);
	String attribute = btn.getAttribute("Class");
	System.out.println(attribute);
	System.out.println(btn.getLocation());
	System.out.println(btn.getSize());
	driver.close();
	
}
}
