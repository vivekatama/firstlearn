package sample_Tc_Repo;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assert_Concept_SoftAssert {
	// strict level comparison 
	@Test
		public void softAssertStrictLevelComparision() {
			String expectedData ="raja";
			String actualdData ="Raja";
			SoftAssert sa =new SoftAssert();
			sa.assertEquals(actualdData, expectedData);
			System.out.println("assertion done!!");
			sa.assertAll();
			
		}
		// contains level comparison
		@Test
		public void softAssertContainsLevelComparision() {
			String expectedData ="raja";
			String actualdData ="Maharaja";
			SoftAssert sa =new SoftAssert();
			sa.assertTrue(actualdData.contains(expectedData));
			System.out.println("assertion contains done...");
			sa.assertAll();
		}

}
