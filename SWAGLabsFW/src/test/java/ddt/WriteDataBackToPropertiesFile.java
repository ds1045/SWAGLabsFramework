package ddt;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WriteDataBackToPropertiesFile {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		// Inserting data to Properties File
		Properties pobj1 = new Properties();
		pobj1.setProperty("url", "https://www.saucedemo.com/");
		pobj1.setProperty("username", "standard_user");
		pobj1.setProperty("password", "secret_sauce");

		FileOutputStream fos = new FileOutputStream("./src/main/resources/commondata2.properties");
		pobj1.store(fos, "CommonData");

		// Fetching data from Properties File
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		FileInputStream fis = new FileInputStream("./src/main/resources/commondata2.properties");
		Properties pobj2 = new Properties();
		pobj2.load(fis);
		String URL = pobj2.getProperty("url");
		String USERNAME = pobj2.getProperty("username");
		String PASSWORD = pobj2.getProperty("password");
		
		driver.get(URL);
		Thread.sleep(2000);
		WebElement username = driver.findElement(By.id("user-name"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginBtn = driver.findElement(By.id("login-button"));
		username.sendKeys(USERNAME);
		password.sendKeys(PASSWORD);
		Thread.sleep(2000);
		loginBtn.click();

	}

}
