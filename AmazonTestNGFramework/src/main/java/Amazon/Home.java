package Amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.Advice.This;

public class Home {
	
	
	@FindBy(id = "twotabsearchtextbox") WebElement searchField;
	@FindBy(id = "nav-search-submit-button") WebElement searchBtn;
	
	
	WebDriver driver;
	
	public Home(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void searchFieldSendKeys(String searchValue) {
		searchField.sendKeys(searchValue);
	}
	
	public void searchBtnClick() {
		searchBtn.click();
	}

}
