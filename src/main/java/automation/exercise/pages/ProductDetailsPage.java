package automation.exercise.pages;

import automation.exercise.helpers.Waiter;
import automation.exercise.models.ProductDetails;
import org.openqa.selenium.By;

public class ProductDetailsPage extends BasePage {
    private final Waiter waiter = new Waiter(getDriver());
    private final By productTitleLocator = By.xpath("//div[@class='product-information']/h2");
    private final By productCategoryLocator = By.xpath("//div[@class='product-information']/p[1]");
    private final By productPriceLocator = By.xpath("//div[@class='product-information']/span/span");
    private final By productAvailabilityLocator = By.xpath("//div[@class='product-information']/p[2]");
    private final By productConditionLocator = By.xpath("//div[@class='product-information']/p[3]");
    private final By productBrandLocator = By.xpath("//div[@class='product-information']/p[4]");

    public ProductDetails getProductDetails() {
        ProductDetails productDetails = ProductDetails.builder()
                .name(waiter.waitUntilVisibilityOfElementLocated(productTitleLocator).getText())
                .category(waiter.waitUntilVisibilityOfElementLocated(productCategoryLocator).getText())
                .price(waiter.waitUntilVisibilityOfElementLocated(productPriceLocator).getText())
                .availability(waiter.waitUntilVisibilityOfElementLocated(productAvailabilityLocator).getText())
                .condition(waiter.waitUntilVisibilityOfElementLocated(productConditionLocator).getText())
                .brand(waiter.waitUntilElementClicable(productBrandLocator).getText())
                .build();
        return productDetails;
    }
}
