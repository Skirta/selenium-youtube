package automation.exercise.pages;

import automation.exercise.helpers.Waiter;
import org.openqa.selenium.By;

public class OrderPlacedPage extends BasePage{
    private final Waiter waiter = new Waiter(getDriver());

    private final By orderConfirmationMessage = By.xpath("//p[text()='Congratulations! Your order has been confirmed!']");
    private final By downloadInvoiceButton = By.xpath("//a[contains(@class,'check_out')]");

    public OrderPlacedPage assertOrderPlacedSuccessfully() {
        waiter.waitUntilVisibilityOfElementLocated(orderConfirmationMessage);
        return this;
    }

    public void clickDownloadInvoiceButton () {
        waiter.waitUntilElementClicable(downloadInvoiceButton).click();
    }
}
