package tests;

import base.BaseTest;
import listeners.TestListener;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.VendorSignupPage;

/**
 * Created by ken.dsilva on 17/06/17.
 */
@Listeners({TestListener.class})
public class VendorSignupTest extends BaseTest {
    @Test
    public void successfulVendorSignupTest(){
        driver.get(data.getVendorUrl());
        VendorSignupPage vendorSignupPage = PageFactory.initElements(driver,VendorSignupPage.class);
        vendorSignupPage.enterName()
                        .enterOrganisationName()
                        .enterEmailId()
                        .enterMobileNumber()
                        .enterPassword()
                        .clickOnSubmitButton();

        Assert.assertEquals(vendorSignupPage.firstStepValidationMessage(),data.getSuccessfulFirstStepSignupMessage());
        vendorSignupPage.clickOnLogout();
    }

    @Test
    public void invalidEmailVendorSignupTest(){
        driver.get(data.getVendorUrl());
        VendorSignupPage vendorSignupPage = PageFactory.initElements(driver,VendorSignupPage.class);
        vendorSignupPage.enterName()
                        .enterOrganisationName()
                        .enterInvalidEmailId()
                        .enterMobileNumber();

        Assert.assertEquals(vendorSignupPage.getInvalidEmailMessage(),data.getInvalidSignupEmailMessage());
    }

    @Test
    public void invalidMobileNumberVendorSignupTest(){
        driver.get(data.getVendorUrl());
        VendorSignupPage vendorSignupPage = PageFactory.initElements(driver,VendorSignupPage.class);
        vendorSignupPage.enterName()
                        .enterOrganisationName()
                        .enterInvalidMobile()
                        .enterEmailId();

        Assert.assertEquals(vendorSignupPage.getInvalidMobileErrorMessage(),data.getInvalidMobileErrorMessage());
    }

    @Test
    public void insufficientCharacterPasswordVendorSignupTest(){
        driver.get(data.getVendorUrl());
        VendorSignupPage vendorSignupPage = PageFactory.initElements(driver,VendorSignupPage.class);
        vendorSignupPage.enterName()
                        .enterOrganisationName()
                        .enterEmailId()
                        .inputInsufficientCharacterPassword()
                        .enterMobileNumber();

        Assert.assertEquals(vendorSignupPage.getInsufficientCharacterPasswordErrorMessage(),data.getInsufficientCharactersErrorMessage());
    }

    @Test
    public void emptyOrganisationFieldVendorSignUpTest(){
        driver.get(data.getVendorUrl());
        VendorSignupPage vendorSignupPage = PageFactory.initElements(driver,VendorSignupPage.class);
        vendorSignupPage.enterName()
                        .enterEmailId()
                        .enterMobileNumber()
                        .clickOnOrganisationField()
                        .enterPassword();

        Assert.assertEquals(vendorSignupPage.emptyOrganisationFieldErrorMessage(),data.getEmptyOrganisationError());
    }
}
