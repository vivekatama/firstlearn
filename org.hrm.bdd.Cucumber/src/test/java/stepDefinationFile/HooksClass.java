package stepDefinationFile;

import org.testng.annotations.BeforeClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class HooksClass {

	@Before("@Smoke")
	public void precondition() {
		System.out.println("pre condition pass");
	}
	@After("@Smoke")
	public void postcondition() {
		System.out.println("pre condition pass");
	}
}
