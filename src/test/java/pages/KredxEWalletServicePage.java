package pages;

import base.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10000);
            wait.until(ExpectedConditions.visibilityOf(payButton));
            System.out.println("On payment gateway page");
        }
        catch (NoSuchElementException e){
            System.out.println("No element found");
        }
    }
}
