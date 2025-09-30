package automation.exercise.pages;

import org.openqa.selenium.By;

public class PaymentPage extends BasePage{
    // --- Заголовок ---
    private final By paymentTitle = By.xpath("//h2[text()='Payment']");

    // --- Поля вводу картки ---
    private final By cardNameField = By.name("name_on_card");
    private final By cardNumberField = By.name("card_number");
    private final By cardCvcField = By.name("cvc");
    private final By cardExpiryMonthField = By.name("expiry_month");
    private final By cardExpiryYearField = By.name("expiry_year");

    // --- Кнопка підтвердження ---
    private final By submitPaymentButton = By.id("submit");

}
