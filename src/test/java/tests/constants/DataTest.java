package tests.constants;

import com.github.javafaker.Faker;

import java.util.Locale;

import static utils.RandomUtils.getRandomCity;
import static utils.RandomUtils.getRandomDayOfBirth;

public class DataTest {
    Faker faker = new Faker(new Locale("en-GB"));
    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String userEmail = faker.internet().emailAddress();
    public String gender = faker.options().option("Male", "Female", "Other");
    public String userNumber = faker.phoneNumber().subscriberNumber(10);
    public String userNumberNotValid = faker.number().digits(1);
    public String monthOfBirth = faker.options().option("January", "February", "March", "April",
            "May", "June", "July", "August", "September", "October", "November", "December");
    public String yearOfBirth = String.valueOf(faker.number().numberBetween(1900, 2022));
    public String dayOfBirth = getRandomDayOfBirth(monthOfBirth, yearOfBirth);
    public String subjects = faker.options().option("History", "English");
    public String hobbies = faker.options().option("Sports", "Reading");
    public String uploadPicture = String.format("img/%s.png", faker.number().numberBetween(1, 2));
    public String currentAddress = faker.address().fullAddress();
    public String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public String city = getRandomCity(state);
}