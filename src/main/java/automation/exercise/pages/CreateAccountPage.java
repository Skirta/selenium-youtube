package automation.exercise.pages;

import automation.exercise.helpers.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

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
    private final By specialOffersCheckboxLocator = By.id("optin");

    private final Waiter waiter = new Waiter(getDriver());

    public CreateAccountPage assertCreateAccountPageSuccessfullyLoaded(){
        waiter.waitUntilVisibilityOfElementLocated(enterAccountInfoTitleLocator);
        return this;
    }

    //TODO (Need to refactor this method to randomly choose between MR and MRS)
    public CreateAccountPage clickMrGenderRadioButton(){
        waiter.waitUntilVisibilityOfElementLocated(genderMrRadioButtonLocator);
        return this;
    }

    public CreateAccountPage setPassword(String password){
        waiter.waitUntilVisibilityOfElementLocated(passwordInputLocator).sendKeys(password);
        return this;
    }

    //TODO (Need to refactor this method to randomly choose between 1 and 31)
    public CreateAccountPage setDayOfBirth(){
        WebElement daysSelectorLocator = getDriver().findElement(daysDropdownLocator);
        Select daysSelect = new Select(daysSelectorLocator);
        daysSelect.selectByVisibleText("28");
        return this;
    }

    //TODO (Need to refactor this method to randomly choose between month)
    public CreateAccountPage setMonthOfBirth() {
        WebElement monthSelectorLocator = getDriver().findElement(monthsDropdownLocator);
        Select monthSelect = new Select(monthSelectorLocator);
        monthSelect.selectByVisibleText("November");
        return this;
    }

    //TODO (Need to refactor this method to randomly choose between 1900 and 2021)
    public CreateAccountPage setYearOfBirth() {
        WebElement yearsSelectorLocator = getDriver().findElement(yearsDropdownLocator);
        Select yearsSelect = new Select(yearsSelectorLocator);
        yearsSelect.selectByVisibleText("1990");
        return this;
    }

    public CreateAccountPage clickNewsletterCheckbox(){
        waiter.waitUntilElementClicable(newsletterCheckboxLocator).click();
        return this;
    }

    public CreateAccountPage clickSpecialOffersCheckbox(){
        waiter.waitUntilElementClicable(specialOffersCheckboxLocator).click();
        return this;
    }

    public CreateAccountPage setFirstName (String firstName){
        waiter.waitUntilVisibilityOfElementLocated(firstNameInputLocator).sendKeys(firstName);
        return this;
    }

    public CreateAccountPage setLastName (String lastName){
        waiter.waitUntilVisibilityOfElementLocated(lastNameInputLocator).sendKeys(lastName);
        return this;
    }

    public CreateAccountPage setCompany (String company){
        waiter.waitUntilVisibilityOfElementLocated(companyInputLocator).sendKeys(company);
        return this;
    }

    public CreateAccountPage setAddress (String address){
        waiter.waitUntilVisibilityOfElementLocated(address1InputLocator).sendKeys(address);
        return this;
    }

    public CreateAccountPage setSecondAddress (String secondAddress){
        waiter.waitUntilVisibilityOfElementLocated(address2InputLocator).sendKeys(secondAddress);
        return this;
    }

    //TODO (Need to refactor this method to randomly choose one country from dropdown)
    public CreateAccountPage setCountry() {
        WebElement countrySelectorLocator = getDriver().findElement(countryDropdownLocator);
        Select countrySelect = new Select(countrySelectorLocator);
        countrySelect.selectByVisibleText("Canada");
        return this;
    }

    public CreateAccountPage setState(String state){
        waiter.waitUntilVisibilityOfElementLocated(stateInputLocator).sendKeys(state);
        return this;
    }

    public CreateAccountPage setCity(String city){
        waiter.waitUntilVisibilityOfElementLocated(cityInputLocator).sendKeys(city);
        return this;
    }

    public CreateAccountPage setZipcode(String zipcode){
        waiter.waitUntilVisibilityOfElementLocated(zipcodeInputLocator).sendKeys(zipcode);
        return this;
    }

    public CreateAccountPage setMobileNumber(String mobileNumber){
        waiter.waitUntilVisibilityOfElementLocated(mobileNumberInputLocator).sendKeys(mobileNumber);
        return this;
    }

    public AccountCreatedPage clickCreateAccountButton(){
        waiter.waitUntilElementClicable(createAccountButtonLocator).click();
        return new AccountCreatedPage();
    }


}
