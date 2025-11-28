package Section1;

import org.openqa.selenium.chrome.ChromeDriver;

public class MaximizeMinimize {
public static void main(String[] args) {
	// Step 1: Create a instance of ChromeDricer
		ChromeDriver driver = new ChromeDriver();
	// Step 2: Access any website 
		driver.get("https://www.flipkart.com/");
	// Step 3: Maximize the window 
		driver.manage().window().maximize();
	// Step 4: Minimize the window 
		driver.manage().window().minimize();
	// Step 5: Again maximize the window 
		driver.manage().window().maximize();
	// Step 6: steps to fetch the title, URL, and Source code of the current page
		String title = driver.getTitle();
		System.out.println(title);
		String url = driver.getCurrentUrl();
		System.out.println(url);
		String src = driver.getPageSource();
		System.out.println(src);
}
}
