package automation_exercise.products_tests;

import automation.exercise.models.ProductCard;
import automation.exercise.models.ProductDetails;
import automation.exercise.pages.AllProductsPage;
import automation.exercise.pages.MainPage;
import automation.exercise.pages.ProductDetailsPage;
import automation.exercise.pages.SearchedProductsPage;
import automation_exercise.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductsTests extends BaseTest {

    private AllProductsPage allProductsPage;

    @BeforeMethod
    public void preconditions() {
        allProductsPage = new MainPage()
                .openMainPage()
                .clickConsentButton()
                .assertMainPageSuccessfullyLoaded()
                .getMainMenu()
                .clickProductsButton()
                .assertAllProductsPageSuccessfullyLoaded();

    }

    @Test
    public void checkProductListAndProductDetailsTest() {
        List<ProductCard> allProductCards = allProductsPage
                .assertAllProductsPageNumberOfProducts(34)
                .getAllProducts();

        ProductCard actualProductCard = allProductCards.get(0);
        ProductCard expectedProductCard = ProductCard.builder()
                .name("Blue Top")
                .price("Rs. 500")
                .build();
        allProductsPage.assertProductDetails(actualProductCard, expectedProductCard);

        ProductDetailsPage productDetailsPage = actualProductCard.clickViewProductButton();

        ProductDetails actualProductDetails = productDetailsPage.getProductDetails();
        ProductDetails expectedProductDetails = ProductDetails.builder()
                .name("Blue Top")
                .category("Category: Women > Tops")
                .price("Rs. 500")
                .availability("Availability: In Stock")
                .condition("Condition: New")
                .brand("Brand: Polo")
                .build();
        assertThat(actualProductDetails).usingRecursiveComparison().isEqualTo(expectedProductDetails);
    }

    @Test
    public void searchProductTest() {
        SearchedProductsPage searchedProductsPage = allProductsPage
                .setSearchInput("printed")
                .clickSearchButton();
        List<ProductCard> allProductCards = searchedProductsPage
                .assertAllProductsPageNumberOfProducts(2)
                .getAllProducts();

        ProductCard actualFirstProductCard = allProductCards.get(0);
        ProductCard actualSecondProductCard = allProductCards.get(1);
        ProductCard expectedfirstProductCard = ProductCard.builder()
                .name("Sleeves Printed Top - White")
                .price("Rs. 499")
                .build();
        ProductCard expectedsecondProductCard = ProductCard.builder()
                .name("Printed Off Shoulder Top - White")
                .price("Rs. 315")
                .build();
        allProductsPage.assertProductDetails(actualFirstProductCard, expectedfirstProductCard);
        allProductsPage.assertProductDetails(actualSecondProductCard, expectedsecondProductCard);
    }
}