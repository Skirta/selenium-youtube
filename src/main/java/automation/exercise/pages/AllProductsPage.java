package automation.exercise.pages;

import org.openqa.selenium.By;

public class AllProductsPage extends BasePage{
    // Посилання на сторінку продуктів
    private final By productsLinkLocator = By.xpath("//a[@href='/products']");

    // Заголовок сторінки продуктів
    private final By allProductsTitleLocator = By.xpath("//h2[text()='All Products']");

    // Блоки всіх продуктів
    private final By allProductsCardsLocator = By.xpath("//div[@class='single-products']");

    // Перший продукт (Blue Top)
    private final By firstProductPriceLocator = By.xpath("((//div[@class='product-image-wrapper'])[1]//h2)[1]");
    private final By firstProductNameLocator = By.xpath("((//div[@class='product-image-wrapper'])[1]//p)[1]");
    private final By firstProductImageLocator = By.xpath("((//div[@class='product-image-wrapper'])[1]//img)[1]");
    private final By firstProductAddToCartLinkLocator = By.xpath("((//div[@class='product-image-wrapper'])[1]//a[contains(@class,'add-to-cart')])[1]");
    private final By firstProductAddIconLocator = By.xpath("((//div[@class='product-image-wrapper'])[1]//i[contains(@class,'fa-plus-square')])[1]");
    private final By firstAddToCartIconClickableLocator = By.xpath("(//i[contains(@class,'fa-plus-square')])[1]");

    private final By searchProductInputLocator = By.id("search_product");
    private final By submitSearchButtonLocator = By.id("submit_search");

    // Продукти
    private final By firstProductCardLocator = By.xpath("(//div[@class='product-image-wrapper'])[1]");
    private final By secondProductCardLocator = By.xpath("(//div[@class='product-image-wrapper'])[2]");

    // Кнопки "Add to Cart" у оверлеї
    private final By firstProductAddToCartOverlayLocator = By.xpath("(//div[@class='product-overlay']//a[contains(@class,'add-to-cart')])[1]");
    private final By secondProductAddToCartOverlayLocator = By.xpath("(//div[@class='product-overlay']//a[contains(@class,'add-to-cart')])[2]");

    // Модальне вікно
    private final By modalCloseButtonLocator = By.xpath("//button[@data-dismiss='modal']");
    private final By viewCartButtonLocator = By.xpath("//div[@class='modal-content']//a[@href='/view_cart']");


}
