package automation.exercise.components;

import automation.exercise.helpers.Waiter;
import automation.exercise.pages.BasePage;
import automation.exercise.pages.LoginPage;
import lombok.Getter;
import org.openqa.selenium.By;

@Getter
public class CheckoutModal {
    private final Waiter waiter = new Waiter(BasePage.getDriver());

    private final By checkoutModalSuccessfullyLoadedLocator = By.id("checkoutModal");
    private final By registerOrLoginButtonLocator = By.xpath("//div[@class='modal-content']//a[@href='/login']");

    public CheckoutModal assertCheckoutModalIsVisible() {
        waiter.waitUntilVisibilityOfElementLocated(checkoutModalSuccessfullyLoadedLocator);
        return this;
    }

    public CheckoutModal assertCheckoutModalIsNotVisible() {
        waiter.waitUntilInVisibilityOfElementLocated(checkoutModalSuccessfullyLoadedLocator);
        return this;
    }

    public LoginPage clickRegisterLoginButton(){
        waiter.waitUntilElementClicable(registerOrLoginButtonLocator).click();
        return new LoginPage();
    }

}
