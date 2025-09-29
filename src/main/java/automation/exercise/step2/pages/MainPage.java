package automation.exercise.step2.pages;

import org.openqa.selenium.By;

public class MainPage extends BasePage {

    private final By cookieAggryButtonLocator = By.xpath("//button[@aria-label='Погоджуюся' or @aria-label='Consent']");
    private final By logoLocator = By.xpath("//img[contains(@src,'logo.png')]");
    private final By signupLoginLocator = By.xpath("//a[@href='/login']");
    private final By loggedInAsNameLocator = By.xpath("//i[contains(@class,'fa-user')]/parent::a");
    private final By deleteAccountButtonLocator = By.xpath("//a[@href='/delete_account']");
    private final By logoutButtonLocator = By.xpath("//a[@href='/logout']");
    private final By productsButtonLocator = By.xpath("//a[@href='/products']");
    private final By cartButtonLocator = By.xpath("//div[@class='modal-content']//a[@href='/view_cart']");

}

