package Amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class Results {	
	WebDriver driver;
	
	public int resultsToVerify() {
		int elementSize = driver.findElements(By.xpath("//span[text()='1-16 of over 20,000 results for']")).size();
		return elementSize;
	}
	
	public Results(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//span[contains(text(),'2020 Apple MacBook Air Laptop: Apple M1 Chip')])[1]") WebElement appleMac;
	
	public void computerToClick() {
		appleMac.click();
	}
	
}
