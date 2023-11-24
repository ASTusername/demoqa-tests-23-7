package utils;

import com.github.javafaker.Faker;

import static utils.LeapYearUtils.getMaxDayOfFebruary;

public class RandomUtils {
    static Faker faker = new Faker();

    public static String getRandomCity(String state) {
        switch (state) {
            case "NCR":
                return faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh":
                return faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana":
                return faker.options().option("Karnal", "Panipat");
            case "Rajasthan":
                return faker.options().option("Jaipur", "Jaiselmer");
            default:
                throw new IllegalArgumentException("Invalid state: " + state);
        }
    }

    public static String getRandomDayOfBirth(String month, String year) {
        String result;
        int res = 0;
        int maxDay = 0;
        if (month.equals("January") || month.equals("March") || month.equals("May") || month.equals("July")
                || month.equals("August") || month.equals("October") || month.equals("December")) {
            maxDay = 31;
        }
        if (month.equals("April") || month.equals("June") || month.equals("September") || month.equals("November")) {
            maxDay = 30;
        }
        if (month.equals("February")) {
            maxDay = getMaxDayOfFebruary(year);
        }
        res = faker.number().numberBetween(1, maxDay);
        return res < 10 ? "0" + res : String.valueOf(res);
    }
}
