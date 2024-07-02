package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//h2[normalize-space()='My Account']") WebElement MyAccount;
	@FindBy(xpath="//div[@class='list-group']//a[normalize-space()='Logout']") WebElement Logout;
	
	public Boolean MyAcccountMethod() {
		try {
			return(MyAccount.isDisplayed());
		}
		catch(Exception e) {
			return(false);
		}
		
	}
	public void LogoutMethod() {
		Logout.click();
	}

}
