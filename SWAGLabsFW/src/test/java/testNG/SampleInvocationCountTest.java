package testNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

@Test(groups = {"smoke"})
public class SampleInvocationCountTest {

	@Test(invocationCount = 3)
	public void createUserProfile() {
		Reporter.log("User Profile Created successfully!");
	}
	
	@Test(invocationCount = 2)
	public void modifyUserProfile() {
		Reporter.log("User Profile Modified successfully!");
	}
	
	@Test
	public void deleteUserProfile() {
		Reporter.log("User Profile Deleted successfully!");
	}
	
}
