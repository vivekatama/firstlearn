package sample_Tc_Repo;

import org.testng.annotations.Test;
/**
 * in @test we can pass multiple attribute 
 * @test (priority =2, invocationCount = 5)
 * if we want to execute a test case multiple times we have to use an attribute called as invocationCount.
 * 		@test (invocationCount = 5)
 * Ignoring test case from execution 
 * 		1. we can remove @test
 * 		2. we can use an attribute called as "enabled= false "
 * 		e.g - @Test(priority =3, enabled = false)
 * 		3. we can keep invocation count as '0'
 * 		>> default invocation count is '1'
 * 		4. we can keep @ignore annotation.
 * 		** creating dependencies between methods **
 * 1.if we want to create dependencies in between methods we have to use an attribute called as "depends on methods "
 * 				@Test(dependsOnMethods = ("createUser"))				
 */
public class Tc_02 {
	@Test (priority=1, invocationCount = 0)
	public void createUser() {
		System.out.println("createUser!!");
	}
	@Test(priority =2, dependsOnMethods = ("createUser"))
	public void modifyUser() {
		System.out.println("modifyUser!!");
	}
	@Test(priority =3)
	public void deleteUser() {
		System.out.println("deleteUser!!");
	}
}
