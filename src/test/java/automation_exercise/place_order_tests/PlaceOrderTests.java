package automation_exercise.place_order_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.UUID;

public class PlaceOrderTests {

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
    public void placeOrderTests() {
        driver.get("https://automationexercise.com/");
        wait.until(ExpectedConditions.urlToBe("https://automationexercise.com/"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@src,'logo.png')]")));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Погоджуюся' or @aria-label='Consent']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/products']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='All Products']")));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ins[@data-anchor-status='displayed' and @data-adsbygoogle-status='done']")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('ins.adsbygoogle[data-anchor-status=\"displayed\"]').remove()");

        WebElement firstProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='product-image-wrapper'])[1]")));
        WebElement viewFirstProductBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[contains(@class,'fa-plus-square')])[1]")));
        Actions actions = new Actions(driver);
        actions.scrollToElement(viewFirstProductBtn).moveToElement(firstProduct).pause(1000).build().perform();
        WebElement addToCartBtnOnFirstProduct = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='product-overlay']//a[contains(@class,'add-to-cart')])[1]")));
        addToCartBtnOnFirstProduct.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='modal-content']//a[@href='/view_cart']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class,'check_out')]"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='modal-content']//a[@href='/login']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='New User Signup!']")));

        UUID uuid = UUID.randomUUID();
        String emailPart = uuid.toString().substring(0, 8);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-qa='signup-name']"))).sendKeys("Joe");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-qa='signup-email']"))).sendKeys(emailPart + "joespencer@test.com");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-qa='signup-button']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[text()='Enter Account Information']")));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uniform-id_gender1"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("test123");

        WebElement daysSelectorLocator = driver.findElement(By.id("days"));
        Select daysSelect = new Select(daysSelectorLocator);
        daysSelect.selectByVisibleText("28");

        WebElement monthSelectorLocator = driver.findElement(By.id("months"));
        Select monthSelect = new Select(monthSelectorLocator);
        monthSelect.selectByVisibleText("November");

        WebElement yearsSelectorLocator = driver.findElement(By.id("years"));
        Select yearsSelect = new Select(yearsSelectorLocator);
        yearsSelect.selectByVisibleText("1990");

        wait.until(ExpectedConditions.elementToBeClickable(By.id("newsletter"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("optin"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first_name"))).sendKeys("Joe");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("last_name"))).sendKeys("Spenser");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("company"))).sendKeys("IOT Design");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("address1"))).sendKeys("Rice avenue, 2");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("address2"))).sendKeys("app 43");
        WebElement countrySelectorLocator = driver.findElement(By.id("country"));
        Select countrySelect = new Select(countrySelectorLocator);
        countrySelect.selectByVisibleText("Canada");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("state"))).sendKeys("UYS");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("city"))).sendKeys("Vancouver");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("zipcode"))).sendKeys("38822");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mobile_number"))).sendKeys("+19237923723");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-qa='create-account']"))).click();

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//h2[@data-qa='account-created']/b"), "ACCOUNT CREATED!"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-qa='continue-button']"))).click();

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//i[contains(@class,'fa-user')]/parent::a"), "Logged in as Joe"));

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[contains(@class,'navbar-nav')]//a[@href='/view_cart']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class,'check_out')]"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Address Details']")));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//ul[@id='address_delivery']/li[contains(@class,'address_firstname')]"), "Mr. Joe Spenser"));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//ul[@id='address_delivery']/li[contains(@class,'address_address1')][2]"), "Rice avenue, 2"));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//ul[@id='address_delivery']/li[contains(@class,'address_address1')][3]"), "app 43"));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//ul[@id='address_delivery']/li[contains(@class,'address_city')]"), "Vancouver UYS 38822"));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//ul[@id='address_delivery']/li[contains(@class,'address_country_name')]"), "Canada"));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//ul[@id='address_delivery']/li[contains(@class,'address_phone')]"), "+19237923723"));

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//ul[@id='address_invoice']/li[contains(@class,'address_firstname')]"), "Mr. Joe Spenser"));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//ul[@id='address_invoice']/li[contains(@class,'address_address1')][2]"), "Rice avenue, 2"));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//ul[@id='address_invoice']/li[contains(@class,'address_address1')][3]"), "app 43"));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//ul[@id='address_invoice']/li[contains(@class,'address_city')]"), "Vancouver UYS 38822"));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//ul[@id='address_invoice']/li[contains(@class,'address_country_name')]"), "Canada"));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//ul[@id='address_invoice']/li[contains(@class,'address_phone')]"), "+19237923723"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='cart_info']//tr[@id]/td[@class='cart_product']//img)[1]")));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("(//div[@id='cart_info']//tr[@id]/td[@class='cart_description']//a)[1]"), "Blue Top"));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("(//div[@id='cart_info']//tr[@id]/td[@class='cart_description']//p)[1]"), "Women > Tops"));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("(//div[@id='cart_info']//tr[@id]/td[@class='cart_price']//p)[1]"), "Rs. 500"));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("(//div[@id='cart_info']//tr[@id]/td[@class='cart_quantity']//button)[1]"), "1"));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("(//p[@class='cart_total_price'])[last()]"), "Rs. 500"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@name='message']"))).sendKeys("Send ASAP please");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/payment']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Payment']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("name_on_card"))).sendKeys("Joe Spenser");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("card_number"))).sendKeys("4444444444444444");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("cvc"))).sendKeys("123");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("expiry_month"))).sendKeys("10");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("expiry_year"))).sendKeys("2029");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("submit"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Congratulations! Your order has been confirmed!']")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class,'check_out')]"))).click();
    }
}
