package testNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

@Test(groups = {"regression"})
public class SampleTest {

	@Test
	public void createUserProfile() {
		Reporter.log("User Profile Created successfully!");
	}
	
	@Test
	public void modifyUserProfile() {
		Reporter.log("User Profile Modified successfully!");
	}
	
	@Test
	public void deleteUserProfile() {
		Reporter.log("User Profile Deleted successfully!");
	}
	
}
