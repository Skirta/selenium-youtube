package automation.exercise.pages;

import automation.exercise.SecretsManager;
import automation.exercise.components.MainMenu;
import automation.exercise.helpers.Waiter;
import lombok.Getter;
import org.openqa.selenium.By;

public class MainPage extends BasePage {

    @Getter
    final private MainMenu mainMenu = new MainMenu();


    private final By cookieAggryButtonLocator = By.xpath("//button[@aria-label='Погоджуюся' or @aria-label='Consent']");

    private final Waiter waiter = new Waiter(getDriver());

    public MainPage openMainPage() {
        String baseUrl = SecretsManager.get("BASE_URL");
        getDriver().get(baseUrl);
        waiter.waitUntilUrlToBe(baseUrl);
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
}