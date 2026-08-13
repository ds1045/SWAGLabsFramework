package testscripts_hardcoding;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AddProductToCartTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.password_manager_leak_detection", false);
        options.setExperimentalOption("prefs", prefs);
        
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.saucedemo.com/");
		WebElement username = driver.findElement(By.id("user-name"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginBtn = driver.findElement(By.id("login-button"));
		username.sendKeys("standard_user");
		password.sendKeys("secret_sauce");
		loginBtn.click();
		
		String expData = "Sauce Labs Backpack"; // Product Name
		WebElement addToCartBtn = driver.findElement(By.xpath("//a[.='"+expData+"']/../..//button[.='Add to cart']"));
		addToCartBtn.click();
		
		WebElement cartLink = driver.findElement(By.className("shopping_cart_link"));
		cartLink.click();
		
		String actData = driver.findElement(By.className("inventory_item_name")).getText();
		if(actData.contains(expData)) 
		{
			System.out.println("Product added successfully to the cart!");
			WebElement menu = driver.findElement(By.xpath("//button[.='Open Menu']"));
			menu.click();
			WebElement logoutLink = driver.findElement(By.linkText("Logout"));
			logoutLink.click();
		}
		else
		{
			System.out.println("Test Case Failed!");
		}
		
		driver.quit();		
				
	}

}
