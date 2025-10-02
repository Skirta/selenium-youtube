package automation.exercise.pages;

import automation.exercise.helpers.Waiter;
import org.openqa.selenium.By;

public class AccountDeletedPage extends BasePage{
    private final By accountDeletedMessageLocator = By.xpath("//h2[@data-qa='account-deleted']/b");
    private final Waiter waiter = new Waiter(getDriver());

    public AccountDeletedPage assertAccountDeletedPageSuccessfullyLoaded(String expectedText){
        waiter.waitUntilTextToBeInElement(accountDeletedMessageLocator, expectedText);
        return this;
    }
}
