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

    @FindBy(xpath = "//span[@class = 'icon-dashboard']")
    WebElement dashboardIcon;

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public void clickDeals() {
        dealsLink.click();
    }

    public boolean confirmOnDashboardPage(){

        WebDriverWait wait = new WebDriverWait(driver,4000);
        try{
            wait.until(ExpectedConditions.visibilityOf(dashboardIcon));
            return  dashboardIcon.isDisplayed();
        }
        catch(NoSuchElementException e){
            return false;
        }
    }
}
