package testNG;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot_WebPage {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.com/");
		Thread.sleep(2000);
		
		// 1. Type Casting the driver instance to TakesScreenshot interface type
		TakesScreenshot ts = (TakesScreenshot) driver;

		// 2. Take screenshot and store in a temporary location
		File src = ts.getScreenshotAs(OutputType.FILE);

		// 3. Create a permanent location
		File dest = new File("./screenshots/webPage.png");

		// 4. Copy screenshot from temporary location to permanent location.
		FileHandler.copy(src, dest);
		
		Thread.sleep(2000);
		driver.quit();
	}

}
