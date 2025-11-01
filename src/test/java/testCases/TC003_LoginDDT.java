package testCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

import org.testng.Assert;

public class TC003_LoginDDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class,groups="DataDriven") // getting data providers from different
																				// class
	public void verify_loginDDT(String emial, String pwd, String exp) {

		logger.info("*******Starting TC_003 _ LoginDDT********");
		// HomePage
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyaccount();
			hp.clickLogin();

			// Login
			LoginPage lp = new LoginPage(driver);
			lp.setEmailAddress(emial);
			lp.setPassword(pwd);
			lp.clickLogin();

			// MyAccountPage
			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetPage = macc.isMyAccountPageExists();

			/*
			 * Data is Valid - login success - test pass - logout 
			 * Data is Valid -- login  Failed - test fail
			 * 
			 * Data is invalide - login sucess - test fail - logout
			 * Data is invalide -- login failed - test pass
			 */

			if (exp.equalsIgnoreCase("Valide")) {
				if (targetPage == true) {
					macc.clickLogout();
					Assert.assertTrue(true);

				} else {

					Assert.assertTrue(false);
				}
			}
			if (exp.equalsIgnoreCase("Invalide")) {
				if (targetPage == true) {
					macc.clickLogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}
		} catch (Exception e) {
			Assert.fail();
		}
		
		logger.info("*******Finished  TC_003 _ LoginDDT********");

	}
}
