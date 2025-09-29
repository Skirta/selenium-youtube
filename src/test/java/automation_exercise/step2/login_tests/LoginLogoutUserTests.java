package automation_exercise.step2.login_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginLogoutUserTests {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void loginTest() {
        driver.get("https://automationexercise.com/");
        wait.until(ExpectedConditions.urlToBe("https://automationexercise.com/"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@src,'logo.png')]")));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Погоджуюся' or @aria-label='Consent']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/login']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='New User Signup!']")));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-qa='login-email']"))).sendKeys("3da996b2joespencer@test.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-qa='login-password']"))).sendKeys("test123");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-qa='login-button']"))).click();

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//i[contains(@class,'fa-user')]/parent::a"), "Logged in as Joe"));
    }

    @Test
    public void logoutTest() {
        driver.get("https://automationexercise.com/");
        wait.until(ExpectedConditions.urlToBe("https://automationexercise.com/"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@src,'logo.png')]")));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Погоджуюся' or @aria-label='Consent']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/login']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='New User Signup!']")));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-qa='login-email']"))).sendKeys("3da996b2joespencer@test.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-qa='login-password']"))).sendKeys("test123");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-qa='login-button']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/logout']"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='New User Signup!']")));
    }
}
