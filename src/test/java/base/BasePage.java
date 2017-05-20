package base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.util.Set;

/**
 * Created by chandanjavaregowda on 03/04/17.
 */
public class BasePage {
    protected WebDriver driver;
    protected String parentWindow;
    protected Set<String> handles;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        saveScreenshot();
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
}