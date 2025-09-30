package automation_exercise.registration_tests;

import automation.exercise.helpers.DataRandomizer;
import automation.exercise.helpers.Waiter;
import automation.exercise.pages.BasePage;
import automation.exercise.pages.LoginPage;
import automation.exercise.pages.MainPage;
import automation_exercise.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.xml.crypto.Data;
import java.util.UUID;

public class RegistrationUserTests extends BaseTest {

    @Test
    public void registerUserTest() {
        String emailForRegistration = DataRandomizer.getRandomEmail();
        String fullNameForRegistration = DataRandomizer.getRandomFullName();

        MainPage mainPage = new MainPage();

        LoginPage loginPage = mainPage
                .openMainPage()
                .assertMainPageSuccessfullyLoaded()
                .clickLoginButton();

        loginPage.assertLoginPageSuccessfullyLoaded().









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
