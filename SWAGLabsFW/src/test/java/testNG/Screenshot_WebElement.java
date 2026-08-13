package testNG;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot_WebElement {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.amazon.com/");
		// 1. Locate the web element
		WebElement ref = driver.findElement(By.id("nav-logo-sprites"));

		// 2. Take the screen shot of the web element and store in a temporary location
		File src = ref.getScreenshotAs(OutputType.FILE);

		// 3. Create a permanent location
		File dest = new File("./screenshots/webElement.png");

		// 4. Copy screenshot from temporary location to permanent location
		FileHandler.copy(src, dest);
		
		Thread.sleep(2000);
		driver.quit();
	}

}
