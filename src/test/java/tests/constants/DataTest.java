package tests.constants;

import com.github.javafaker.Faker;

import java.util.Locale;

import static utils.RandomUtils.getRandomCity;

public class DataTest {
    static Faker faker = new Faker(new Locale("en-GB"));
    public static final String FIRST_NAME = faker.name().firstName();
    public static final String LAST_NAME = faker.name().lastName();
    public static final String USER_EMAIL = faker.internet().emailAddress();
    public static final String GENDER = faker.options().option("Male", "Female", "Other");
    public static final String USER_NUMBER = faker.phoneNumber().subscriberNumber(10);
    public static final String USER_NUMBER_NOT_VALID = faker.number().digits(1);
    public static final String DAY_OF_BIRTH = String.valueOf(faker.number().numberBetween(1, 28)); // как быть с днем 30?
    public static final String MONTH_OF_BIRTH = faker.options().option("January", "March", "April", "May",
            "June", "July", "August", "September", "October", "November", "December");
    public static final String YEAR_OF_BIRTH = String.valueOf(faker.number().numberBetween(1900, 2022));
    public static final String SUBJECTS = faker.options().option("History", "English");
    public static final String HOBBIES = faker.options().option("Sports", "Reading");
    public static final String UPLOAD_PICTURE = String.format("img/%s.png", faker.number().numberBetween(1, 2));
    public static final String CURRENT_ADDRESS = faker.address().fullAddress();
    public static final String STATE = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public static final String CITY = getRandomCity(STATE);

}
