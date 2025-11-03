package automation.exercise.helpers;

import automation.exercise.models.Gender;
import automation.exercise.models.ProductCard;
import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class DataRandomizer {
    private static final Faker faker = new Faker();

    public static String getRandomEmail() {
        UUID uuid = UUID.randomUUID();
        String randomPart = uuid.toString().substring(0, 4);
        return randomPart + "_" + faker.internet().emailAddress();
    }

    public static Gender getRandomGender() {
        Gender[] genders = Gender.values();
        return genders[new Random().nextInt(genders.length)];
    }

    public static String getRandomPassword() {
        return faker.internet().password();
    }

    public static String getRandomFirstName() {
        return faker.name().firstName();
    }

    public static String getRandomLastName() {
        return faker.name().lastName();
    }

    public static String getRandomCompany() {
        return faker.company().name();
    }

    public static String getRandomAddress() {
        return faker.address().fullAddress();
    }

    public static String getRandomSecondAddress() {
        return faker.address().secondaryAddress();
    }

    public static String getRandomCountry() {
        List<String> countries = List.of("India", "United States", "Canada", "Australia", "Israel", "New Zealand", "Singapore");
        return countries.get(new Random().nextInt(countries.size()));
    }

    public static String getRandomState() {
        return faker.address().state();
    }

    public static String getRandomCity() {
        return faker.address().city();
    }

    public static String getRandomZipcode() {
        return faker.address().zipCode();
    }

    public static String getRandomMobileNumber() {
        return faker.phoneNumber().phoneNumber();
    }

    public static String[] getRandomBirthDate() {
        Date birthday = faker.date().birthday(18, 70);
        LocalDate localDate = birthday.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy", Locale.ENGLISH);
        String formattedData = localDate.format(formatter);
        return formattedData.split(" ");
    }

    public static int getRandomProduct(List<ProductCard> products) {
        return faker.number().numberBetween(0, products.size());
    }

    public static String getRandomCardNumber() {
        return faker.finance().creditCard();
    }

    public static String getRandomCardCVC() {
        int n = (int) (Math.random() * 1000);
        return String.format("%03d", n);
    }

    public static String getRandomMonthForCard() {
        int n = ThreadLocalRandom.current().nextInt(1, 13);
        return String.format("%02d", n);
    }
    public static String getRandomYearForCard() {
        int n = ThreadLocalRandom.current().nextInt(2025, 2041);
        return String.valueOf(n);
    }
}
