package automation.exercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected final By logoLocator = By.xpath("//img[contains(@src,'logo.png')]");
    protected final By signupLoginLocator = By.xpath("//a[@href='/login']");
    protected final By loggedInAsNameLocator = By.xpath("//i[contains(@class,'fa-user')]/parent::a");
    protected final By deleteAccountButtonLocator = By.xpath("//a[@href='/delete_account']");
    protected final By logoutButtonLocator = By.xpath("//a[@href='/logout']");
    protected final By displayedAdBannerLocator = By.xpath("//ins[@data-anchor-status='displayed' and @data-adsbygoogle-status='done']");
    protected final By cartButtonLocator = By.xpath("//ul[contains(@class,'navbar-nav')]//a[@href='/view_cart']");


    private static WebDriver driver; // static - значить що драйвер створено один раз і він буде використовуватись у всіх тестах (для паралелізації не підходить)

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        BasePage.driver = driver;
    }
}
