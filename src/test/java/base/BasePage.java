package base;

import models.ui.TestData;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Attachment;
import util.YamlReader;

import java.util.Random;
import java.util.Set;

/**
 * Created by chandanjavaregowda on 03/04/17.
 */
public class BasePage {
    protected WebDriver driver;
    protected String parentWindow;
    protected Set<String> handles;
    protected TestData data;
    private final int timeout = 20;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        saveScreenshot();
        data = new YamlReader("data.yml").readTestData();
    }

    protected boolean isVisible(WebElement element) {
        boolean visible = false;
        try {
            visible = element.isDisplayed();
        } catch (Exception e) {
            System.out.println("element not visible");
        }
        return visible;
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    protected byte[] saveScreenshot() {
        driver = BaseTest.driver;
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    protected void waitForLoaderToDisappear() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[text('step details are being uploaded')")));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String generateRandomMobileNumber(){
        String num = data.getMobileNumberPrefix();
        Random random = new Random();
        String endingNum = String.format("%04d", random.nextInt(10000));
        return num + endingNum;
    }

    public String generateRandomPassword(){
        String alphaNumeric = data.getRandomText();
        String password = "";
        for (int i = 0; i < 8; i++) {
            password += alphaNumeric.charAt((int) (Math.random() * alphaNumeric.length()));
        }
        return password;
    }

    public String generateRandomPasswordOfSevenCharacters(){
        String alphaNumeric = data.getRandomText();
        String password = "";
        for (int i = 0; i < 7; i++) {
            password += alphaNumeric.charAt((int) (Math.random() * alphaNumeric.length()));
        }
        return password;
    }

    public String generateRandomName(){
        String alphaNumerics = data.getRandomText();
        String password = "";
        for (int i = 0; i < 8; i++) {
            password += alphaNumerics.charAt((int) (Math.random() * alphaNumerics.length()));
        }
        return password;
    }

    protected void waitForElement(WebElement element) {
        int pollingDuration = 500;
        boolean visible = false;
        for (int i = 0; i < timeout; i++) {
            try {
                visible = element.isDisplayed();
                break;
            } catch (Exception e) {
            }
            waitFor(pollingDuration);
        }
        if (!visible) {
            throw new NoSuchElementException("Element: " + element + " not found");
        }
    }

    protected void waitForElementToBeClickable(WebElement element) {
        int pollingDuration = 500;
        boolean visible = false;
        for (int i = 0; i < timeout; i++) {
            try {
                visible = element.isEnabled();
                break;
            } catch (Exception e) {
            }
            waitFor(pollingDuration);
        }
        if (!visible) {
            throw new NoSuchElementException("Element: " + element + " not clickable");
        }
    }

    private void waitFor(int pollingDuration) {
        System.out.println("waiting for: " + pollingDuration);
        try {
            Thread.sleep(pollingDuration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickOnElement(WebElement webElement){
        waitForElement(webElement);
        webElement.click();
    }

    public void writeTextInField(WebElement webElement,String text){
        waitForElement(webElement);
        webElement.sendKeys(text);
    }
}
