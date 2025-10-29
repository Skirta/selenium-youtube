package automation.exercise.models;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@EqualsAndHashCode
public class UserDeliveryAddressDetails {
    private String genderNameLastname;
    private String addressFirst;
    private String city;
    private String addressSecond;
    private String additionalAddress;
    private String country;
    private String phone;

}
