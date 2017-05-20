package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Abc on 4/14/2017.
 */
public class AgreementSummaryPage extends BasePage {

    @FindBy(id="checkbox-accept")
    WebElement acceptCheckbox;

    @FindBy(id="checkbox-risks")
    WebElement riskCheckbox;

    @FindBy(xpath="//button[contains(.,'Click here to sign')]")
    WebElement confirmButton;

    @FindBy(xpath="//div[@class='m-signature-pad--body']")
   public static WebElement signatureTextArea;

    @FindBy(xpath = "//button[contains(.,'Accept and Proceed To Payment')]")
    WebElement afterSignButton;

    public AgreementSummaryPage(WebDriver driver) {
        super(driver);
    }


    public void selectAcceptCheckbox(){
        acceptCheckbox.click();
    }

    public void selectRiskCheckbox(){
        riskCheckbox.click();
    }

    public void clickConfirmButton(){
       confirmButton.click();
    }

    public void clickAfterSign(){
        afterSignButton.click();
    }



}
