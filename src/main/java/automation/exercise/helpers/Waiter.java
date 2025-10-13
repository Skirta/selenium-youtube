package automation.exercise.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Waiter {

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

    public WebElement waitUntilVisibilityOfElementLocated(By locator) {
        return new WebDriverWait(driver, defaultTimeout).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitUntilVisibilityOfElementLocated(By locator, Duration duration) {
        return new WebDriverWait(driver, duration).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public boolean waitUntilInVisibilityOfElementLocated(By locator) {
        return new WebDriverWait(driver, defaultTimeout).until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public WebElement waitUntilElementClicable(By locator) {
        return new WebDriverWait(driver, defaultTimeout).until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitUntilElementClicable(WebElement webElement) {
        return new WebDriverWait(driver, defaultTimeout).until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public WebElement waitUntilElementClicable(By locator, Duration duration) {
        return new WebDriverWait(driver, duration).until(ExpectedConditions.elementToBeClickable(locator));
    }

    public Boolean waitUntilTextToBeInElement(By locator, String expectedText) {
        return new WebDriverWait(driver, defaultTimeout).until(ExpectedConditions.textToBePresentInElementLocated(locator, expectedText));
    }

    public List<WebElement> waitUntilNumberOfElementsToBe(By locator, int value) {
        return new WebDriverWait(driver, defaultTimeout).until(ExpectedConditions.numberOfElementsToBe(locator, value));
    }

    public WebElement findOrNull(WebElement container, By locator) {
        List<WebElement> elements = container.findElements(locator);
        return elements.isEmpty() ? null : elements.get(0);
    }

    public String getTextOrNull(WebElement container, By locator) {
        List<WebElement> elements = container.findElements(locator);
        return elements.isEmpty() ? null : elements.get(0).getText();
    }
}
