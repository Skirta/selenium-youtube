package automation_exercise.step2;

import automation.exercise.step2.BrowserFactory;
import automation.exercise.step2.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void startBrowser(){
        BrowserFactory browserFactory = new BrowserFactory();
        WebDriver driver = browserFactory.getDriverInstance();
        BasePage.setDriver(driver);
    }

    @AfterMethod
    public void quitBrowser() {
         BasePage.getDriver().quit();
    }
}
