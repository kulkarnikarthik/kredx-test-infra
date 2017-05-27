package pages;

import base.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

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

    @FindBy(xpath = "//strong[contains(text(),'Welcome to KredX!')]")
    WebElement welcomeToKredx;

    @FindBy(xpath = "//strong[contains(text(),'WELCOME ABOARD KREDX!')]")
    WebElement welcomeToKredx2;

    @FindBy(xpath = "//button[contains(text(),'Submit')]")
    WebElement submitButton;

    public FinancierSignUpPage(WebDriver driver) {
        super(driver);
    }

    public FinancierSignUpPage enterUserName(){
        enterUserName.sendKeys(randomName());
        return this;
    }

    public FinancierSignUpPage enterMobileNumber(){
        enterMobileNumber.sendKeys(mobilenumber());
        return this;
    }

    public FinancierSignUpPage enterEmailId(String emailId){
        enterEmailId.sendKeys(ramdomPassword() + emailId);
        return this;
    }

    public FinancierSignUpPage enterPassword(){
        enterPassword.sendKeys(ramdomPassword());
        return this;
    }

    public FinancierSignUpPage selectCheckBox(){
        checkBox.click();
        return this;
    }

//    public boolean onAccountCreatedPage(){
//
//        WebDriverWait wait = new WebDriverWait(driver,4000);
//        try{
//            wait.until(ExpectedConditions.visibilityOf(welcomeToKredx));
//            return  welcomeToKredx.isDisplayed();
//        }
//        catch(NoSuchElementException e){
//            return false;
//        }
//    }

    public boolean onAccountCreatedPage(){

        WebDriverWait wait = new WebDriverWait(driver,4000);
        try{
            wait.until(ExpectedConditions.visibilityOf(welcomeToKredx2));
            return  welcomeToKredx2.isDisplayed();
        }
        catch(NoSuchElementException e){
            return false;
        }
    }

    public FinancierSignUpPage clickOnSubmitButton(){
        submitButton.click();
        return this;
    }

    public String mobilenumber(){
        String num = "710040";

        Random random = new Random();
        String endingNum = String.format("%04d", random.nextInt(10000));
        return num + endingNum;
    }

    public String ramdomPassword(){
        String alphaNumerics = "qwertyuiopasdfghjklzxcvbnm1234567890";
        String password = "";
        for (int i = 0; i < 8; i++) {
            password += alphaNumerics.charAt((int) (Math.random() * alphaNumerics.length()));
        }
        return password;
    }

    public String randomName(){
        String alphaNumerics = "qwertyuiopasdfghjklzxcvbnm";
        String password = "";
        for (int i = 0; i < 8; i++) {
            password += alphaNumerics.charAt((int) (Math.random() * alphaNumerics.length()));
        }
        return password;
    }


}
