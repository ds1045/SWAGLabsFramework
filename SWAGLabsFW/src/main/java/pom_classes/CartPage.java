package pom_classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartPage {
	WebDriver driver;
	
	// Constructor
	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	// Locate all the WebElements	
	@FindBy(className = "inventory_item_name")
	private WebElement productName;
	
	@FindBy(xpath = "//button[.='Remove']")
	private WebElement removeBtn;
	
	@FindBy(xpath = "//button[.='Continue Shopping']")
	private WebElement continueShoppingBtn;
	
	@FindBy(xpath = "//button[.='Checkout']")
	private WebElement checkoutBtn;
	
	@FindBy(xpath = "//button[.='Open Menu']")
	private WebElement menu;
	
	@FindBy(linkText = "All Items")
	private WebElement allItemsLink;
	
	@FindBy(linkText = "About")
	private WebElement aboutLink;
	
	@FindBy(linkText = "Logout")
	private WebElement logoutLink;
	
	@FindBy(linkText = "Reset App State")
	private WebElement resetAppStateLink;
	
	// Public Getter Methods
	public WebElement getProductName() {
		return productName;
	}
	
	public WebElement getRemoveBtn() {
		return removeBtn;
	}
	
	public WebElement getContinueShoppingBtn() {
		return continueShoppingBtn;
	}
	
	public WebElement getCheckoutBtn() {
		return checkoutBtn;
	}
	
	public WebElement getMenu() {
		return menu;
	}
	
	public WebElement getAllItemsLink() {
		return allItemsLink;
	}
	
	public WebElement getAboutLink() {
		return aboutLink;
	}
	
	public WebElement getLogoutLink() {
		return logoutLink;
	}
	
	public WebElement getResetAppStateLink() {
		return resetAppStateLink;
	}
	
	// Business Logic
	public void verifyProductName() {
		ProductsPage pp = new ProductsPage(driver);
		String expData = pp.getProductName().getText();
		String actData = getProductName().getText();
		Assert.assertEquals(actData, expData);
	}
}
