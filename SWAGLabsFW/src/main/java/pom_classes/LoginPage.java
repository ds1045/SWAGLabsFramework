package pom_classes;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	// Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	// Locate all the WebElements
	@FindBy(id = "user-name")
	private WebElement USERNAME;
	
	@FindBy(id = "password")
	private WebElement PASSWORD;
	
	@FindBy(id = "login-button")
	private WebElement LOGINBTN;
	
	// Public Getter Methods
	public WebElement getUSERNAME() {
		return USERNAME;
	}
	
	public WebElement getPASSWORD() {
		return PASSWORD;
	}
	
	public WebElement getLOGINBTN() {
		return LOGINBTN;
	}
	
	// Business Logic
	public void login(String url, String username, String password) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);
		USERNAME.sendKeys(username);
		PASSWORD.sendKeys(password);
		LOGINBTN.click();
	}
}
