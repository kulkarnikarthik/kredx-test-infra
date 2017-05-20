package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Abc on 4/15/2017.
 */
public class PaymentsPage extends BasePage {

    @FindBy(id="remarks")
    WebElement remarks;

    @FindBy(xpath="//button[contains(.,'Pay')]")
    public static WebElement payButton;

    public PaymentsPage(WebDriver driver) {
        super(driver);
    }


    public void  typeRemarks(){
        remarks.sendKeys("paid for the deal");
    }


    public void clickPay(){
        payButton.click();
    }
}
