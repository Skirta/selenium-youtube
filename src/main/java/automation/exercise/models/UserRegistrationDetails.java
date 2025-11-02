package automation.exercise.models;

import lombok.*;

import static automation.exercise.helpers.GenderFormatter.format;

@Getter
@Setter
@Builder
@EqualsAndHashCode
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

    public UserDeliveryAndInvoiceAddressDetails getDeliveryAddressDetails() {
        return UserDeliveryAndInvoiceAddressDetails.builder()
                .genderNameLastname(format(gender) + " " + firstNameForRegistration + " " + lastNameForRegistration)
                .addressFirst(companyNameForRegistration)
                .addressSecond(addressForRegistration)
                .additionalAddress(secondAddressForRegistration)
                .city(cityForRegistration + " " + stateForRegistration + " " + zipcodeForRegistration)
                .country(countryForRegistration)
                .phone(mobileNumberForRegistration)
                .build();
    }

    public UserDeliveryAndInvoiceAddressDetails getInvoiceAddressDetails() {
        return UserDeliveryAndInvoiceAddressDetails.builder()
                .genderNameLastname(format(gender) + " " + firstNameForRegistration + " " + lastNameForRegistration)
                .addressFirst(companyNameForRegistration)
                .addressSecond(addressForRegistration)
                .additionalAddress(secondAddressForRegistration)
                .city(cityForRegistration + " " + stateForRegistration + " " + zipcodeForRegistration)
                .country(countryForRegistration)
                .phone(mobileNumberForRegistration)
                .build();
    }
}
