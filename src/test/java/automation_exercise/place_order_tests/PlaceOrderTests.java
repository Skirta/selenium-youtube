package automation_exercise.place_order_tests;

import automation.exercise.helpers.CreateAccountHelper;
import automation.exercise.helpers.DataRandomizer;
import automation.exercise.helpers.UserFactory;
import automation.exercise.models.ProductCard;
import automation.exercise.models.ProductInCart;
import automation.exercise.models.UserRegistrationDetails;
import automation.exercise.pages.*;
import automation_exercise.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlaceOrderTests extends BaseTest {

    AllProductsPage allProductsPage = new AllProductsPage();

    @BeforeMethod
    public void setUp() {
        allProductsPage = new MainPage()
                .openMainPage()
                .clickConsentButton()
                .assertMainPageSuccessfullyLoaded()
                .getMainMenu()
                .clickProductsButton()
                .assertAllProductsPageSuccessfullyLoaded();
        allProductsPage.removeGoogleAdvertising();
    }

    @Test
    public void placeOrderTest(){
        UserRegistrationDetails user = UserFactory.getUserForRegistration();
        List<ProductCard> allProducts = allProductsPage.getAllProducts();
        int randomIndex = DataRandomizer.getRandomProduct(allProducts);
        ProductCard selectedProduct = allProducts.get(randomIndex);
        CreateAccountPage createAccountPage = selectedProduct
                .clickAddToCardButton()
                .assertProductAddedToCardModalIsVisible()
                .clickViewCartButton()
                .clickProceedToCheckOutButtonExpectedModal()
                .assertCheckoutModalIsVisible()
                .clickRegisterLoginButton()
                .assertLoginPageSuccessfullyLoaded()
                .setName(user.getFirstNameForRegistration() + " " + user.getLastNameForRegistration())
                .setEmail(user.getEmailForRegistrstion())
                .clickSignupButton();

        AccountCreatedPage accountCreatedPage = CreateAccountHelper.createUserAccount(createAccountPage, user);
        accountCreatedPage
                .assertAccountCreatedPageSuccessfullyLoaded("ACCOUNT CREATED")
                .clickContinueButton()
                .getMainMenu()
                .assertUserNameIsVisible("Logged in as " + user.getFirstNameForRegistration())
                .getMainMenu()
                .clickCartButton()
                .clickProceedToCheckOutButtonExpectedCheckoutPage();
        CheckoutPage checkoutPage = new CheckoutPage();

        assertThat(checkoutPage.getDeliveryAddressDetails()).isEqualTo(user.getDeliveryAddressDetails());
        assertThat(checkoutPage.getInvoiceAddressDetails()).isEqualTo(user.getInvoiceAddressDetails());

        List<ProductInCart> allProductsInCheckout = checkoutPage.getAllProductsInCheckout();
        ProductInCart firstProductInCart = allProductsInCheckout.get(0);
        assertThat(firstProductInCart.getNameAsText()).isEqualTo(selectedProduct.getName());
        assertThat(firstProductInCart.getPrice()).isEqualTo(selectedProduct.getPrice());
        assertThat(firstProductInCart.getQuantity()).isEqualTo("1");
     }
}








//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@name='message']"))).sendKeys("Send ASAP please");
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/payment']"))).click();
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Payment']")));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("name_on_card"))).sendKeys("Joe Spenser");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("card_number"))).sendKeys("4444444444444444");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("cvc"))).sendKeys("123");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("expiry_month"))).sendKeys("10");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("expiry_year"))).sendKeys("2029");
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("submit"))).click();
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Congratulations! Your order has been confirmed!']")));
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class,'check_out')]"))).click();
//    }
//}
