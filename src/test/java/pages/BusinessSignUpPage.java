package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by ken.dsilva on 16/06/17.
 */
public class BusinessSignUpPage extends BasePage {

    @FindBy(name = "fullName")
    WebElement nameField;

    @FindBy(name = "email")
    WebElement emailField;

    @FindBy(name = "mobile")
    WebElement mobileField;

    @FindBy(name = "org_name")
    WebElement organizationNameField;

    @FindBy(xpath = "//input[@type = 'submit']")
    WebElement signupButton;

    @FindBy(xpath = "//h3[contains(text(),'Thank you for Registering')]")
    WebElement successfulSignupText;

    public BusinessSignUpPage(WebDriver driver) {
        super(driver);
    }

    @Step("Entering name")
    public BusinessSignUpPage enterName(){
        nameField.sendKeys(generateRandomName());
        return this;
    }

    @Step("Entering email")
    public BusinessSignUpPage enterEmail(){
        emailField.sendKeys(generateRandomPassword() + data.getEmailId());
        return this;
    }

    @Step("Entering mobile number")
    public BusinessSignUpPage enterMobileNumber(){
        mobileField.sendKeys(generateRandomMobileNumber());
        return this;
    }

    @Step("Entering organisation name")
    public BusinessSignUpPage enterOrganisationName(){
        organizationNameField.sendKeys(generateRandomName());
        return this;
    }

    @Step("Click on submit button")
    public BusinessSignUpPage clickOnSubmitButton(){
        signupButton.click();
        return this;
    }

    @Step("Returning successful sign up message")
    public String getsuccessfulSignupMessage(){
        WebDriverWait wait = new WebDriverWait(driver, 3000);
        wait.until(ExpectedConditions.visibilityOf(successfulSignupText));
        return successfulSignupText.getText();
    }
}
