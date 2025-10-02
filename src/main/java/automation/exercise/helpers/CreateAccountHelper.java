package automation.exercise.helpers;

import automation.exercise.models.UserRegistrationDetails;
import automation.exercise.pages.AccountCreatedPage;
import automation.exercise.pages.CreateAccountPage;

public class CreateAccountHelper {
    public static AccountCreatedPage createUserAccount(CreateAccountPage createAccountPage, UserRegistrationDetails user) {

        return createAccountPage
                .assertCreateAccountPageSuccessfullyLoaded()
                .clickGenderRadioButton(user.getGender())
                .setPassword(user.getPasswordForRegistration())
                .setDayOfBirth(user.getDayOfBirthForRegistration())
                .setMonthOfBirth(user.getMonthOfBirthForRegistration())
                .setYearOfBirth(user.getYearOfBirthForRegistration())
                .clickNewsletterCheckbox()
                .clickSpecialOffersCheckbox()
                .setFirstName(user.getFirstNameForRegistration())
                .setLastName(user.getLastNameForRegistration())
                .setCompany(user.getCompanyNameForRegistration())
                .setAddress(user.getAddressForRegistration())
                .setSecondAddress(user.getSecondAddressForRegistration())
                .setCountry(user.getCountryForRegistration())
                .setState(user.getStateForRegistration())
                .setCity(user.getCityForRegistration())
                .setZipcode(user.getZipcodeForRegistration())
                .setMobileNumber(user.getMobileNumberForRegistration())
                .clickCreateAccountButton();
    }
}
