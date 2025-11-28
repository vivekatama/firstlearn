package sample_Tc_Repo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assert_Concept_HardAssert {
// strict level comparison 
	@Test
	public void hardAssertStrictLevelComparision() {
		String expectedData ="raja";
		String actualdData ="raja";
		Assert.assertEquals(actualdData, expectedData);
		System.out.println("assertion done!!");
		
	}
	// contains level comparison
	@Test
	public void hardAssertContainsLevelComparision() {
		String expectedData ="raja";
		String actualdData ="Maharaja";
		Assert.assertTrue(actualdData.contains(expectedData));
		System.out.println("assertion contains done...");
	}
	
}
