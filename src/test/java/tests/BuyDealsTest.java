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
 * Created by ken.dsilva on 09/06/17.
 */
@Listeners({TestListener.class})
public class BuyDealsTest extends BaseTest {
    @Test
    public void successfulBuyDealTest(){
        driver.get(data.getUrl());
        driver.manage().timeouts().implicitlyWait(config.getTimeout(), TimeUnit.SECONDS);

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
//                          .dismissHelpPopup()    //the pop-up occurs at random times
                            .clickConfirmButton()
                            .selectVirtualPadOption()
                            .signatureOnVirtualPad()
                            .clickAfterSign();

        PaymentsPage paymentsPage = PageFactory.initElements(driver, PaymentsPage.class);
        paymentsPage.typeRemarks()
                    .clickPay()
                    .clickOnConfirmPay();

        Assert.assertEquals(currentDealsPage.successfulDealConfirmation(),data.getSuccessfulDealMessage());
        dashboardPage.clickOnDashBoard()
                     .logoutUser();
    }
}
