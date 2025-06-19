package automation_exercise.no_pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddToCartTests {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void addProductsToCart() {
        driver.get("https://automationexercise.com/");
        wait.until(ExpectedConditions.urlToBe("https://automationexercise.com/"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@src,'logo.png')]")));

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/products']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='All Products']")));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ins[@data-anchor-status='displayed' and @data-adsbygoogle-status='done']")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('ins.adsbygoogle[data-anchor-status=\"displayed\"]').remove()");

        WebElement firstProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='product-image-wrapper'])[1]")));
        Actions actions = new Actions(driver);
        actions.moveToElement(firstProduct).pause(1000).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='product-overlay']//a[contains(@class,'add-to-cart')])[1]"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-dismiss='modal']"))).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[@data-dismiss='modal']")));

        actions.moveToElement(firstProduct).pause(1000).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='product-overlay']//a[contains(@class,'add-to-cart')])[1]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-dismiss='modal']"))).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[@data-dismiss='modal']")));


        WebElement secondProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='product-image-wrapper'])[2]")));
        actions.moveToElement(secondProduct).pause(1000).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='product-overlay']//a[contains(@class,'add-to-cart')])[2]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='modal-content']//a[@href='/view_cart']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class,'check_out')]")));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='cart_info']//tr[@id]/td[@class='cart_product']//img)[1]")));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("(//div[@id='cart_info']//tr[@id]/td[@class='cart_description']//a)[1]"), "Blue Top"));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("(//div[@id='cart_info']//tr[@id]/td[@class='cart_description']//p)[1]"), "Women > Tops"));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("(//div[@id='cart_info']//tr[@id]/td[@class='cart_price']//p)[1]"), "Rs. 500"));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("(//div[@id='cart_info']//tr[@id]/td[@class='cart_quantity']//button)[1]"), "2"));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("(//div[@id='cart_info']//tr[@id]/td[@class='cart_total']//p)[1]"), "Rs. 1000"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='cart_info']//tr[@id]/td[@class='cart_delete']//a[@class='cart_quantity_delete'])[1]")));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='cart_info']//tr[@id]/td[@class='cart_product']//img)[2]")));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("(//div[@id='cart_info']//tr[@id]/td[@class='cart_description']//a)[2]"), "Men Tshirt"));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("(//div[@id='cart_info']//tr[@id]/td[@class='cart_description']//p)[2]"), "Men > Tshirts"));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("(//div[@id='cart_info']//tr[@id]/td[@class='cart_price']//p)[2]"), "Rs. 400"));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("(//div[@id='cart_info']//tr[@id]/td[@class='cart_quantity']//button)[2]"), "1"));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("(//div[@id='cart_info']//tr[@id]/td[@class='cart_total']//p)[2]"), "Rs. 400"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='cart_info']//tr[@id]/td[@class='cart_delete']//a[@class='cart_quantity_delete'])[1]")));
    }
}
