package tests;

import base.BaseTest;
import listeners.TestListener;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BusinessSignUpPage;
import pages.LoginPage;

/**
 * Created by ken.dsilva on 16/06/17.
 */
@Listeners({TestListener.class})
public class VendorSignupTest extends BaseTest {
    @Test
    public void successfulBusinessSignupTest(){
        driver.get(data.getUrl());
        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPage.clickOnBusinessSignuplink();

        BusinessSignUpPage businessSignUpPage = PageFactory.initElements(driver, BusinessSignUpPage.class);
        businessSignUpPage.enterName()
                          .enterEmail()
                          .enterMobileNumber()
                          .enterOrganisationName()
                          .clickOnSubmitButton();

        Assert.assertEquals(businessSignUpPage.getsuccessfulSignupMessage(),data.getSucessfulSignupText());
    }
}
