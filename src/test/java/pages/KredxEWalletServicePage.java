package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by ken.dsilva on 03/06/17.
 */
public class KredxEWalletServicePage extends BasePage {

    @FindBy(id = "payBtn")
    WebElement payButton;

    @FindBy(id = "remarks")
    WebElement remarks;

    @FindBy(id = "paymentGateway1")
    WebElement radioButtonTPSL;

    public KredxEWalletServicePage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on TPSL radio button")
    public KredxEWalletServicePage selectTPSLRadioButton(){
        radioButtonTPSL.click();
        return this;
    }

    @Step("input remarks")
    public KredxEWalletServicePage inputRemarks(String inputRemarks){
        remarks.click();
        remarks.sendKeys(inputRemarks);
        return this;
    }

    @Step("click on submit button")
    public void clickOnSubmitButton(){
        payButton.click();
    }

    @Step("waiting for Paymenent gateway page to load")
    public void waitForPaymentGatewayPage(){
        waitForElement(payButton);
        System.out.println("on payment gateway page");
    }
}
