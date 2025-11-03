package automation.exercise.pages;

import automation.exercise.helpers.Waiter;
import automation.exercise.pages.interfaces.IProductable;
import org.openqa.selenium.By;

public class AllProductsPage extends BasePage implements IProductable {

    private final Waiter waiter = new Waiter(getDriver());

    // Заголовок сторінки продуктів
    private final By allProductsTitleLocator = By.xpath("//h2[text()='All Products']");

    private final By searchProductInputLocator = By.id("search_product");
    private final By submitSearchButtonLocator = By.id("submit_search");

    public AllProductsPage assertAllProductsPageSuccessfullyLoaded() {
        waiter.waitUntilVisibilityOfElementLocated(allProductsTitleLocator);
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
