package pages;

import base.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends BasePage {
    @FindBy(name = "user_name")
    WebElement email;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(xpath = "//button[@class='btn btn-kredx-primary btn-block']")
    WebElement login;

    @FindBy(xpath = "//div[contains(text(),'Please enter your password')]")
    WebElement noPasswordEntered;

    @FindBy(xpath = "//a[contains(text(),'Sign up as an Investor')]")
    WebElement signUpAsInvestor;

    @FindBy(xpath = "//p[contains(text(),'New to KredX?')]")
    WebElement onLoginPage;

    @FindBy(xpath = "//div[contains(text(),'Incorrect email or password.')]")
    WebElement errorMessageWrongPassword;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage enterUsername(String username) {
        email.sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        this.password.sendKeys(password);
        return this;
    }

    public void submit() {
        login.click();
    }

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

    public LoginPage goToSignUpAsInvestorPage(){
        WebDriverWait wait = new WebDriverWait(driver,3000);
        wait.until(ExpectedConditions.elementToBeClickable(signUpAsInvestor));
        signUpAsInvestor.click();

//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return this;
    }

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

    public LoginPage inCorrectPassword() {
        this.password.sendKeys(generateRandomPassword());
        return this;
    }


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

}
