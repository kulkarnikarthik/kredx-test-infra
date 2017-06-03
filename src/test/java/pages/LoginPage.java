package pages;

import base.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;


public class LoginPage extends BasePage {
    @FindBy(name = "user_name")
    WebElement email;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    WebElement login;

    @FindBy(xpath = "//div[contains(text(),'Please enter your password')]")
    WebElement noPasswordEntered;

    @FindBy(xpath = "//a[contains(text(),'Sign up as an Investor')]")
    WebElement signUpAsInvestor;

    @FindBy(xpath = "//p[contains(text(),'New to KredX?')]")
    WebElement onLoginPage;

    @FindBy(xpath = "//div[contains(text(),'Incorrect email or password.')]")
    WebElement errorMessageWrongPassword;

    @FindBy(xpath = "//div[contains(text(),'Please enter your registered email')]")
    WebElement emptyEmailField;

    @FindBy(xpath = "//div[contains(text(),'Email Provided is not valid')]")
    WebElement invalidEmailMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Entering valid username")
    public LoginPage enterUsername(String username) {
        email.sendKeys(username);
        return this;
    }

    @Step("Entering valid password")
    public LoginPage enterPassword(String password) {
        this.password.sendKeys(password);
        return this;
    }

    public void submit() {
        login.click();
    }

    @Step("Verifying error message for no password entered")
    public String isPasswordErrorMessageVisible(){
        WebDriverWait wait = new WebDriverWait(driver,4000);
        try{
            wait.until(ExpectedConditions.visibilityOf(noPasswordEntered));
            return noPasswordEntered.getText();
        }
        catch(NoSuchElementException e){
            return "not found";
        }
    }

    @Step("Navigating to investor signup page")
    public LoginPage goToSignUpAsInvestorPage(){
        WebDriverWait wait = new WebDriverWait(driver,3000);
        wait.until(ExpectedConditions.elementToBeClickable(signUpAsInvestor));
        signUpAsInvestor.click();
        return this;
    }

    @Step("Verifying user logout")
    public String isUserLoggedOut(){
        WebDriverWait wait = new WebDriverWait(driver,4000);
        try{
            wait.until(ExpectedConditions.visibilityOf(onLoginPage));
            return onLoginPage.getText().trim();
        }
        catch(NoSuchElementException e){
            return "not found";
        }
    }

    @Step("Input invalid password")
    public LoginPage inCorrectPassword() {
        this.password.sendKeys(generateRandomPassword());
        return this;
    }

    @Step("Verification of incorrect password error message")
    public String isInCorrectPasswordErrorMessageVisible(){
        WebDriverWait wait = new WebDriverWait(driver,4000);
        try{
            wait.until(ExpectedConditions.visibilityOf(errorMessageWrongPassword));
            return errorMessageWrongPassword.getText();
        }
        catch(NoSuchElementException e){
            return "not found";
        }
    }

    @Step("Verification of no username entered error message")
    public String noUsernameEnteredMessage(){
        WebDriverWait wait = new WebDriverWait(driver,4000);
        try{
            wait.until(ExpectedConditions.visibilityOf(emptyEmailField));
            return emptyEmailField.getText();
        }
        catch(NoSuchElementException e){
            return "not found";
        }
    }

    @Step("Invalid email entered message")
    public String invalidEmailEnteredMessage(){
    WebDriverWait wait = new WebDriverWait(driver,4000);
        try{
        wait.until(ExpectedConditions.visibilityOf(invalidEmailMessage));
        return invalidEmailMessage.getText();
    }
        catch(NoSuchElementException e){
        return "not found";
    }
}


}
