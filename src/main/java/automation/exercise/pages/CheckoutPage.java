package automation.exercise.pages;

import automation.exercise.helpers.Waiter;
import automation.exercise.models.UserDeliveryAddressDetails;
import automation.exercise.models.UserRegistrationDetails;
import org.openqa.selenium.By;

public class CheckoutPage extends BasePage {
    private final Waiter waiter = new Waiter(getDriver());

    // --- Заголовок ---
    private final By addressDetailsTitle = By.xpath("//h2[text()='Address Details']");

    // --- Адреса доставки ---
    private final By deliveryAddressNameLocator = By.xpath("//ul[@id='address_delivery']/li[contains(@class,'address_firstname')]");
    private final By deliveryAddressLine0Locator = By.xpath("//ul[@id='address_delivery']/li[contains(@class,'address_address1')][1]");
    private final By deliveryAddressLine1Locator = By.xpath("//ul[@id='address_delivery']/li[contains(@class,'address_address1')][2]");
    private final By deliveryAddressLine2Locator = By.xpath("//ul[@id='address_delivery']/li[contains(@class,'address_address1')][3]");
    private final By deliveryAddressCityLocator = By.xpath("//ul[@id='address_delivery']/li[contains(@class,'address_city')]");
    private final By deliveryAddressCountryLocator = By.xpath("//ul[@id='address_delivery']/li[contains(@class,'address_country_name')]");
    private final By deliveryAddressPhoneLocator = By.xpath("//ul[@id='address_delivery']/li[contains(@class,'address_phone')]");

    // --- Адреса рахунку (інвойс) ---
    private final By invoiceAddressNameLocator = By.xpath("//ul[@id='address_invoice']/li[contains(@class,'address_firstname')]");
    private final By invoiceAddressLine1Locator = By.xpath("//ul[@id='address_invoice']/li[contains(@class,'address_address1')][2]");
    private final By invoiceAddressLine2Locator = By.xpath("//ul[@id='address_invoice']/li[contains(@class,'address_address1')][3]");
    private final By invoiceAddressCityLocator = By.xpath("//ul[@id='address_invoice']/li[contains(@class,'address_city')]");
    private final By invoiceAddressCountryLocator = By.xpath("//ul[@id='address_invoice']/li[contains(@class,'address_country_name')]");
    private final By invoiceAddressPhoneLocator = By.xpath("//ul[@id='address_invoice']/li[contains(@class,'address_phone')]");

    // --- Товар у кошику (під час оформлення замовлення) ---
    private final By checkoutCartFirstProductImageLocator = By.xpath("(//div[@id='cart_info']//tr[@id]/td[@class='cart_product']//img)[1]");
    private final By checkoutCartFirstProductNameLocator = By.xpath("(//div[@id='cart_info']//tr[@id]/td[@class='cart_description']//a)[1]");
    private final By checkoutCartFirstProductCategoryLocator = By.xpath("(//div[@id='cart_info']//tr[@id]/td[@class='cart_description']//p)[1]");
    private final By checkoutCartFirstProductPriceLocator = By.xpath("(//div[@id='cart_info']//tr[@id]/td[@class='cart_price']//p)[1]");
    private final By checkoutCartFirstProductQuantityLocator = By.xpath("(//div[@id='cart_info']//tr[@id]/td[@class='cart_quantity']//button)[1]");
    private final By checkoutCartTotalPriceLocator = By.xpath("(//p[@class='cart_total_price'])[last()]");

    private final By orderMessageTextareaLocator = By.xpath("//textarea[@name='message']");
    private final By proceedToPaymentButtonLocator = By.xpath("//a[@href='/payment']");


    public CheckoutPage assertAdressDetailsIsVisible() {
        waiter.waitUntilVisibilityOfElementLocated(addressDetailsTitle);
        return this;
    }

    public UserDeliveryAddressDetails getDeliveryAddressDetails () {
        UserDeliveryAddressDetails userDeliveryAddressDetails = UserDeliveryAddressDetails.builder()
                .genderNameLastname(waiter.waitUntilVisibilityOfElementLocated(deliveryAddressNameLocator).getText())
                .addressFirst(waiter.waitUntilVisibilityOfElementLocated(deliveryAddressLine0Locator).getText())
                .addressSecond(waiter.waitUntilVisibilityOfElementLocated(deliveryAddressLine1Locator).getText())
                .additionalAddress(waiter.waitUntilVisibilityOfElementLocated(deliveryAddressLine2Locator).getText())
                .city(waiter.waitUntilVisibilityOfElementLocated(deliveryAddressCityLocator).getText())
                .country(waiter.waitUntilVisibilityOfElementLocated(deliveryAddressCountryLocator).getText())
                .phone(waiter.waitUntilVisibilityOfElementLocated(deliveryAddressPhoneLocator).getText())
                .build();
        return userDeliveryAddressDetails;
    }
}
