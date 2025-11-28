package sample_Tc_Repo;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class Tc_03 {
	@Test (priority=1, invocationCount = 2)
	public void createUser() {
		System.out.println("createUser!!");
	}
	@Test(priority =2, enabled = true)
	public void modifyUser() {
		System.out.println("modifyUser!!");
	}
	
	@Test(priority =3 )
	@Ignore
	public void deleteUser() {
		System.out.println("deleteUser!!");
	}
}
