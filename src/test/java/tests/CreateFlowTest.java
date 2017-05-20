package tests;

import base.BaseTest;
import listeners.TestListener;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;

/**
 * Created by chandanjavaregowda on 03/04/17.
 */
@Listeners({TestListener.class})
public class CreateFlowTest extends BaseTest {
    @Test
    public void createFlowTest() {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.enterUsername(data.getUsername());
        loginPage.enterPassword(data.getPassword());
        loginPage.submit();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}