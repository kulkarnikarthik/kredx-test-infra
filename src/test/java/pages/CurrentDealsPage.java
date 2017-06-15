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

    @FindBy(xpath = "//div[div[div[div[h5[contains(text(),'Sv Industries 2')]]]]]/div[3]/div/div[2]/div/div/div/input")
    WebElement svIndustriesDealAmount;

    @FindBy(xpath = "//div[div[div[div[h5[contains(text(),'Sv Industries 2')]]]]]/div[3]/div/div[2]/div[2]/div/button")
    WebElement svIndustriesBuyNowButton;

    @FindBy(xpath = "//div[div[div[h5[contains(text(),'Sv Industries 2')]]]]/div[2]/a/button")
    WebElement svIndustriesShowDealsButton;

    @FindBy(xpath = "//button[contains(text(),'Buy Now')]")
    WebElement onCurrentDealsPageText;

    @FindBy(xpath = "//strong[contains(text(),'Transaction Successful')]")
    WebElement transactionSuccessfulText;

    @FindBy(xpath = "//div[@class = 'navbar-account-body']/div/span")
    WebElement clickOnProfileDropdown;

    @FindBy(xpath = "//li[contains(text(),'LOG OUT')]")
    WebElement logoutButton;

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
        svIndustriesDealAmount.sendKeys(amount);
        return this;
    }

    @Step("Click on Ent-Name Buy now")
    public void clickOnBuyNowButton(){
        svIndustriesBuyNowButton.click();
    }

    @Step("Successful deal confirmation")
    public String getDealConfirmationMessage(){
        return transactionSuccessfulText.getText();
    }

    @Step("User logged out")
    public CurrentDealsPage logoutUser(){
        WebDriverWait wait = new WebDriverWait(driver, 10000);
        wait.until(ExpectedConditions.elementToBeClickable(clickOnProfileDropdown));
        clickOnProfileDropdown.click();

        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        logoutButton.click();
        return this;
    }
}