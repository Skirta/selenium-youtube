package automation.exercise.pages;

import org.openqa.selenium.By;

public class SearchedProductsPage {

    private final By searchResultProductsLocator = By.xpath("//div[@class='single-products']");
    //TODO refactor this duplication
    private final By firstSearchProductPriceLocator = By.xpath("((//div[@class='product-image-wrapper'])[1]//h2)[1]");
    private final By firstSearchProductNameLocator = By.xpath("((//div[@class='product-image-wrapper'])[1]//p)[1]");
    private final By firstSearchProductImageLocator = By.xpath("((//div[@class='product-image-wrapper'])[1]//img)[1]");
    private final By secondSearchProductPriceLocator = By.xpath("((//div[@class='product-image-wrapper'])[2]//h2)[1]");
    private final By secondSearchProductNameLocator = By.xpath("((//div[@class='product-image-wrapper'])[2]//p)[1]");
    private final By secondSearchProductImageLocator = By.xpath("((//div[@class='product-image-wrapper'])[2]//img)[1]");

}
