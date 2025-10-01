package automation_exercise.registration_tests;

import automation.exercise.helpers.DataRandomizer;
import automation.exercise.helpers.Waiter;
import automation.exercise.models.UserRegistrationDetails;
import automation.exercise.pages.*;
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

        String[] randomBirthDate = DataRandomizer.getRandomBirthDate();

        UserRegistrationDetails user = UserRegistrationDetails.builder()
                .emailForRegistrstion(DataRandomizer.getRandomEmail())
                .title(DataRandomizer.getRandomGender())
                .passwordForRegistration(DataRandomizer.getRandomPassword())
                .firstNameForRegistration(DataRandomizer.getRandomFirstName())
                .lastNameForRegistration(DataRandomizer.getRandomLastName())
                .dayOfBirthForRegistration(randomBirthDate[0])
                .monthOfBirthForRegistration(randomBirthDate[1])
                .yearOfBirthForRegistration(randomBirthDate[3])
                .companyNameForRegistration(DataRandomizer.getRandomCompany())
                .addressForRegistration(DataRandomizer.getRandomAddress())
                .secondAddressForRegistration(DataRandomizer.getRandomSecondAddress())
                .stateForRegistration(DataRandomizer.getRandomState())
                .cityForRegistration(DataRandomizer.getRandomCity())
                .zipcodeForRegistration(DataRandomizer.getRandomZipcode())
                .mobileNumberForRegistration(DataRandomizer.getRandomMobileNumber())
                .build();




        MainPage mainPage = new MainPage();

        LoginPage loginPage = mainPage
                .openMainPage()
                .assertMainPageSuccessfullyLoaded()
                .clickLoginButton();

        CreateAccountPage createAccountPage = loginPage
                .assertLoginPageSuccessfullyLoaded()
                .setName(user.getFirstNameForRegistration() + " " + user.getLastNameForRegistration())
                .setEmail(user.getEmailForRegistrstion())
                .clickSignupButton();

        AccountCreatedPage accountCreatedPage = createAccountPage
                .assertCreateAccountPageSuccessfullyLoaded()
                .clickMrGenderRadioButton()
                .setPassword(user.getPasswordForRegistration())
                .setDayOfBirth()
                .setMonthOfBirth()
                .setYearOfBirth()
                .clickNewsletterCheckbox()
                .clickSpecialOffersCheckbox()
                .setFirstName(user.getFirstNameForRegistration())
                .setLastName(user.getLastNameForRegistration())
                .setCompany(user.getCompanyNameForRegistration())
                .setAddress(user.getAddressForRegistration())
                .setSecondAddress(user.getSecondAddressForRegistration())
                .setCountry()
                .setState(user.getStateForRegistration())
                .setCity(user.getCityForRegistration())
                .setZipcode(user.getZipcodeForRegistration())
                .setMobileNumber(user.getMobileNumberForRegistration())
                .clickCreateAccountButton();

        accountCreatedPage.

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//h2[@data-qa='account-created']/b"), "ACCOUNT CREATED!"));

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-qa='continue-button']"))).click();

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//i[contains(@class,'fa-user')]/parent::a"), "Logged in as Joe"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/delete_account']"))).click();

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//h2[@data-qa='account-deleted']/b"), "ACCOUNT DELETED!"));
    }
}
