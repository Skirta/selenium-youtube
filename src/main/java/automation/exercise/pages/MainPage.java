package automation.exercise.pages;

import automation.exercise.helpers.Waiter;
import org.openqa.selenium.By;

public class MainPage extends BasePage {

    private final By cookieAggryButtonLocator = By.xpath("//button[@aria-label='Погоджуюся' or @aria-label='Consent']");

    private final Waiter waiter = new Waiter(getDriver());

    public MainPage openMainPage() {
        getDriver().get("https://automationexercise.com/");
        waiter.waitUntilUrlToBe("https://automationexercise.com/");
        return this;
    }

    public MainPage clickConsentButton(){
        waiter.waitUntilElementClicable(cookieAggryButtonLocator).click();
        return this;
    }
    
    public MainPage assertMainPageSuccessfullyLoaded() {
        waiter.waitUntilVisibilityOfElementLocated(logoLocator);
        return this;
    }

    public LoginPage clickLoginButton() {
        waiter.waitUntilElementClicable(signupLoginLocator).click();
        return new LoginPage();
    }

}