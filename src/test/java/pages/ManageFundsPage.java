package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by ken.dsilva on 03/06/17.
 */
public class ManageFundsPage extends BasePage {

    @FindBy(linkText = "Manage Funds")
    WebElement goToManageFunds;

    @FindBy(xpath = "//input[@type = 'number']")
    WebElement inputAmount;

    @FindBy(linkText = "Add Funds")
    WebElement addFundsButton;

    @FindBy(xpath = "//button[contains(text(),'Net banking')]")
    WebElement clickOnNetBankingButton;

    @FindBy(xpath = ".//div[contains(text(),'Please enter a valid amount for netbanking transactions')]")
    WebElement alphaNumericErrorMessageOnInvalidAmount;

    public ManageFundsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on Manage Funds")
    public ManageFundsPage goToManageFundsPage(){
        goToManageFunds.click();
        return this;
    }

    @Step("Add amount in input field")
    public ManageFundsPage addAmount(String amount){
        inputAmount.click();
        inputAmount.sendKeys(amount);
        return this;
    }

    @Step("Click on add funds")
    public ManageFundsPage clickOnAddFundsButton(){
        addFundsButton.click();
        return this;
    }

    @Step("Click on netbanking button")
    public ManageFundsPage clickOnNetbankingOption(){
        clickOnNetBankingButton.click();
        return this;
    }

    @Step("Input alphanumeric text in top field")
    public ManageFundsPage inputAplphanumeicTextInTopup(){
        inputAmount.click();
        inputAmount.sendKeys(generateRandomName());
        return this;
    }

    @Step("Alphanumeric error message")
    public String errorMessageOnInvalidInputAmount(){
        return alphaNumericErrorMessageOnInvalidAmount.getText();
    }
}
