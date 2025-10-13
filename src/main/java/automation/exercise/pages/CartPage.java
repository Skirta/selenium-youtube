package automation.exercise.pages;

import automation.exercise.helpers.Waiter;
import automation.exercise.models.ProductInCart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class CartPage extends BasePage {

    private final Waiter waiter = new Waiter(getDriver());

    private final By containerLocator = By.xpath("//tr[contains(@id, 'product-')]");
    private final By productImageLocator = By.xpath(".//img");
    private final By productNameLocator = By.xpath(".//td[@class='cart_description']//a");
    private final By productCategoryLocator = By.xpath(".//td[@class='cart_description']//p");
    private final By productPriceLocator = By.xpath(".//td[@class='cart_price']//p");
    private final By productQuantityLocator = By.xpath(".//td[@class='cart_quantity']//button");
    private final By productTotalPriceLocator = By.xpath(".//p[@class='cart_total_price']");
    private final By productDeleteButtonLocator = By.xpath(".//a[@class='cart_quantity_delete']");

    public List<ProductInCart> getAllProductsInCart() {
        List<ProductInCart> prod = new ArrayList<>();
        List<WebElement> productContainers = getDriver().findElements(containerLocator);
        for (WebElement container : productContainers) {
            WebElement productImage = waiter.findOrNull(container, productImageLocator);
            WebElement productName = waiter.findOrNull(container, productNameLocator);
            String productNameAsText = productName.getText();
            String productPrice = waiter.getTextOrNull(container, productPriceLocator);
            String productCategory = waiter.getTextOrNull(container, productCategoryLocator);
            String productQuantity = waiter.getTextOrNull(container, productQuantityLocator);
            String productTotalPrice = waiter.getTextOrNull(container, productTotalPriceLocator);
            WebElement deleteButton = waiter.findOrNull(container, productDeleteButtonLocator);

            ProductInCart productInCard = ProductInCart.builder()
                    .image(productImage)
                    .name(productName)
                    .nameAsText(productNameAsText)
                    .price(productPrice)
                    .category(productCategory)
                    .quantity(productQuantity)
                    .totalPrice(productTotalPrice)
                    .deleteButton(deleteButton)
                    .build();

            prod.add(productInCard);
        }
        return prod;
    }

    public ProductInCart getProductByName(List<ProductInCart> allProductsInCart, String productName) {
        return allProductsInCart
                .stream()
                .filter(productInCart -> productInCart.getNameAsText().equals(productName)).findFirst().orElseThrow();
    }

//    public CartPage assertProductInCartDetails(CartPage actualProductCard, CartPage expectProductCard){
//        assertNotNull(actualProductCard., String.format("Missing product image for product with name [%s]" , expectProductCard.getName()));
//        assertEquals(actualProductCard.getPrice(), expectProductCard.getPrice(), String.format("Wrong product price for product [%s]", expectProductCard.getName()));
//        assertEquals(actualProductCard.getName(), expectProductCard.getName(), String.format("Wrong product name for product [%s]", expectProductCard.getName()));
//        assertNotNull(actualProductCard.getAddToCartButton(), String.format("Missing product add to cart button for product with name[%s]", expectProductCard.getName()));
//        assertNotNull(actualProductCard.getViewProductButton(), String.format("Missing product view button for product with name [%s]", expectProductCard.getName()));
//        return this;
//    }
}
