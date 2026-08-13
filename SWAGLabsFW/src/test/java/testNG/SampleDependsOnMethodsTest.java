package testNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

@Test(groups = {"regression"})
public class SampleDependsOnMethodsTest {

	@Test
	public void createUserProfile() {
		Reporter.log("User Profile Created successfully!");
	}
	
	@Test(dependsOnMethods = "createUserProfile")
	public void modifyUserProfile() {
		Reporter.log("User Profile Modified successfully!");
	}
	
	@Test(dependsOnMethods = {"createUserProfile","modifyUserProfile"})
	public void deleteUserProfile() {
		Reporter.log("User Profile Deleted successfully!");
	}
	
}
