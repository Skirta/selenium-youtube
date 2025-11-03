package automation.exercise.pages;

import automation.exercise.helpers.Waiter;
import org.openqa.selenium.By;

public class PaymentPage extends BasePage{

    private final Waiter waiter = new Waiter(getDriver());
    // --- Заголовок ---
    private final By paymentTitleLocator = By.xpath("//h2[text()='Payment']");

    // --- Поля вводу картки ---
    private final By cardNameField = By.name("name_on_card");
    private final By cardNumberField = By.name("card_number");
    private final By cardCvcField = By.name("cvc");
    private final By cardExpiryMonthField = By.name("expiry_month");
    private final By cardExpiryYearField = By.name("expiry_year");

    // --- Кнопка підтвердження ---
    private final By submitPaymentButton = By.id("submit");

    public PaymentPage assertPaymentPageIsSuccessfullyLoaded() {
        waiter.waitUntilVisibilityOfElementLocated(paymentTitleLocator);
        return this;
    }

    public PaymentPage setNameOnCard (String nameOnCard) {
        waiter.waitUntilVisibilityOfElementLocated(cardNameField).sendKeys(nameOnCard);
        return this;
    }

    public PaymentPage setCardNumber (String nameOnCard) {
        waiter.waitUntilVisibilityOfElementLocated(cardNumberField).sendKeys(nameOnCard);
        return this;
    }

    public PaymentPage setCardCVC (String nameOnCard) {
        waiter.waitUntilVisibilityOfElementLocated(cardCvcField).sendKeys(nameOnCard);
        return this;
    }

    public PaymentPage setCardMonth (String nameOnCard) {
        waiter.waitUntilVisibilityOfElementLocated(cardExpiryMonthField).sendKeys(nameOnCard);
        return this;
    }

    public PaymentPage setCardYear (String nameOnCard) {
        waiter.waitUntilVisibilityOfElementLocated(cardExpiryYearField).sendKeys(nameOnCard);
        return this;
    }

    public OrderPlacedPage clickPayAndConfirmOrderButton() {
        waiter.waitUntilVisibilityOfElementLocated(submitPaymentButton).click();
        return new OrderPlacedPage();
    }
}