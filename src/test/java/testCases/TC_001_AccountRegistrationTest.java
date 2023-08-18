package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;

public class TC_001_AccountRegistrationTest extends BaseClass {

    @Test
    public void test_Account_Registration() {
        logger.info("Starting Account Registration Test*************");

        try {

            HomePage hp = new HomePage(driver);
            RegistrationPage rp = new RegistrationPage(driver);

            logger.info("Clicked on MyAccount");
            hp.clickMyAccount();
            logger.info("Clicked on Register");
            hp.clickRegister();
            logger.info("Setting FirstName");
            rp.setFirstName(randomAlphabets());
            logger.info("Setting LastName");
            rp.setLastName(randomAlphabets());
            logger.info("Setting Email");
            rp.setEmail(randomAlphabets() + "@gmail.com");
            logger.info("Setting Password");
            rp.setPassword(randomAlphaNumeric());
            logger.info("Clicking on Subscribe");
            rp.clickSubscribe();
            logger.info("Clicking on Agree");
            rp.clickAgree();
            logger.info("Clicking on Continue");
            rp.clickContinue();

        }
        catch (Exception e)
        {
            Assert.fail();
        }





    }


}
