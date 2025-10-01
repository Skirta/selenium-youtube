package automation.exercise.helpers;

import automation.exercise.models.Title;
import com.github.javafaker.Faker;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;
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

    public static Title getRandomGender(){
        Title[] titles = Title.values();
        return titles[new Random().nextInt(titles.length)];
    }

    public static String getRandomPassword(){
        return faker.internet().password();
    }

    public static String getRandomFirstName(){
        return faker.name().firstName();
    }

    public static String getRandomLastName(){
        return faker.name().lastName();
    }

    public static String getRandomCompany(){
        return faker.company().name();
    }

    public static String getRandomAddress(){
        return faker.address().fullAddress();
    }

    public static String getRandomSecondAddress(){
        return faker.address().secondaryAddress();
    }

    public static String getRandomState(){
        return faker.address().state();
    }

    public static String getRandomCity(){
        return faker.address().city();
    }

    public static String getRandomZipcode(){
        return faker.address().zipCode();
    }

    public static String getRandomMobileNumber(){
        return faker.phoneNumber().phoneNumber();
    }

    public static String[] getRandomBirthDate(){
        Date birthday = faker.date().birthday(18, 70);
        LocalDate localDate = birthday.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy");
        String formattedData = localDate.format(formatter);
        return formattedData.split(" ");

    }



}
