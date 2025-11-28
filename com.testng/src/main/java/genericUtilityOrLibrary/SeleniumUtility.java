package genericUtilityOrLibrary;
import java.io.File;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

/**
 * this is the webDriver utility class to use all the selenium webdriver methods
 */
public class SeleniumUtility {
		/**
		 * This method is to capture screenshot
		 */
		public void captureScreenshot(String name)throws Exception{
			TakesScreenshot ts =(TakesScreenshot)BaseClass.driver;
			File scr = ts.getScreenshotAs(OutputType.FILE);
			File dest = new File(".\\ScreenShotFolder\\"+ name+".png");
			Files.copy(scr, dest);
		}

		public void captureScreenshots(WebDriver driver,	String testCaseName)throws Exception{
			TakesScreenshot ts1 =(TakesScreenshot)BaseClass.driver;
			File scr = ts1.getScreenshotAs(OutputType.FILE);
			File dest = new File(".\\ScreenShotFolder\\"+ testCaseName+".png");
			Files.copy(scr, dest);
		}
		
		
		
		
		
		
		
		/**
		 * this is the generic methods use to maximize the window 
		 * @param driver
		 */

		public void windowMaximization(WebDriver driver) {
			driver.manage().window().maximize();
		}

		/**
		 * This method is for implicit wait
		 * @param sec
		 */

		public void implicitwait(int sec) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
		}
		
		/* Select class methods */
		/**
		 * this method is to handle drop down with index
		 * @param driver
		 * @param indexNo
		 */

		public void selectWithIndex(WebElement element, int indexno ) {
			Select s = new Select(element);
			s.selectByIndex(indexno);
		}

		/**
		 * this method is to handle drop down with visible text
		 * @param element
		 * @param text
		 */
		public void selectWithVisibleText(WebElement element, String text) {
			Select s = new Select(element);
			s.selectByVisibleText(text);
		}
		
		/**
		 * this method is to handle drop down with value
		 * @param element
		 * @param value
		 */
		
		public void selectWithValue(WebElement element, String value) {
			Select s = new Select(element);
			s.deselectByValue(value);
		}
		
		/**
		 * this method is to perform de-select operation by index
		 * @param element
		 * @param indexNo
		 */
		
		public void deSelectWithIndex(WebElement element, int indexNo) {
			Select s = new Select(element);
			s.deselectByIndex(indexNo);
		}
		/**
		 * this method is to perform de-select operation by visible text 
		 * @param element
		 * @param text
		 */
		
		public void deSelectWithVisibleText(WebElement element, String text) {
			Select s = new Select(element);
			s.deselectByVisibleText(text);
		}
		
		/**
		 * this method is to perform de-select operation by visible text 
		 * @param element
		 * @param value
		 */
		
		public void deSelectWithValuet(WebElement element, String value) {
			Select s = new Select(element);
			s.deselectByValue(value);
		}
		
		/* Actions class method/Mouse action methods*/
		/**
		 * this method is to move the cursor towards an element 
		 * @param driver 
		 * @param element
		 */
		public void moveTowardsElement(WebDriver driver, WebElement element) {
			Actions act = new Actions(driver);
			act.moveToElement(element);
		}
		
		/**
		 * this method is to perform right click on an element 
		 * @param driver 
		 * @param element
		 */
		public void rightClick(WebDriver driver, WebElement element) {
			Actions act = new Actions(driver);
			act.contextClick(element);
		}
		
		/**
		 * this method we use to click on an element
		 * @param driver
		 * @param element 
		 */
		
		public void clickOnElement(WebDriver driver, WebElement element) {
			Actions act = new Actions(driver);
			act.click(element);
		}
		
		/**
		 * this method we use to double click on an element
		 * @param driver
		 * @param element 
		 */
		
		public void doubleClick(WebDriver driver, WebElement element) {
			Actions act = new Actions(driver);
			act.doubleClick(element);
		}
		
		/**
		 * This method is use to drag and drop an element and drop it to another point
		 * @param driver
		 * @param src
		 * @param dest
		 */
		
		public void dragAnddropOperation(WebDriver driver, WebElement src, WebElement dest) {
			Actions act = new Actions(driver);
			act.dragAndDrop(src, dest);
		}
		
		/**
		 * this method is to handle slider 
		 * @param driver
		 * @param src
		 * @param x
		 * @param y
		 */
		public void sliderHandling (WebDriver driver, WebElement src, int x, int y) {
			Actions act = new Actions(driver);
			act.dragAndDropBy(src, x, y);
		}
		
		/**
		 * this method is to perform mouse actions 
		 * @param driver
		 */
		public void toPerformMouseAaction(WebDriver driver) {
			Actions act = new Actions(driver);
			act.perform();
		}
		/**
		 * this method is use to scroll to a particular element 
		 * @param driver 
		 * @param element 
		 */
		
		public void scrollUpToAnElement(WebDriver driver, WebElement element) {
			Actions act = new Actions(driver);
			act.scrollToElement(element);
		}
		
		/* Alert popUp method */
		/**
		 * this method is use to accept the alert
		 * @param driver  
		 */
		public void accepTheAlert(WebDriver driver) {
			driver.switchTo().alert().accept();
		}
		
		/**
		 * this method is use to cancel the alert
		 * @param driver  
		 */
		public void dismissTheAlert(WebDriver driver) {
			driver.switchTo().alert().dismiss();
		}
		/**
		 * this method is use to fetch the alert messaged
		 * @param driver
		 * @return  
		 */
		public String fetchAlertMsg(WebDriver driver) {
			String alertMsg= driver.switchTo().alert().getText();
			return alertMsg;
		}
		/**
		 * this method is use to send the alert message
		 * @param driver  
		 * @param value
		 */
		public void sendAlertMsg(WebDriver driver, String value) {
			driver.switchTo().alert().sendKeys(value);
		}
		
		// frame handling methods 
		/**
		 * this method will help t handle frame based on index
		 * @param driver
		 * @param index
		 */
		
		public void handleFrameIndex (WebDriver driver, int index) {
			driver.switchTo().frame(index);
		}
		/**
		 * handle frame based on WEBelement
		 * @param driver
		 * @param element
		 */
		
		public void handleFrameWebElement (WebDriver driver, WebElement element) {
			driver.switchTo().frame(element);
		}
		/**
		 * switch to parent frame 
		 * @param driver
		 */
		public void parentFrame(WebDriver driver) {
			driver.switchTo().parentFrame();
		}
		
	}

