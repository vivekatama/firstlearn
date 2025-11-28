package tc_Repository;

import org.testng.annotations.Test;

import GenericLibraryOrUtility.BaseClass;
import GenericLibraryOrUtility.ExcelUtility;
import objectRepository.DashboasrdPage;
import objectRepository.PimPage;

public class Pi_01 extends BaseClass{
@Test (groups = {"smoke","regression"})
public void piModule()throws Exception {
	ExcelUtility EUTIL = new ExcelUtility();
	String EMPNAME = EUTIL.getDataFromExcel("Pim", 1, 1);
	String EMPID = EUTIL.getDataFromExcel("Pim", 1, 2);
	String SUPERVISOR = EUTIL.getDataFromExcel("Pim", 1, 3);
	
	DashboasrdPage dp = new DashboasrdPage(driver);
	dp.clickOnPim();
	
	PimPage pim = new PimPage(driver);
	pim.fillValidCrediantial(EMPNAME, EMPID, SUPERVISOR);
	System.out.println();
}
}
