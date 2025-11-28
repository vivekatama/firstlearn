package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.dockerjava.api.model.Driver;
/**
 * This is the POM class for dashboard/ Home page  
 */
public class DashboasrdPage {
	// for declaration of webelements 
	@FindBy(xpath = "//span[text()='Admin']")
	private WebElement admin;

	@FindBy(xpath = "//span[text()='PIM']")
	private WebElement pim;

	@FindBy(xpath = "//span[text()='Claim']")
	private WebElement claim;
	
	@FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
	private WebElement dropdown;

	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logout;
	
	// initialization of webelement
	public DashboasrdPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Accessing the webelement
	public WebElement getAdmin() {
		return admin;
	}

	public WebElement getPim() {
		return pim;
	}

	public WebElement getClaim() {
		return claim;
	}

	public WebElement getDropdown() {
		return dropdown;
	}

	public WebElement getLogout() {
		return logout;
	}
	/**
	 *  this is the business library to perform the logout operation 
	 */
	public void logoutOperation() {
		getDropdown().click();
		getLogout().click();
	}

	/**
	 *  this method is to click on admin button
	 */
	public void clickOnAdmin() {
		getAdmin().click();
	}

	public void clickOnClaim() {
		getClaim().click();
	}
	
	public void clickOnPim() {
		getPim().click();
	}
	/**
	 * this method is to click on adminAndLogout button
	 */

	public void clickOnAdminAndLogout() {
		getAdmin().click();
		getDropdown().click();
		getLogout().click();
	}

	/**
	 * this method is to click on PIM and logout
	 */
	public void clickOnPimAndLogout() {
		getPim().click();
		logoutOperation();
	}

	/**
	 * this method is to click on Claim and logout
	 */
	public void clickOnClaimAndLogout() {
		getClaim().click();
		logoutOperation();
	}



	/**
	 * this business library for Dashboard operation 
	 * @param admin
	 * @param pim
	 * @param claim
	 * @param dropdown
	 * @param logout
	 */
	//	public void dashboard() {
	//		getAdmin().click();
	//		getPim().click();
	//		getClaim().click();
	//		getDropdown().click();
	//		getLogout().click();
	//	}


}
