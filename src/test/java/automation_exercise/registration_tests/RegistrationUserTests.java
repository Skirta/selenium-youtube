package automation_exercise.registration_tests;

import automation.exercise.helpers.CreateAccountHelper;
import automation.exercise.helpers.UserFactory;
import automation.exercise.models.UserRegistrationDetails;
import automation.exercise.pages.*;
import automation_exercise.BaseTest;
import org.testng.annotations.Test;

public class RegistrationUserTests extends BaseTest {

    @Test
    public void registerUserTest() {

        UserRegistrationDetails user = UserFactory.getUserForRegistration();

        MainPage mainPage = new MainPage();

        LoginPage loginPage = mainPage
                .openMainPage()
                .clickConsentButton()
                .assertMainPageSuccessfullyLoaded()
                .getMainMenu()
                .clickLoginButton();

        CreateAccountPage createAccountPage = loginPage
                .assertLoginPageSuccessfullyLoaded()
                .setName(user.getFirstNameForRegistration() + " " + user.getLastNameForRegistration())
                .setEmail(user.getEmailForRegistrstion())
                .clickSignupButton();

        AccountCreatedPage accountCreatedPage = CreateAccountHelper.createUserAccount(createAccountPage, user);
        accountCreatedPage
                .assertAccountCreatedPageSuccessfullyLoaded("ACCOUNT CREATED")
                .clickContinueButton()
                .getMainMenu()
                .assertUserNameIsVisible("Logged in as " + user.getFirstNameForRegistration())
                .getMainMenu()
                .clickDeleteAccountButton()
                .assertAccountDeletedPageSuccessfullyLoaded("ACCOUNT DELETED!");
    }
}