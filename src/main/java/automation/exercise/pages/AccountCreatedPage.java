package automation.exercise.pages;

import automation.exercise.helpers.Waiter;
import org.openqa.selenium.By;


public class AccountCreatedPage extends BasePage{

    private final Waiter waiter = new Waiter(getDriver());

    private final By accountCreatedMessageLocator = By.xpath("//h2[@data-qa='account-created']/b");
    private final By continueButtonLocator = By.xpath("//a[@data-qa='continue-button']");

    public AccountCreatedPage assertAccountCreatedPageSuccessfullyLoaded(String expectedText) {
        waiter.waitUntilTextToBeInElement(accountCreatedMessageLocator, expectedText);
        return this;
    }

    public MainPage clickContinueButton(){
        waiter.waitUntilElementClicable(continueButtonLocator).click();
        return new MainPage();
    }
}
