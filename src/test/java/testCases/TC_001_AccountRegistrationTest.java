package testCases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
	@Test(groups= {"sanity","Master"})
		public void verify_account_registration() {
		HomePage hm=new HomePage(driver);
		try {
		logger.info("account clik");
		hm.clickmyaccount();
		logger.info("register account");
		hm.Registeraccount();
        RegistrationPage regpage=new RegistrationPage(driver);
		
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
		regpage.setTelephone(randomeNumber());
		
		String password=randomAlphaNumeric();
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		String confmsg=regpage.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		logger.info("the test is passed");
		}
		catch(Exception e) {
			logger.error("Test failed"+e.getMessage());
			Assert.fail("Test failed"+e.getMessage());
		}
		finally {
			logger.info("TC_001_AccountRegistrationTest is completed");
		}
	}

}
