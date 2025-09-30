package automation.exercise.pages;

import org.openqa.selenium.By;

public class OrderPlacedPage {
    private final By orderConfirmationMessage = By.xpath("//p[text()='Congratulations! Your order has been confirmed!']");
    private final By continueCheckoutButton = By.xpath("//a[contains(@class,'check_out')]");
}
