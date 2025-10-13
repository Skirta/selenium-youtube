package automation.exercise.pages;

import automation.exercise.helpers.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected final By logoLocator = By.xpath("//img[contains(@src,'logo.png')]");
    protected final By displayedAdBannerLocator = By.xpath("//ins[@data-anchor-status='displayed' and @data-adsbygoogle-status='done']");
    protected final By cartButtonLocator = By.xpath("//ul[contains(@class,'navbar-nav')]//a[@href='/view_cart']");
    protected final By googleAdsBottomBannerLocator = By.xpath("//ins[@data-anchor-status='displayed' and @data-adsbygoogle-status='done']");


    private static WebDriver driver; // static - значить що драйвер створено один раз і він буде використовуватись у всіх тестах (для паралелізації не підходить)

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        BasePage.driver = driver;
    }

    private final Waiter waiter = new Waiter(getDriver());

    public void removeGoogleAdvertising() {
        waiter.waitUntilVisibilityOfElementLocated(googleAdsBottomBannerLocator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('ins.adsbygoogle[data-anchor-status=\"displayed\"]').remove()");
    }
}