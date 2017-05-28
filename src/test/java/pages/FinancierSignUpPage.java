package pages;

import base.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ken.dsilva on 26/05/17.
 */
public class FinancierSignUpPage extends BasePage {

    @FindBy(name = "name")
    WebElement enterUserName;

    @FindBy(xpath = "//input[@type = 'tel']")
    WebElement enterMobileNumber;

    @FindBy(name = "email")
    WebElement enterEmailId;

    @FindBy(name = "password")
    WebElement enterPassword;

    @FindBy(xpath = "//div[@class = 'checkbox']/input")
    WebElement checkBox;

    @FindBy(xpath = "//strong[contains(text(),'WELCOME ABOARD KREDX!')]")
    WebElement welcomeToKredx;

    @FindBy(xpath = "//button[contains(text(),'Submit')]")
    WebElement submitButton;

    public FinancierSignUpPage(WebDriver driver) {
        super(driver);
    }

    public FinancierSignUpPage enterUserName(){
        enterUserName.sendKeys(generateRandomName());
        return this;
    }

    public FinancierSignUpPage enterMobileNumber(){
        enterMobileNumber.sendKeys(generateRandomMobileNumber());
        return this;
    }

    public FinancierSignUpPage enterEmailId(String emailId){
        enterEmailId.sendKeys(generateRandomPassword() + emailId);
        return this;
    }

    public FinancierSignUpPage enterPassword(){
        enterPassword.sendKeys(generateRandomPassword());
        return this;
    }

    public FinancierSignUpPage selectCheckBox(){
        checkBox.click();
        return this;
    }

    public String onAccountCreatedPage(){
        WebDriverWait wait = new WebDriverWait(driver,4000);
        try{
            wait.until(ExpectedConditions.visibilityOf(welcomeToKredx));
            return  welcomeToKredx.getText();
        }
        catch(NoSuchElementException e){
            return "not found";
        }
    }

    public FinancierSignUpPage clickOnSubmitButton(){
        submitButton.click();
        return this;
    }
}
