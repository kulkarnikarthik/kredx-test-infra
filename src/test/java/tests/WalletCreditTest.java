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

//    @Test
//    public void successfulWalletCredit(){
//        driver.get(data.getUrl());
//        driver.manage().timeouts().implicitlyWait(config.getTimeout(), TimeUnit.SECONDS);
//        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
//        loginPage.enterUsername(data.getUsername())
//                .enterPassword(data.getPassword())
//                .submit();
//
//        DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
//        Assert.assertEquals(dashboardPage.confirmOnDashboardPage(),data.getLoggedInMessage());
//
//        ManageFundsPage manageFundsPage = PageFactory.initElements(driver, ManageFundsPage.class);
//        manageFundsPage.goToManageFundsPage()
//                       .clickOnAddFundsButton()
//                       .addAmount(data.getAmount())
//                       .clickOnNetbankingOption();
//
//        KredxEWalletServicePage paymentGatewayPage = PageFactory.initElements(driver, KredxEWalletServicePage.class);
//        paymentGatewayPage.waitForPaymentGatewayPage();
//        paymentGatewayPage.selectTPSLRadioButton()
//                          .inputRemarks(data.getInputRemark())
//                          .clickOnSubmitButton();
//
//        Tender247NetBankingPage tender247NetBankingPage = PageFactory.initElements(driver, Tender247NetBankingPage.class);
//        tender247NetBankingPage.verifyOnNebankingPage();
//        tender247NetBankingPage.selectTestBankOption()
//                               .clickOnSubmitButton();
//
//        TpslLoginPage tpslLoginPage = PageFactory.initElements(driver,TpslLoginPage.class);
//        tpslLoginPage.verifyOnTpslLandingPage();
//        tpslLoginPage.inputName(data.getTpslLogin())
//                     .inputPassword(data.getTpslPassword())
//                     .clickOnSubmitButton();
//
//        TpslPaymentConfirmationPage tpslPaymentConfirmationPage = PageFactory.initElements(driver,TpslPaymentConfirmationPage.class);
//        tpslPaymentConfirmationPage.onTpslPaymentConfirmaitonPage();
//        tpslPaymentConfirmationPage.confirmTransaction();
//
//        dashboardPage.confirmOnDashboardPage();
//        Assert.assertEquals(dashboardPage.successfulTransactionMessage(),data.getSuccessfulWalletTopUpMessage(),"Credit/top up to wallet failed");
//        dashboardPage.logoutUser();
//    }

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
