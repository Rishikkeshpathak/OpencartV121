package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

    @Test(groups={"Sanity","Master"})
    public void verfiy_login() {
        logger.info("********************Staring TC002 Login Test*************");
        
        try {
            //HomePage 
            HomePage hp = new HomePage(driver);
            hp.clickMyaccount();
            hp.clickLogin();
            
            //Login
            LoginPage lp = new LoginPage(driver);
            lp.setEmailAddress(p.getProperty("email"));
            lp.setPassword(p.getProperty("password"));
            lp.clickLogin();
            
            //MyAccountPage 
            MyAccountPage macc = new MyAccountPage(driver);
            boolean targetPage = macc.isMyAccountPageExists();
            Assert.assertEquals(targetPage, true);
        }
        catch(Exception e) {
            Assert.fail();
        }
        logger.info("********************Finished  TC002 Login Test*************");
    }
}
