package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Abc on 4/14/2017.
 */
public class DashboardPage extends BasePage {
    @FindBy(xpath = "//a[@href='/financier/dashboard/deals']")
    WebElement dealsLink;

    @FindBy(linkText = "Dashboard")
    WebElement dashboardIcon;

    @FindBy(xpath = "//div[@class = 'navbar-account-body']/div/span")
    WebElement clickOnProfileDropdown;

    @FindBy(xpath = "//li[contains(text(),'LOG OUT')]")
    WebElement logoutButton;

    @FindBy(linkText = "Add")
    WebElement addCurrency;

    @FindBy(xpath = "//h1[contains(text(),'Congratulations')]")
    WebElement successfulTransactionMessage;

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnCurrentDeals() {
        dealsLink.click();
    }

    public String confirmOnDashboardPage(){
        waitForElement(dashboardIcon);
        return dashboardIcon.getText();
    }

    @Step("User logged out")
    public DashboardPage logoutUser(){
        waitForElement(clickOnProfileDropdown);
        clickOnProfileDropdown.click();

        waitForElement(logoutButton);
        logoutButton.click();
        return this;
    }

    @Step("Go to accounts page")
    public ManageFundsPage clickOnAddButton(){
        addCurrency.click();;
        return PageFactory.initElements(driver, ManageFundsPage.class);
    }

    @Step("successful transaction message")
    public String successfulTransactionMessage(){
        waitForElement(successfulTransactionMessage);
        return successfulTransactionMessage.getText();
    }

    @Step("click on dashboard icon")
    public DashboardPage clickOnDashBoard(){
        dashboardIcon.click();
        return this;
    }
}
