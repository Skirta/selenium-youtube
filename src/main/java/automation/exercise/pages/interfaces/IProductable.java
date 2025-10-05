package automation.exercise.pages.interfaces;

import automation.exercise.helpers.Waiter;
import automation.exercise.models.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static automation.exercise.pages.BasePage.getDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public interface IProductable {

    default Waiter waiter (){
        return new Waiter(getDriver());
    }

    By containerLocator = By.xpath("//div[@class='product-image-wrapper']");
    By productImageLocator = By.xpath(".//img");
    By productPriceLocator = By.xpath(".//h2[1]");
    By productNameLocator = By.xpath(".//p[1]");
    By addToCardButtonLocator = By.xpath(".//a[contains(@class,'add-to-cart')][1]");
    By viewProductButtonLocator = By.xpath(".//i[contains(@class,'fa-plus-square')][1]");

    default WebElement findOrNull(WebElement container, By locator){
        List<WebElement> elements = container.findElements(locator);
        return elements.isEmpty() ? null : elements.get(0);
    }

    default String getTextOrNull(WebElement container, By locator){
        List<WebElement> elements = container.findElements(locator);
        return elements.isEmpty() ? null : elements.get(0).getText();
    }

    default List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        List<WebElement> productContainers = getDriver().findElements(containerLocator);
        for (WebElement containter : productContainers) {
            WebElement productImage = findOrNull(containter, productImageLocator);
            String productPrice = getTextOrNull(containter, productPriceLocator);
            String productName = getTextOrNull(containter, productNameLocator);
            WebElement addToCardButton = findOrNull(containter, addToCardButtonLocator);
            WebElement viewProductButton = findOrNull(containter, viewProductButtonLocator);

            Product product = Product.builder()
                    .image(productImage)
                    .price(productPrice)
                    .name(productName)
                    .addToCardButton(addToCardButton)
                    .viewProductButton(viewProductButton)
                    .build();
            products.add(product);
        }
        return products;
    }

    default IProductable assertAllProductsPageNumberOfProducts(int value) {
        waiter().waitUntilNumberOfElementsToBe(containerLocator, value);
        return this;
    }

    default IProductable assertProductDetails(Product actualProduct, Product expectProduct){
        assertNotNull(actualProduct.getImage(), String.format("Missing product image for product with name [%s]" , expectProduct.getName()));
        assertEquals(actualProduct.getPrice(), expectProduct.getPrice(), String.format("Wrong product price for product [%s]", expectProduct.getName()));
        assertEquals(actualProduct.getName(), expectProduct.getName(), String.format("Wrong product name for product [%s]", expectProduct.getName()));
        assertNotNull(actualProduct.getAddToCardButton(), String.format("Missing product add to cart button for product with name[%s]", expectProduct.getName()));
        assertNotNull(actualProduct.getViewProductButton(), String.format("Missing product view button for product with name [%s]", expectProduct.getName()));
        return this;
    }
}
