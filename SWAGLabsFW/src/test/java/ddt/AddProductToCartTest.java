package ddt;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AddProductToCartTest {

	public static void main(String[] args) throws IOException {
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
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get(URL);
		WebElement username = driver.findElement(By.id("user-name"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginBtn = driver.findElement(By.id("login-button"));
		username.sendKeys(USERNAME);
		password.sendKeys(PASSWORD);
		loginBtn.click();
		
		// Read the Data from Excel File
		FileInputStream fis2 = new FileInputStream("./src/test/resources/testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis2);
		Sheet sh = wb.getSheet("product");
		Row row = sh.getRow(1);
		Cell cell = row.getCell(2);
		String expData = cell.getStringCellValue();
		System.out.println(expData);
		wb.close();
		
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
