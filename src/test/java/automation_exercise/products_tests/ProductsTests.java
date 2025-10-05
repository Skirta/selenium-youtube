package automation_exercise.products_tests;

import automation.exercise.models.Product;
import automation.exercise.pages.AllProductsPage;
import automation.exercise.pages.MainPage;
import automation.exercise.pages.SearchedProductsPage;
import automation_exercise.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

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
        List<Product> allProducts = allProductsPage
                .assertAllProductsPageNumberOfProducts(34)
                .getAllProducts();

        Product actualProduct = allProducts.get(0);
        Product expectedProduct = Product.builder()
                .name("Blue Top")
                .price("Rs. 500")
                .build();
        allProductsPage.assertProductDetails(actualProduct, expectedProduct);

    }



//
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[contains(@class,'fa-plus-square')])[1]"))).click();
//        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class='product-information']/h2"),"Blue Top"));
//        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class='product-information']/p[1]"),"Category: Women > Tops"));
//
//        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class='product-information']/p[2]"),"Availability: In Stock"));
//        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class='product-information']/p[3]"),"Condition: New"));
//        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class='product-information']/p[4]"),"Brand: Polo"));
//}
//
    @Test
    public void searchProductTest() {
        SearchedProductsPage searchedProductsPage = allProductsPage
                .setSearchInput("printed")
                .clickSearchButton();
        List<Product> allProducts = searchedProductsPage
                .assertAllProductsPageNumberOfProducts(2)
                .getAllProducts();

        Product actualFirstProduct = allProducts.get(0);
        Product actualSecondProduct = allProducts.get(1);
        Product expectedfirstProduct = Product.builder()
                .name("Sleeves Printed Top - White")
                .price("Rs. 499")
                .build();
        Product expectedsecondProduct = Product.builder()
                .name("Printed Off Shoulder Top - White")
                .price("Rs. 315")
                .build();
        allProductsPage.assertProductDetails(actualFirstProduct, expectedfirstProduct);
        allProductsPage.assertProductDetails(actualSecondProduct, expectedsecondProduct);
    }
}