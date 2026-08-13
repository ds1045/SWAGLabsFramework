package testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

	@Test(dataProvider = "dataProvider_bookTicketTest")
	public void bookTicketTest(String src, String dest) {
		System.out.println("Book Ticket from "+src+" to "+dest);
	}
	
	@DataProvider
	public Object[][] dataProvider_bookTicketTest()  {
		Object[][] obj = new Object[3][2];
		
		obj[0][0] = "New York";
		obj[0][1] = "Chicago";
		
		obj[1][0] = "New York";
		obj[1][1] = "San Fransico";
		
		obj[2][0] = "New York";
		obj[2][1] = "Los Angles";
		
		return obj;
	}
	
}
