package tc_Repository;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericLibraryOrUtility.BaseClass;
import GenericLibraryOrUtility.ExcelUtility;
import objectRepository.Adminpage;
import objectRepository.DashboasrdPage;

@Listeners(GenericLibraryOrUtility.ListenersImplementationClass.class)
public class Ad_01 extends BaseClass {

	@Test(retryAnalyzer = GenericLibraryOrUtility.RetryAnalyzerImplementationClass.class)
	public void adminModule() throws Exception {
		ExcelUtility EUTIL = new ExcelUtility();
		String USERNAME = EUTIL.getDataFromExcel("Admin", 1, 1);
		String EMPNAME = EUTIL.getDataFromExcel("Admin", 1, 2);

		DashboasrdPage dp = new DashboasrdPage(driver);
		dp.clickOnAdmin();

		Adminpage ap = new Adminpage(driver);
		ap.provideFields(USERNAME, EMPNAME);
		System.out.println("admin module execution data!!");
	}
}
