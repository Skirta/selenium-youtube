package automation.exercise.pages.interfaces;

import automation.exercise.helpers.Waiter;
import automation.exercise.models.ProductCard;
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
    By addToCartOverlayButtonLocator = By.xpath(".//div[@class='overlay-content']/a[contains(@class,'add-to-cart')]");

    default List<ProductCard> getAllProducts() {
        List<ProductCard> productCards = new ArrayList<>();
        List<WebElement> productContainers = getDriver().findElements(containerLocator);
        for (WebElement container : productContainers) {
            WebElement productImage = waiter().findOrNull(container, productImageLocator);
            String productPrice = waiter().getTextOrNull(container, productPriceLocator);
            String productName = waiter().getTextOrNull(container, productNameLocator);
            WebElement addToCardButton = waiter().findOrNull(container, addToCardButtonLocator);
            WebElement addToCardOverlayButton = waiter().findOrNull(container, addToCartOverlayButtonLocator);
            WebElement viewProductButton = waiter().findOrNull(container, viewProductButtonLocator);

            ProductCard productCard = ProductCard.builder()
                    .image(productImage)
                    .price(productPrice)
                    .name(productName)
                    .addToCartButton(addToCardButton)
                    .addToCartOverlayButton(addToCardOverlayButton)
                    .viewProductButton(viewProductButton)
                    .build();
            productCards.add(productCard);
        }
        return productCards;
    }

    default IProductable assertAllProductsPageNumberOfProducts(int value) {
        waiter().waitUntilNumberOfElementsToBe(containerLocator, value);
        return this;
    }

    default IProductable assertProductDetails(ProductCard actualProductCard, ProductCard expectProductCard){
        assertNotNull(actualProductCard.getImage(), String.format("Missing product image for product with name [%s]" , expectProductCard.getName()));
        assertEquals(actualProductCard.getPrice(), expectProductCard.getPrice(), String.format("Wrong product price for product [%s]", expectProductCard.getName()));
        assertEquals(actualProductCard.getName(), expectProductCard.getName(), String.format("Wrong product name for product [%s]", expectProductCard.getName()));
        assertNotNull(actualProductCard.getAddToCartButton(), String.format("Missing product add to cart button for product with name[%s]", expectProductCard.getName()));
        assertNotNull(actualProductCard.getViewProductButton(), String.format("Missing product view button for product with name [%s]", expectProductCard.getName()));
        return this;
    }
}
