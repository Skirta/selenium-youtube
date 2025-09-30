package automation.exercise.helpers;

import automation.exercise.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiter extends BasePage {

    private final WebDriver driver;
    private final Duration defaultTimeout = Duration.ofSeconds(5);

    public Waiter(WebDriver driver) {
        this.driver = driver;
    }

    public void waitUntilUrlToBe(String expectedUrl) {
        new WebDriverWait(driver, defaultTimeout).until(ExpectedConditions.urlToBe(expectedUrl));
    }

    public void waitUntilUrlToBe(String expectedUrl, Duration duration) {
        new WebDriverWait(driver, duration).until(ExpectedConditions.urlToBe(expectedUrl));
    }

    public void waitUntilVisibilityOfElementLocated(By locator) {
        new WebDriverWait(driver, defaultTimeout).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitUntilVisibilityOfElementLocated(By locator, Duration duration) {
        new WebDriverWait(driver, duration).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitUntilElementClicable(By locator) {
        new WebDriverWait(driver, defaultTimeout).until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitUntilElementClicable(By locator, Duration duration) {
        new WebDriverWait(driver, duration).until(ExpectedConditions.elementToBeClickable(locator));
    }
}
