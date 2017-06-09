package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by ken.dsilva on 09/06/17.
 */
public class CurrentDealsPage extends BasePage {

    @FindBy(xpath = "//div[div[div[a[@href='/financier/dashboard/deals/DEZ08LWKMN']]]]/div[3]/div/div[2]/div/div/div/input")
    WebElement entNameDealAmount;

    @FindBy(xpath = "//div[div[div[div[a[@href='/financier/dashboard/deals/DEZ08LWKMN']]]]]//div[3]/div/div[2]/div[2]/div/button")
    WebElement entNameBuyNowButton;

    @FindBy(xpath = "//a[@href = '/financier/dashboard/deals/DEZ08LWKMN']/button")
    WebElement entNameShowDealsButton;

    @FindBy(xpath = "//button[contains(text(),'Buy Now')]")
    WebElement onCurrentDealsPageText;

    @FindBy(xpath = "//strong[contains(text(),'Transaction Successful')]")
    WebElement transactionSuccessfulText;

    public CurrentDealsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Verify on Current Deals page")
    public String verifyOnCurrentDealsPage(){
        WebDriverWait wait = new WebDriverWait(driver, 5000);
        wait.until(ExpectedConditions.elementToBeClickable(onCurrentDealsPageText));
        return onCurrentDealsPageText.getText();
    }

    @Step("Enter deal amount for Ent-Name Deal")
    public CurrentDealsPage inputDealAmount(String amount){
        entNameDealAmount.sendKeys(amount);
        return this;
    }

    @Step("Click on Ent-Name Buy now")
    public void clickOnBuyNowButton(){
        entNameBuyNowButton.click();
    }

    @Step("Successful deal confirmation")
    public String successfulDealConfirmation(){
        return transactionSuccessfulText.getText();
    }
}
