package testNG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertExample {

	@Test
	public void createCustomerTest() {
		SoftAssert sa = new SoftAssert();
		System.out.println("Customer 1 created successfully!");
		sa.assertEquals(false, true);
		System.out.println("Customer 2 created successfully!");
		System.out.println("Customer 3 created successfully!");
		sa.assertEquals(false, false);
	}
	
	@Test
	public void deleteCustomerTest() {
		SoftAssert sa = new SoftAssert();
		System.out.println("Customer 1 deleted successfully!");
		sa.assertEquals(false, false);
		System.out.println("Customer 2 deleted successfully!");
		System.out.println("Customer 3 deleted successfully!");
		sa.assertEquals(true, true);
		sa.assertAll();
	}
	
}
