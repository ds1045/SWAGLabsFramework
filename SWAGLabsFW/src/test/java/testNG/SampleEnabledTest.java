package testNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

@Test(groups = {"smoke"})
public class SampleEnabledTest {

	@Test
	public void createUserProfile() {
		Reporter.log("User Profile Created successfully!");
	}
	
	@Test
	public void modifyUserProfile() {
		Reporter.log("User Profile Modified successfully!");
	}
	
	@Test(enabled = false)
	public void deleteUserProfile() {
		Reporter.log("User Profile Deleted successfully!");
	}
	
}
