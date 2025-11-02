package automation.exercise.models;

import lombok.*;

@Getter
@Setter
@Builder
@EqualsAndHashCode
public class UserDeliveryAndInvoiceAddressDetails {
    private String genderNameLastname;
    private String addressFirst;
    private String city;
    private String addressSecond;
    private String additionalAddress;
    private String country;
    private String phone;

}
