package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Abc on 4/15/2017.
 */
public class PaymentsPage extends BasePage {

    @FindBy(id="remarks")
    WebElement remarks;

    @FindBy(id = "payBtn1")
    public static WebElement payButton;

    @FindBy(id = "payBtn")
    WebElement confirmPay;

    public PaymentsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Typing remarks in text box")
    public PaymentsPage typeRemarks(){
        remarks.sendKeys("paid for the deal");
        return this;
    }

    @Step("Click on pay button")
    public PaymentsPage clickPay(){
        payButton.click();
        return this;
    }

    public void clickOnConfirmPay(){
        confirmPay.click();
    }

}
