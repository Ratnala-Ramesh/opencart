package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
        WebDriver driver;
	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath="//*[@name='email']") WebElement Email;
	@FindBy(xpath="//*[@name='password']") WebElement password;
	@FindBy(xpath="//input[@value='Login']") WebElement loginBtn;
	public void EmailMethod(String email) {
		Email.sendKeys(email);
	}
	public void passwordMethod(String Password) {
		password.sendKeys(Password);
	}
	public void loginBtnMethod() {
		loginBtn.click();
	}

}
