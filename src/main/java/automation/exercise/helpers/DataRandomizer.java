package automation.exercise.helpers;

import com.github.javafaker.Faker;

import java.util.UUID;

public class DataRandomizer {
    private static final Faker faker = new Faker();
    
    public static String getRandomEmail() {
        UUID uuid = UUID.randomUUID();
        String randomPart = uuid.toString().substring(0, 4);
        return randomPart + "_" + faker.internet().emailAddress();
    }

    public static String getRandomFullName(){
        return faker.name().fullName();
    }
}
