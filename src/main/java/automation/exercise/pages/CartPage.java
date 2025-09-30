package automation.exercise.pages;

import org.openqa.selenium.By;

public class CartPage extends BasePage{
    // --- Перший товар у кошику (Blue Top) ---
    private final By firstCartProductImageLocator = By.xpath("(//div[@id='cart_info']//tr[@id]/td[@class='cart_product']//img)[1]");
    private final By firstCartProductNameLocator = By.xpath("(//div[@id='cart_info']//tr[@id]/td[@class='cart_description']//a)[1]");
    private final By firstCartProductCategoryLocator = By.xpath("(//div[@id='cart_info']//tr[@id]/td[@class='cart_description']//p)[1]");
    private final By firstCartProductPriceLocator = By.xpath("(//div[@id='cart_info']//tr[@id]/td[@class='cart_price']//p)[1]");
    private final By firstCartProductQuantityLocator = By.xpath("(//div[@id='cart_info']//tr[@id]/td[@class='cart_quantity']//button)[1]");
    private final By firstCartProductTotalLocator = By.xpath("(//div[@id='cart_info']//tr[@id]/td[@class='cart_total']//p)[1]");
    private final By firstCartProductDeleteLocator = By.xpath("(//div[@id='cart_info']//tr[@id]/td[@class='cart_delete']//a[@class='cart_quantity_delete'])[1]");

    // --- Другий товар у кошику (Men Tshirt) ---
    private final By secondCartProductImageLocator = By.xpath("(//div[@id='cart_info']//tr[@id]/td[@class='cart_product']//img)[2]");
    private final By secondCartProductNameLocator = By.xpath("(//div[@id='cart_info']//tr[@id]/td[@class='cart_description']//a)[2]");
    private final By secondCartProductCategoryLocator = By.xpath("(//div[@id='cart_info']//tr[@id]/td[@class='cart_description']//p)[2]");
    private final By secondCartProductPriceLocator = By.xpath("(//div[@id='cart_info']//tr[@id]/td[@class='cart_price']//p)[2]");
    private final By secondCartProductQuantityLocator = By.xpath("(//div[@id='cart_info']//tr[@id]/td[@class='cart_quantity']//button)[2]");
    private final By secondCartProductTotalLocator = By.xpath("(//div[@id='cart_info']//tr[@id]/td[@class='cart_total']//p)[2]");
    private final By secondCartProductDeleteLocator = By.xpath("(//div[@id='cart_info']//tr[@id]/td[@class='cart_delete']//a[@class='cart_quantity_delete'])[2]");

    private final By modalLoginLinkLocator = By.xpath("//div[@class='modal-content']//a[@href='/login']");

}
