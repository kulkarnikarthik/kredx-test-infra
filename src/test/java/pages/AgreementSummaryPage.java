package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Abc on 4/14/2017.
 */
public class AgreementSummaryPage extends BasePage {

    @FindBy(id="checkbox-accept")
    WebElement acceptCheckbox;

    @FindBy(id="checkbox-risks")
    WebElement riskCheckbox;

    @FindBy(xpath="//button[contains(text(),'Click here to sign')]")
    WebElement confirmButton;

    @FindBy(xpath="//div[@class='m-signature-pad--body']")
   public static WebElement signatureTextArea;

    @FindBy(xpath = "//button[contains(text(),'Accept and Send OTP')]")
    WebElement afterSignButton;

    @FindBy(xpath = "//input[@value = 'VIRTUAL-PAD']")
    WebElement virtualPadOption;

    @FindBy(xpath = "//div[@id='root']/div/div[2]/button")
    WebElement dismissPopup;

    @FindBy(xpath = "//input[@placeholder = 'Enter OTP']")
    WebElement inputOtp;

    @FindBy(xpath = "//button[contains(text(),'Verify')]")
    WebElement verifyOtp;

    public AgreementSummaryPage(WebDriver driver) {
        super(driver);
    }

    @Step("Select T&C checkbox")
    public AgreementSummaryPage selectAcceptCheckbox(){
        waitForElement(acceptCheckbox); //added new wait
        acceptCheckbox.click();
        return this;
    }

    @Step("Select risk involved checkbox")
    public AgreementSummaryPage selectRiskCheckbox(){
        riskCheckbox.click();
        return this;
    }

    @Step("Click on Select here to sign button")
    public AgreementSummaryPage clickConfirmButton(){
        driver.switchTo().defaultContent();
        waitForElement(confirmButton);
        confirmButton.click();
        return this;
    }

    @Step("Click on accept to proceed to payment button")
    public AgreementSummaryPage clickAfterSign(){
        waitForElement(afterSignButton);
        afterSignButton.click();
        return this;
    }

    @Step("Selecting virtual pad option")
    public AgreementSummaryPage selectVirtualPadOption(){
        waitForElement(virtualPadOption);
        virtualPadOption.click();
        return this;
    }

    @Step("Dismissing help pop up")
    public AgreementSummaryPage dismissHelpPopup(){
        WebDriverWait wait = new WebDriverWait(driver, 10000);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(1));
        driver.switchTo().frame(1);
        dismissPopup.click();
        return this;
    }

    @Step("Signature on virtual pad")
    public AgreementSummaryPage signatureOnVirtualPad(){
        Actions builder = new Actions(driver);
        Action drawAction = builder.moveToElement(AgreementSummaryPage.signatureTextArea,135,15) //start points x axis and y axis.
                .clickAndHold().moveByOffset(165,15).moveByOffset(185,15)
                .build();
        drawAction.perform();
        return this;
    }

    @Step("input and verify OTP")
    public AgreementSummaryPage inputOtpAndVerify(){
        inputOtp.sendKeys(data.getOtp());
        verifyOtp.click();
        return this;
    }
}
