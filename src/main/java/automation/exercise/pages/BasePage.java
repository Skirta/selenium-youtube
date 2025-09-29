package automation.exercise.pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    private static WebDriver driver; // static - значить що драйвер створено один раз і він буде використовуватись у всіх тестах (для паралелізації не підходить)

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        BasePage.driver = driver;
    }
}
