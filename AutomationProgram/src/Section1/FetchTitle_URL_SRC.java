package Section1;

import org.openqa.selenium.chrome.ChromeDriver;

public class FetchTitle_URL_SRC {
	public static void main(String[] args) {
		//Step 1:- Create instance of ChromeDriver
		ChromeDriver driver=new ChromeDriver();
		//step 2 :- access the web app
		driver.get("https://www.facebook.com/");
		// fetch title 
		String title = driver.getTitle();
		System.out.println(title);
		// fetch url
		String url = driver.getCurrentUrl();
		System.out.println(url);
		// fetch source code
		String src=driver.getPageSource();
		System.out.println(src);

	}
}
