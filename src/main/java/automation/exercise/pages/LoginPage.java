package automation.exercise.pages;

import automation.exercise.helpers.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    private final By loginPageTitleLocator = By.xpath("//h2[text()='New User Signup!']");
    private final By signupNameInputLocator = By.xpath("//input[@data-qa='signup-name']");
    private final By signupEmailInputLocator = By.xpath("//input[@data-qa='signup-email']");
    private final By signupButtonLocator = By.xpath("//button[@data-qa='signup-button']");
    private final By loginEmailInputLocator = By.xpath("//input[@data-qa='login-email']");
    private final By loginPasswordInputLocator = By.xpath("//input[@data-qa='login-password']");
    private final By loginButtonLocator = By.xpath("//button[@data-qa='login-button']");

    private final Waiter waiter = new Waiter(getDriver());

    public LoginPage assertLoginPageSuccessfullyLoaded() {
        waiter.waitUntilVisibilityOfElementLocated(loginPageTitleLocator);
        return this;
    }
}
