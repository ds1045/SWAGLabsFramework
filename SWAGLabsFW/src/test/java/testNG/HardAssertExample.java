package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertExample {

	@Test
	public void createCustomerTest() {
		System.out.println("Customer 1 created successfully!");
		Assert.assertEquals(false, true);
		System.out.println("Customer 2 created successfully!");
		System.out.println("Customer 3 created successfully!");
		Assert.assertEquals(false, false);
	}
	
	@Test
	public void deleteCustomerTest() {
		System.out.println("Customer 1 deleted successfully!");
		Assert.assertEquals(false, false);
		System.out.println("Customer 2 deleted successfully!");
		System.out.println("Customer 3 deleted successfully!");
		Assert.assertEquals(true, true);
	}
	
}
