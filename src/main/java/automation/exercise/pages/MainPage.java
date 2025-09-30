package automation.exercise.pages;

import org.openqa.selenium.By;

public class MainPage extends BasePage {

    private final By cookieAggryButtonLocator = By.xpath("//button[@aria-label='Погоджуюся' or @aria-label='Consent']");
    private final By logoutButtonLocator = By.xpath("//a[@href='/logout']");
    private final By productsButtonLocator = By.xpath("//a[@href='/products']");
    private final By cartButtonLocator = By.xpath("//div[@class='modal-content']//a[@href='/view_cart']");

}

