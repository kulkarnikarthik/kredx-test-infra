package tests;

import base.BaseTest;
import listeners.TestListener;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

/**
 * Created by chandanjavaregowda on 03/04/17.
 */
@Listeners({TestListener.class})
public class LoginFlowTest extends BaseTest {
    @Test(priority = 2)
    public void LoginSuccessfullyTest() {
        setUp();
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.enterUsername(data.getUsername())
                 .enterPassword(data.getPassword())
                 .submit();
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
//        Assert.assertTrue(dashboardPage.confirmOnDashboardPage(),"User failed to login");
        Assert.assertEquals(dashboardPage.confirmOnDashboardPage(),true,"User failed to login");
    }

    @Test(priority = 1)
    public void verifyNoPasswordEnteredTest(){

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.enterUsername(data.getUsername())
                .submit();

//        Assert.assertEquals(true, loginPage.noPasswordErorMessage());
        Assert.assertEquals(loginPage.noPasswordErorMessage(),true,"Error message is missing");

    }

}