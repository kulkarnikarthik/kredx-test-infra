package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by ken.dsilva on 03/06/17.
 */
public class Tender247NetBankingPage extends BasePage {

    @FindBy(xpath = "//div[contains(text(),'Tender247')]")
    WebElement netBankingPageHeader;

    @FindBy(id = "selectNetBank")
    WebElement selectDropdown;

    @FindBy(xpath = "//option[contains(text(),'TEST BANK')]")
    WebElement selectTestBank;

    @FindBy(xpath = "//input[@id='net_banking_submit']")
    WebElement payNowButton;

    public Tender247NetBankingPage(WebDriver driver) {
        super(driver);
    }

    @Step("verify on Netbanking page")
    public void verifyOnNebankingPage(){
        WebDriverWait wait = new WebDriverWait(driver, 10000);
        wait.until(ExpectedConditions.visibilityOf(netBankingPageHeader));
        System.out.println("On netbanking page");
    }

    @Step("Select test bank option")
    public Tender247NetBankingPage selectTestBankOption(){
        selectDropdown.click();
        selectTestBank.click();
        return this;
    }

    @Step("click on pay now button")
    public void clickOnSubmitButton(){
        payNowButton.click();
    }
}
