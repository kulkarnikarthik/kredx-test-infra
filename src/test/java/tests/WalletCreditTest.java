package tests;

import base.BaseTest;
import listeners.TestListener;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by ken.dsilva on 03/06/17.
 */
@Listeners({TestListener.class})
public class WalletCreditTest extends BaseTest {
    @Test
    public void alphanumericTopupInputTest(){
        driver.get(data.getUrl());
        driver.manage().timeouts().implicitlyWait(config.getTimeout(), TimeUnit.SECONDS);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.enterUsername(data.getUsername())
                .enterPassword(data.getPassword())
                .submit();

        DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
        Assert.assertEquals(dashboardPage.confirmOnDashboardPage(),data.getLoggedInMessage());

        ManageFundsPage manageFundsPage = PageFactory.initElements(driver, ManageFundsPage.class);
        manageFundsPage.goToManageFundsPage()
                       .clickOnAddFundsButton()
                       .inputAplphanumeicTextInTopup()
                       .clickOnNetbankingOption();
        Assert.assertEquals(manageFundsPage.errorMessageOnInvalidInputAmount(),data.getInvalidInputErrorMessage());
        dashboardPage.logoutUser();
    }

    @Test
    public void EmptyTopupFieldTest(){
        driver.get(data.getUrl());
        driver.manage().timeouts().implicitlyWait(config.getTimeout(), TimeUnit.SECONDS);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.enterUsername(data.getUsername())
                .enterPassword(data.getPassword())
                .submit();

        DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
        Assert.assertEquals(dashboardPage.confirmOnDashboardPage(),data.getLoggedInMessage());

        ManageFundsPage manageFundsPage = PageFactory.initElements(driver, ManageFundsPage.class);
        manageFundsPage.goToManageFundsPage()
                .clickOnAddFundsButton()
                .clickOnNetbankingOption();
        Assert.assertEquals(manageFundsPage.errorMessageOnInvalidInputAmount(),data.getInvalidInputErrorMessage());
        dashboardPage.logoutUser();
    }
}
