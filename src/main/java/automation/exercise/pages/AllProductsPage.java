package automation.exercise.pages;

import automation.exercise.helpers.Waiter;
import automation.exercise.pages.interfaces.IProductable;
import org.openqa.selenium.By;

public class AllProductsPage extends BasePage implements IProductable {

    private final Waiter waiter = new Waiter(getDriver());

    // Заголовок сторінки продуктів
    private final By allProductsTitleLocator = By.xpath("//h2[text()='All Products']");

    // Блоки всіх продуктів
    private final By allProductsCardsLocator = By.xpath("//div[@class='single-products']");


    private final By searchProductInputLocator = By.id("search_product");
    private final By submitSearchButtonLocator = By.id("submit_search");


    // Кнопки "Add to Cart" у оверлеї
    private final By firstProductAddToCartOverlayLocator = By.xpath("(//div[@class='product-overlay']//a[contains(@class,'add-to-cart')])[1]");
    private final By secondProductAddToCartOverlayLocator = By.xpath("(//div[@class='product-overlay']//a[contains(@class,'add-to-cart')])[2]");

    // Модальне вікно
    private final By modalCloseButtonLocator = By.xpath("//button[@data-dismiss='modal']");
    private final By viewCartButtonLocator = By.xpath("//div[@class='modal-content']//a[@href='/view_cart']");


    private final By productTitleLocator = By.xpath("//div[@class='product-information']/h2");
    private final By productCategoryLocator = By.xpath("//div[@class='product-information']/p[1]");
    private final By productAvailabilityLocator = By.xpath("//div[@class='product-information']/p[2]");
    private final By productConditionLocator = By.xpath("//div[@class='product-information']/p[3]");
    private final By productBrandLocator = By.xpath("//div[@class='product-information']/p[4]");

    public AllProductsPage assertAllProductsPageSuccessfullyLoaded() {
        waiter.waitUntilVisibilityOfElementLocated(allProductsTitleLocator);
        return this;
    }

    public AllProductsPage assertAllProductsPageNumberOfProducts(int value) {
        waiter.waitUntilNumberOfElementsToBe(allProductsCardsLocator, value);
        return this;
    }

    public AllProductsPage setSearchInput(String searchInput){
        waiter.waitUntilVisibilityOfElementLocated(searchProductInputLocator).sendKeys(searchInput);
        return this;
    }

    public SearchedProductsPage clickSearchButton(){
        waiter.waitUntilElementClicable(submitSearchButtonLocator).click();
        return new SearchedProductsPage();
    }


}
