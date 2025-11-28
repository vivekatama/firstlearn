package objectRepository;
/*
 * this is the pom class for claim page 
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClaimPage {
	@FindBy(xpath = "(//input[@placeholder='Type for hints...'])[1]")
	private WebElement empName;
	@FindBy(xpath = "(//input[@placeholder='Type for hints...'])[2]")
	private WebElement refId;
	@FindBy(xpath = "//button[text()=' Search ']")
	private WebElement searchBtn;
	
	public ClaimPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getEmpName() {
		return empName;
	}

	public WebElement getRefId() {
		return refId;
	}
	
	public WebElement getSearchBtn() {
		return searchBtn;
	}

	/*
	 * this is the business library to fill the details 
	 */
	public void fillTheDetails(String ename, String refId) {
		getEmpName().sendKeys(ename);
		getRefId().sendKeys(refId);
		getSearchBtn().click();
	}
	
}
