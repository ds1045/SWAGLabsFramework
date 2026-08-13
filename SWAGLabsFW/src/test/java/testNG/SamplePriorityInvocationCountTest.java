package testNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

@Test(groups = {"regression"})
public class SamplePriorityInvocationCountTest {

	@Test(priority = 1, invocationCount = 3)
	public void createUserProfile() {
		Reporter.log("User Profile Created successfully!");
	}
	
	@Test(priority = 2, invocationCount = 2)
	public void modifyUserProfile() {
		Reporter.log("User Profile Modified successfully!");
	}
	
	@Test(priority = 3)
	public void deleteUserProfile() {
		Reporter.log("User Profile Deleted successfully!");
	}
	
}
