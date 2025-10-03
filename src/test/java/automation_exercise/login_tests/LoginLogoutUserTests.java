package automation_exercise.login_tests;

import automation.exercise.SecretsManager;
import automation.exercise.pages.LoginPage;
import automation.exercise.pages.MainPage;
import automation_exercise.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


@Slf4j
public class LoginLogoutUserTests extends BaseTest {

    private MainPage mainPage;

    @BeforeMethod
    public void preconditions() {
        mainPage = new MainPage()
                .openMainPage()
                .clickConsentButton()
                .assertMainPageSuccessfullyLoaded()
                .clickLoginButton()
                .assertLoginPageSuccessfullyLoaded()
                .setLoginEmail(SecretsManager.get("USER_EMAIL"))
                .setLoginPassword(SecretsManager.get("USER_PASSWORD"))
                .clickLoginButton();
    }

    @Test
    public void loginTest() {

        String userNameForLogin = "Alo";

        mainPage.assertUserNameIsVisible("Logged in as " + userNameForLogin);
    }

    @Test
    public void logoutTest() {

        mainPage
                .clickLogoutButton()
                .assertLoginPageSuccessfullyLoaded();
    }
}
