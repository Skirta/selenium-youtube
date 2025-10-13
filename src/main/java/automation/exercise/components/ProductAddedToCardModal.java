package automation.exercise.components;

import automation.exercise.helpers.Waiter;
import automation.exercise.pages.*;
import org.openqa.selenium.By;

public class ProductAddedToCardModal {

    private final Waiter waiter = new Waiter(BasePage.getDriver());

    protected final By viewCartButtonLocator = By.xpath("//div[@class='modal-body']/p/a[@href='/view_cart']");
    protected final By continueShoppingButtonLocator = By.xpath("//button[text()='Continue Shopping']");
    protected final By modalSuccessfullyLoadedLocator = By.id("cartModal");

    public CartPage clickViewCartButton() {
        waiter.waitUntilElementClicable(viewCartButtonLocator).click();
        return new CartPage();
    }

    public ProductAddedToCardModal clickContinueShoppingButton() {
        waiter.waitUntilElementClicable(continueShoppingButtonLocator).click();
        return this;
    }

    public ProductAddedToCardModal assertProductAddedToCardModalIsVisible() {
        waiter.waitUntilVisibilityOfElementLocated(modalSuccessfullyLoadedLocator);
        return this;
    }

    public ProductAddedToCardModal assertProductAddedToCardModalIsNotVisible() {
        waiter.waitUntilInVisibilityOfElementLocated(modalSuccessfullyLoadedLocator);
        return this;
    }
}