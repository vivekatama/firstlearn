package sample_Tc_Repo;

import org.testng.annotations.Test;
//@Test

public class Tc_01 {

	@Test (priority=-1)
	public void createUser() {
		System.out.println("createUser!!");
	}
	@Test(priority =-2)
	public void modifyUser() {
		System.out.println("modifyUser!!");
	}
	@Test(priority =-3)
	public void deleteUser() {
		System.out.println("deleteUser!!");
	}

}
