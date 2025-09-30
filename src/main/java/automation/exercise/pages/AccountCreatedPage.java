package automation.exercise.pages;

import org.openqa.selenium.By;

public class AccountCreatedPage extends BasePage{

    private final By accountCreatedMessageLocator = By.xpath("//h2[@data-qa='account-created']/b");
    private final By continueButtonLocator = By.xpath("//a[@data-qa='continue-button']");
}
