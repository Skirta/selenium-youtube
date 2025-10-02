package automation.exercise.helpers;

import automation.exercise.models.UserRegistrationDetails;

public class UserFactory {

    public static UserRegistrationDetails getUserForRegistration() {

        String[] randomBirthDate = DataRandomizer.getRandomBirthDate();

        return UserRegistrationDetails.builder()
                .emailForRegistrstion(DataRandomizer.getRandomEmail())
                .gender(DataRandomizer.getRandomGender())
                .passwordForRegistration(DataRandomizer.getRandomPassword())
                .firstNameForRegistration(DataRandomizer.getRandomFirstName())
                .lastNameForRegistration(DataRandomizer.getRandomLastName())
                .dayOfBirthForRegistration(randomBirthDate[0])
                .monthOfBirthForRegistration(randomBirthDate[1])
                .yearOfBirthForRegistration(randomBirthDate[2])
                .companyNameForRegistration(DataRandomizer.getRandomCompany())
                .addressForRegistration(DataRandomizer.getRandomAddress())
                .secondAddressForRegistration(DataRandomizer.getRandomSecondAddress())
                .countryForRegistration(DataRandomizer.getRandomCountry())
                .stateForRegistration(DataRandomizer.getRandomState())
                .cityForRegistration(DataRandomizer.getRandomCity())
                .zipcodeForRegistration(DataRandomizer.getRandomZipcode())
                .mobileNumberForRegistration(DataRandomizer.getRandomMobileNumber())
                .build();
    }
}


