package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by ken.dsilva on 09/06/17.
 */
public class DealInterstitialOverlayPage extends BasePage {

    @FindBy(xpath = "//button[contains(text(),'Proceed')]")
    WebElement proceedButton;

    @FindBy(xpath = "//div[contains(text(),'*Expected Returns')]")
    WebElement expectedReturnsText;

    public DealInterstitialOverlayPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on Procced button")
    public void clickOnProceedButton(){
        waitForElement(expectedReturnsText);
        proceedButton.click();
    }
}
