package automation.exercise.pages.interfaces;

import automation.exercise.models.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static automation.exercise.pages.BasePage.getDriver;

public interface IProductable {

    By containerLocator = By.xpath("//div[@class='product-image-wrapper']");
    By productImageLocator = By.xpath(".//img");
    By productPriceLocator = By.xpath(".//h2[1]");
    By productNameLocator = By.xpath(".//p[1]");
    By addToCardButtonLocator = By.xpath(".//a[contains(@class,'add-to-cart')][1]");
    By viewProductButtonLocator = By.xpath(".//i[contains(@class,'fa-plus-square')][1]");

    default List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        List<WebElement> productContainers = getDriver().findElements(containerLocator);
        for (WebElement containter : productContainers) {
            WebElement productImage = containter.findElement(productImageLocator);
            String productPrice = containter.findElement(productPriceLocator).getText();
            String productName = containter.findElement(productNameLocator).getText();
            WebElement addToCardButton = containter.findElement(addToCardButtonLocator);
            WebElement viewProductButton = containter.findElement(viewProductButtonLocator);

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
}
