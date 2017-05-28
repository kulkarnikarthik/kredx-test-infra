package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Abc on 4/14/2017.
 */
public class DealsPage extends BasePage {

    @FindBy(id="input-invest-1")
    WebElement dealamount;

    @FindBy(xpath="//button[@class='btn btn-kredx-primary']")
    WebElement dealBuyButton;

     @FindBy(xpath="//button[contains(.,'Proceed')]")
    WebElement proceedBuyButton;

    public DealsPage(WebDriver driver) {
        super(driver);
    }

    public void enterDealAmount(){
        dealamount.sendKeys("20");
    }

    public void clickBuyDeal(){  dealBuyButton.click();
    }

    public void proceedDeal(){
      proceedBuyButton.click();
    }
}

