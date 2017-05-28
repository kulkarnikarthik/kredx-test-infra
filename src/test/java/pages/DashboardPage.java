package pages;

import base.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public void clickDeals() {
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

    public DashboardPage logoutUser(){
        clickOnProfileDropdown.click();
        logoutButton.click();
        return this;
    }


}
