package automation.exercise.pages;

import org.openqa.selenium.By;

public class CreateAccountPage extends BasePage{


    // Заголовки та повідомлення
    private final By enterAccountInfoTitleLocator = By.xpath("//b[text()='Enter Account Information']");

    // Кнопки
    private final By genderMrRadioButtonLocator = By.id("uniform-id_gender1");
    private final By createAccountButtonLocator = By.xpath("//button[@data-qa='create-account']");


    // Поля вводу
    private final By passwordInputLocator = By.id("password");
    private final By firstNameInputLocator = By.id("first_name");
    private final By lastNameInputLocator = By.id("last_name");
    private final By companyInputLocator = By.id("company");
    private final By address1InputLocator = By.id("address1");
    private final By address2InputLocator = By.id("address2");
    private final By stateInputLocator = By.id("state");
    private final By cityInputLocator = By.id("city");
    private final By zipcodeInputLocator = By.id("zipcode");
    private final By mobileNumberInputLocator = By.id("mobile_number");

    // Селектори (dropdown)
    private final By daysDropdownLocator = By.id("days");
    private final By monthsDropdownLocator = By.id("months");
    private final By yearsDropdownLocator = By.id("years");
    private final By countryDropdownLocator = By.id("country");

    // Чекбокси
    private final By newsletterCheckboxLocator = By.id("newsletter");
    private final By optinCheckboxLocator = By.id("optin");



}
