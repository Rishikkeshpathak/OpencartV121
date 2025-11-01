package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups={"Regression","Master"})
	public void verify_account_registration() {
		
		logger.info("********* Strarting Testing  TC_001 AccountRegistration*********************");
		
		try 
		{
		HomePage hp = new HomePage(driver);
		hp.clickMyaccount();
		logger.info("********Click on My accouunt info");
		hp.clickRegister();
		logger.info("********Click on My Register page info");

		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString() + "@gmail.com");
		regpage.setTelephone(randomeNumber());

		String password = randomeAlphaNumberic();
		regpage.setPassword(password);
		regpage.setConfPassword(password);
		regpage.setPolicy();
		regpage.clickContinue();
		
		logger.info("********Click on My valiadated expected messgae info");
		String confmsg = regpage.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
	
		
		}
		 catch(Exception e)
		{
			logger.error("Test Failed..");
			logger.debug("Debug logs...");
			Assert.fail();
			
		}
		logger.info("******** Finished TC_001 AccountRegistration");
	}

}
