package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Adminpage {
	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
	private WebElement username;
	
	@FindBy(xpath = "//input[@placeholder='Type for hints...']")
	private WebElement empname;
	
	@FindBy(xpath = "//button[text()=' Search ']")
	private WebElement searchBtn;

	public Adminpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getEmpname() {
		return empname;
	}
	 
	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	/**
	 * this the business library to provide the username and empname 
	 * @param unmae
	 * @param empname
	 */
	
	public void provideFields(String uname, String ename) {
		getUsername().sendKeys(uname);
		getEmpname().sendKeys(ename);
		searchBtn.click();
	}
	/**
	 * this the business library to provide the username 
	 */
	public void provideFields(String unmae) {
		getUsername().sendKeys(unmae);
		searchBtn.click();
	}
	/**
	 * this is a business library to provide the empname
	 * @param enmae 
	 */
	public void provideFieldsWithEname(String ename) {
		getEmpname().sendKeys(ename);
		searchBtn.click();
	}
}
