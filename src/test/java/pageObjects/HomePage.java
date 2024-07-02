package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	WebDriver driver;
	public HomePage(WebDriver driver){
		super(driver);
	}
	@FindBy(xpath="//*[@class='caret']") WebElement lnkmyaccount;
	@FindBy(xpath="//a[normalize-space()='Register']") WebElement Register;
	@FindBy(xpath="//a[normalize-space()='Login']") WebElement Login;
	public void clickmyaccount() {
		lnkmyaccount.click();
	}
	public void Registeraccount() {
		Register.click();
	}
	public void Loginaccount() {
		Login.click();
	}

}
