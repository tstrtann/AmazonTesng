package Amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Product {
	WebDriver driver;
	
	@FindBy(xpath = "(//input[@id='add-to-cart-button'])[1]") WebElement addToCart;
	@FindBy(xpath = "o") WebElement noThanks;
	@FindBy(xpath = "//*[contains(text(),'Proceed to checkout')]") WebElement proceedToCheckout;
	
	public Product(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void addToCartClick() {
		addToCart.click();
	}
	
	public void noThanksClick() {
		noThanks.click();
	}
	
	public void proceedToCheckout() {
		proceedToCheckout.click();
	}

}
