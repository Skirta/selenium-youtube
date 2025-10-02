package automation.exercise.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

public class UserRegistrationDetails {
    private Gender gender;
    private String emailForRegistrstion;
    private String passwordForRegistration;
    private String firstNameForRegistration;
    private String lastNameForRegistration;
    private String dayOfBirthForRegistration;
    private String monthOfBirthForRegistration;
    private String yearOfBirthForRegistration;
    private String companyNameForRegistration;
    private String addressForRegistration;
    private String secondAddressForRegistration;
    private String countryForRegistration;
    private String stateForRegistration;
    private String cityForRegistration;
    private String zipcodeForRegistration;
    private String mobileNumberForRegistration;
}
