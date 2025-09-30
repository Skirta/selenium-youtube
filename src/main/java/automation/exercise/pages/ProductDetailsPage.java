package automation.exercise.pages;

import org.openqa.selenium.By;

public class ProductDetailsPage extends BasePage{
    private final By productTitleLocator = By.xpath("//div[@class='product-information']/h2");
    private final By productCategoryLocator = By.xpath("//div[@class='product-information']/p[1]");
    private final By productAvailabilityLocator = By.xpath("//div[@class='product-information']/p[2]");
    private final By productConditionLocator = By.xpath("//div[@class='product-information']/p[3]");
    private final By productBrandLocator = By.xpath("//div[@class='product-information']/p[4]");

}
