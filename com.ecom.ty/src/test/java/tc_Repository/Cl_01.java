package tc_Repository;

import org.testng.annotations.Test;

import GenericLibraryOrUtility.BaseClass;
import GenericLibraryOrUtility.ExcelUtility;

import objectRepository.ClaimPage;
import objectRepository.DashboasrdPage;

public class Cl_01 extends BaseClass {
	@Test(groups = { "regression" })
	public void claimModule() throws Exception {
		ExcelUtility EUTIL = new ExcelUtility();
		String EMPNAME = EUTIL.getDataFromExcel("Claim", 1, 1);
		String REFID = EUTIL.getDataFromExcel("Claim", 1, 2);

		DashboasrdPage dp = new DashboasrdPage(driver);
		dp.clickOnClaim();

		ClaimPage cp = new ClaimPage(driver);
		cp.fillTheDetails(EMPNAME, REFID);
		System.out.println("Claim module run successfully!!");
	}
}
