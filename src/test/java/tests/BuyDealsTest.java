package tests;

import base.BaseTest;
import listeners.TestListener;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;

/**
 * Created by ken.dsilva on 09/06/17.
 */
@Listeners({TestListener.class})
public class BuyDealsTest extends BaseTest {
    @Test
    public void successfulDealBuyTest(){
        driver.get(data.getUrl());

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.enterUsername(data.getUsername())
                 .enterPassword(data.getPassword())
                 .submit();

        DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
        Assert.assertEquals(dashboardPage.confirmOnDashboardPage(),data.getLoggedInMessage());
        dashboardPage.clickOnCurrentDeals();

        CurrentDealsPage currentDealsPage = PageFactory.initElements(driver, CurrentDealsPage.class);
        currentDealsPage.inputDealAmount(data.getDealAmount())
                        .clickOnBuyNowButton();

        DealInterstitialOverlayPage dealInterstitialOverlayPage = PageFactory.initElements(driver, DealInterstitialOverlayPage.class);
        dealInterstitialOverlayPage.clickOnProceedButton();

        AgreementSummaryPage agreementSummaryPage = PageFactory.initElements(driver, AgreementSummaryPage.class);
        agreementSummaryPage.selectAcceptCheckbox()
                            .selectRiskCheckbox()
                            .clickConfirmButton()
                            .selectVirtualPadOption()
                            .signatureOnVirtualPad()
                            .acceptAndSendOtp()
                            .inputOtpAndVerify();

        Assert.assertEquals(currentDealsPage.getDealConfirmationMessage(),data.getSuccessfulDealMessage());
        currentDealsPage.logoutUser();
    }

    @Test
    public void invalidAadhaarDealBuyTest(){
        driver.get(data.getUrl());

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.enterUsername(data.getUsername())
                 .enterPassword(data.getPassword())
                 .submit();

        DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
        Assert.assertEquals(dashboardPage.confirmOnDashboardPage(),data.getLoggedInMessage());
        dashboardPage.clickOnCurrentDeals();

        CurrentDealsPage currentDealsPage = PageFactory.initElements(driver, CurrentDealsPage.class);
        currentDealsPage.inputDealAmount(data.getDealAmount())
                        .clickOnBuyNowButton();

        DealInterstitialOverlayPage dealInterstitialOverlayPage = PageFactory.initElements(driver, DealInterstitialOverlayPage.class);
        dealInterstitialOverlayPage.clickOnProceedButton();

        AgreementSummaryPage agreementSummaryPage = PageFactory.initElements(driver, AgreementSummaryPage.class);
        agreementSummaryPage.selectAcceptCheckbox()
                            .selectRiskCheckbox()
                            .clickConfirmButton()
                            .enterInvalidAadharNumber()
                            .acceptAndSendOtp();

        Assert.assertEquals(agreementSummaryPage.getInvalidAadhaarErrorMessage(),data.getInvalidAadhaarErrorMessage());
        agreementSummaryPage.closeAgreementWindow();
        currentDealsPage.logoutUser();
    }

    @Test
    public void invalidOtpDealBuyTest(){
        driver.get(data.getUrl());

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.enterUsername(data.getUsername())
                 .enterPassword(data.getPassword())
                 .submit();

        DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
        Assert.assertEquals(dashboardPage.confirmOnDashboardPage(),data.getLoggedInMessage());
        dashboardPage.clickOnCurrentDeals();

        CurrentDealsPage currentDealsPage = PageFactory.initElements(driver, CurrentDealsPage.class);
        currentDealsPage.inputDealAmount(data.getDealAmount())
                        .clickOnBuyNowButton();

        DealInterstitialOverlayPage dealInterstitialOverlayPage = PageFactory.initElements(driver, DealInterstitialOverlayPage.class);
        dealInterstitialOverlayPage.clickOnProceedButton();

        AgreementSummaryPage agreementSummaryPage = PageFactory.initElements(driver, AgreementSummaryPage.class);
        agreementSummaryPage.selectAcceptCheckbox()
                .selectRiskCheckbox()
                .clickConfirmButton()
                .selectVirtualPadOption()
                .signatureOnVirtualPad()
                .acceptAndSendOtp()
                .inputInvalidOtp();

        Assert.assertEquals(agreementSummaryPage.invalidOtpMessage(),data.getOtpVerificationFailedMessage());
        agreementSummaryPage.closeAgreementWindow();
        currentDealsPage.logoutUser();
    }
}
