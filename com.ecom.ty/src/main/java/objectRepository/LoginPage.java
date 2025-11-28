package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this is the POM class for login page 
 * @author Vivek
 * @version 5.1.0
 */
public class LoginPage {
// for declaration of webelements 
	@FindBy(xpath = "//input[@placeholder='Username']")
	private WebElement username;
	
	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement Password;
	
	@FindBy(xpath = "//button[text()=' Login ']")
	private WebElement loginBtn;
	
//initialization of webelemet
	public LoginPage (WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
		
//Accessing the weblements 

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return Password;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
/**
 * this is the business library for login operation
 * @param uname
 * @param pass	
 */
	public void login(String uname, String pass) {
		getUsername().sendKeys(uname);
	username.sendKeys(uname);
		getPassword().sendKeys(pass);
		getLoginBtn().click();
	}
	
}
