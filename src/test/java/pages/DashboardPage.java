package pages;

import base.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
        WebDriverWait wait = new WebDriverWait(driver,4000);
        try{
            wait.until(ExpectedConditions.visibilityOf(dashboardIcon));
            return  dashboardIcon.getText();
        }
        catch(NoSuchElementException e){
            return "not found";
        }
    }

    @Step("User logged out")
    public DashboardPage logoutUser(){
        WebDriverWait wait = new WebDriverWait(driver, 10000);
        wait.until(ExpectedConditions.elementToBeClickable(clickOnProfileDropdown));
        clickOnProfileDropdown.click();

        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
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
        WebDriverWait wait = new WebDriverWait(driver, 10000);
        wait.until(ExpectedConditions.visibilityOf(successfulTransactionMessage));
        return successfulTransactionMessage.getText();
    }

    @Step("click on dashboard icon")
    public DashboardPage clickOnDashBoard(){
        WebDriverWait wait = new WebDriverWait(driver, 5000);
        wait.until(ExpectedConditions.elementToBeClickable(dashboardIcon));
        dashboardIcon.click();
        return this;
    }
}
