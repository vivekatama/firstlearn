package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PimPage {
@FindBy(xpath = "(//input[@placeholder='Type for hints...'])[1]")
private WebElement empname;
@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
private WebElement empid;
@FindBy(xpath = "(//input[@placeholder='Type for hints...'])[2]")
private WebElement supervisourName;
@FindBy(xpath = "//button[text()=' Search ']")
private WebElement searchBtn;
public PimPage(WebDriver driver) {
	PageFactory.initElements(driver,this);
}
public WebElement getEmpname() {
	return empname;
}
public WebElement getEmpid() {
	return empid;
}
public WebElement getSupervisourName() {
	return supervisourName;
}

public WebElement getSearchBtn() {
	return searchBtn;
}
/**
 * this is the business library to fill valid crediantial for Pim page
 * 
 */
public void fillValidCrediantial(String ename, String id, String sname) {
	getEmpname().sendKeys(ename);
	getEmpid().sendKeys(id);
	getSupervisourName().sendKeys(sname);
	searchBtn.click();
}
public void searchoperation(String ename, String id, String sname) {
	getEmpname().sendKeys(ename);
	getEmpid().sendKeys(id);
	searchBtn.click();
		
}

}
