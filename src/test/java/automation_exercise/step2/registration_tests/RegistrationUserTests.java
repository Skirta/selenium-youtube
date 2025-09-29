package automation_exercise.step2.registration_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.UUID;

public class RegistrationUserTests {

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
    public void registerUserTest() {
        driver.get("https://automationexercise.com/");
        wait.until(ExpectedConditions.urlToBe("https://automationexercise.com/"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@src,'logo.png')]")));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Погоджуюся' or @aria-label='Consent']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/login']"))).click();
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
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/delete_account']"))).click();

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//h2[@data-qa='account-deleted']/b"), "ACCOUNT DELETED!"));
    }
}
