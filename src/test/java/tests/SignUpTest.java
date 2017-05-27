package tests;

import base.BaseTest;
import listeners.TestListener;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.FinancierSignUpPage;
import pages.LoginPage;

/**
 * Created by ken.dsilva on 26/05/17.
 */
@Listeners({TestListener.class})
public class SignUpTest extends BaseTest {

    @Test
    public void successfulSignUp(){

        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPage.goToSignUpAsInvestorPage();

        FinancierSignUpPage financierSignUpPage = PageFactory.initElements(driver,FinancierSignUpPage.class);
        financierSignUpPage.enterUserName()
                           .enterMobileNumber()
                           .enterEmailId(data.getEmailId())
                           .enterPassword()
                           .selectCheckBox()
                           .clickOnSubmitButton();

//        Assert.assertTrue(financierSignUpPage.onAccountCreatedPage(),"User failed create account");
//        Assert.assertEquals(financierSignUpPage.onAccountCreatedPage(),true,"User failed create account");
        Assert.assertEquals(financierSignUpPage.onAccountCreatedPage(),true,"User failed create account");
    }

}
