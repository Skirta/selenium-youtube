package automation.exercise.components;

import automation.exercise.helpers.Waiter;
import automation.exercise.pages.AccountDeletedPage;
import automation.exercise.pages.BasePage;
import automation.exercise.pages.LoginPage;
import automation.exercise.pages.MainPage;
import org.openqa.selenium.By;

public class MainMenu {


    private final Waiter waiter = new Waiter(BasePage.getDriver());

    protected final By signupLoginLocator = By.xpath("//a[@href='/login']");
    protected final By loggedInAsNameLocator = By.xpath("//i[contains(@class,'fa-user')]/parent::a");
    protected final By deleteAccountButtonLocator = By.xpath("//a[@href='/delete_account']");
    protected final By logoutButtonLocator = By.xpath("//a[@href='/logout']");


    public AccountDeletedPage clickDeleteAccountButton() {
        waiter.waitUntilElementClicable(deleteAccountButtonLocator).click();
        return new AccountDeletedPage();
    }

    public LoginPage clickLogoutButton() {
        waiter.waitUntilElementClicable(logoutButtonLocator).click();
        return new LoginPage();
    }

    public LoginPage clickLoginButton() {
        waiter.waitUntilElementClicable(signupLoginLocator).click();
        return new LoginPage();
    }

    public MainPage assertUserNameIsVisible(String expectedName) {
        waiter.waitUntilTextToBeInElement(loggedInAsNameLocator, expectedName);
        return new MainPage();
    }
}
