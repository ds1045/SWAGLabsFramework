package testNG;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import pom_classes.CartPage;
import pom_classes.LoginPage;
import pom_classes.ProductsPage;

public class AddProductToCartTest {

	@Test(groups = {"smoke"})
	public void addProductToCartTest() throws IOException {
		// TODO Auto-generated method stub

		// Read data from Proerties File
		FileInputStream fis = new FileInputStream("./src/main/resources/commondata.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String browser = pobj.getProperty("browser");
		String URL = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");
		
		// Cross-Browser Testing and Run Time Polymorphism
		WebDriver driver;
		if(browser.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
	        Map<String, Object> prefs = new HashMap<>();
	        prefs.put("profile.password_manager_leak_detection", false);
	        options.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(options);
		} else if(browser.equals("edge")) {
			driver = new EdgeDriver();
		} else if(browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
		
		LoginPage lp = new LoginPage(driver);
		lp.login(URL, USERNAME, PASSWORD);
		
		ProductsPage pp = new ProductsPage(driver);
		pp.addProductToCart();
		
		CartPage cp = new CartPage(driver);
		cp.verifyProductName();
		
		driver.quit();		
				
	}

}
