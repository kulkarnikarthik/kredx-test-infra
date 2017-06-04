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
public class TpslPaymentConfirmationPage extends BasePage {

    @FindBy(xpath = "//input[@id='button']")
    WebElement submitButton;

    @FindBy(xpath = "//span[contains(text(),'TPSL BANKING SYSTEM')]")
    WebElement tpslConfirmationHeader;

    public TpslPaymentConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public void confirmTransaction(){
        submitButton.click();
    }

    @Step("Verification of TPSL Payment Confirmation page landing")
    public void onTpslPaymentConfirmaitonPage(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10000);
            wait.until(ExpectedConditions.visibilityOf(tpslConfirmationHeader));
            System.out.println("On TPSL Payment Confirmation page");
        }
        catch (NoSuchElementException e){
            System.out.println("No element found");
        }
    }
}
