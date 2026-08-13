package pom_classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	WebDriver driver;
	
	// Constructor
	public ProductsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	// Locate all the WebElements	
	@FindBy(linkText = "Sauce Labs Backpack")
	private WebElement productName;
	
	@FindBy(xpath = "//a[.='Sauce Labs Backpack']/../..//button[.='Add to cart']")
	private WebElement addToCartBtn;
	
	@FindBy(className = "shopping_cart_link")
	private WebElement cart;
	
	@FindBy(className = "product_sort_container")
	private WebElement dropdown;	
	
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
	
	public WebElement getAddToCartBtn() {
		return addToCartBtn;
	}
	
	public WebElement getCart() {
		return cart;
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
	
	public WebElement getDropdown() {
		return dropdown;
	}
	
	// Business Logic
	public void addProductToCart() {
		addToCartBtn.click();
		cart.click();
	}
	
	public void logout() {
		menu.click();
		logoutLink.click();
	}
}
