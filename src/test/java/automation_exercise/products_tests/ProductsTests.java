package automation_exercise.products_tests;

import automation.exercise.pages.AllProductsPage;
import automation.exercise.pages.MainPage;
import automation_exercise.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
        allProductsPage.assertAllProductsPageNumberOfProducts(34)
                .getAllProducts();
    }
}




//        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("((//div[@class='product-image-wrapper'])[1]//h2)[1]"),"Rs. 500"));
//        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("((//div[@class='product-image-wrapper'])[1]//p)[1]"),"Blue Top"));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((//div[@class='product-image-wrapper'])[1]//img)[1]")));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((//div[@class='product-image-wrapper'])[1]//a[contains(@class,'add-to-cart')])[1]")));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((//div[@class='product-image-wrapper'])[1]//i[contains(@class,'fa-plus-square')])[1]")));
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
//@Test
//public void searchProductTest(){
//    allProductsPage
//            .setSearchInput("printed")
//            .clickSearchButton()
//            .assertAllProductsPageNumberOfProducts(2);
//
//        }
//
//
//    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_product"))).sendKeys("printed");
//    wait.until(ExpectedConditions.elementToBeClickable(By.id("submit_search"))).click();
//    wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[@class='single-products']"), 2));
//
//    wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("((//div[@class='product-image-wrapper'])[1]//h2)[1]"), "Rs. 499"));
//    wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("((//div[@class='product-image-wrapper'])[1]//p)[1]"), "Sleeves Printed Top - White"));
//    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((//div[@class='product-image-wrapper'])[1]//img)[1]")));
//
//    wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("((//div[@class='product-image-wrapper'])[2]//h2)[1]"), "Rs. 315"));
//    wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("((//div[@class='product-image-wrapper'])[2]//p)[1]"), "Printed Off Shoulder Top - White"));
//    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((//div[@class='product-image-wrapper'])[2]//img)[1]")));
//}
//}
