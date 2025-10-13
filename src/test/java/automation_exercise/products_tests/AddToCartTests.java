package automation_exercise.products_tests;

import automation.exercise.models.ProductCard;
import automation.exercise.models.ProductInCart;
import automation.exercise.pages.AllProductsPage;
import automation.exercise.pages.CartPage;
import automation.exercise.pages.MainPage;
import automation_exercise.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class AddToCartTests extends BaseTest {

    private AllProductsPage allProductsPage;

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
    public void addProductsToCart() {

        List<ProductCard> allProducts = allProductsPage.getAllProducts();
        allProducts
                .get(0)
                .cliclAddToCardButton()
                .assertProductAddedToCardModalIsVisible()
                .clickContinueShoppingButton()
                .assertProductAddedToCardModalIsNotVisible();

        allProducts
                .get(0)
                .cliclAddToCardButton()
                .assertProductAddedToCardModalIsVisible()
                .clickContinueShoppingButton()
                .assertProductAddedToCardModalIsNotVisible();

        CartPage cartPage = allProducts
                .get(1)
                .cliclAddToCardButton()
                .assertProductAddedToCardModalIsVisible()
                .clickViewCartButton();

        List<ProductInCart> allProductsInCart = cartPage.getAllProductsInCart();
        ProductInCart expectedFirstProductInCart = ProductInCart.builder()
                .nameAsText("Blue Top")
                .category("Women > Tops")
                .price("Rs. 500")
                .quantity("2")
                .totalPrice("Rs. 1000")
                .build();

        ProductInCart actualFirstProductInCart = cartPage.getProductByName(allProductsInCart, "Blue Top");
        assertThat(actualFirstProductInCart).usingRecursiveComparison().ignoringFields("image", "name", "deleteButton").isEqualTo(expectedFirstProductInCart);

        ProductInCart expectedSecondProductInCart = ProductInCart.builder()
                .nameAsText("Men Tshirt")
                .category("Men > Tshirts")
                .price("Rs. 400")
                .quantity("1")
                .totalPrice("Rs. 400")
                .build();

        ProductInCart actualSecondProductInCart = cartPage.getProductByName(allProductsInCart, "Men Tshirt");
        assertThat(actualSecondProductInCart).usingRecursiveComparison().ignoringFields("image", "name", "deleteButton").isEqualTo(expectedSecondProductInCart);
    }
}
