package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class Tc_002_LoginTest extends BaseClass{
	@Test(groups= {"Regression","Master"})
	public void verifyLogin() {
		try {
		logger.info("Login test Started");
		HomePage hp=new HomePage(driver);
		logger.info("homePage is opened");
		hp.clickmyaccount();
		hp.Loginaccount();
		logger.info("Login Page Strted");
		LoginPage lp=new LoginPage(driver);
		lp.EmailMethod(p.getProperty("email"));
		lp.passwordMethod(p.getProperty("password"));
		lp.loginBtnMethod();
		logger.info("my account page is started");
		MyAccountPage mp=new MyAccountPage(driver);
		Boolean page=mp.MyAcccountMethod();
		mp.LogoutMethod();
		Assert.assertEquals(page,true,"fail");
		}
		catch(Exception e) {
			Assert.fail();
			logger.info("test is failed");
		}
		finally {
			logger.info("login teste is exuceted");
		}
		
	}

}
