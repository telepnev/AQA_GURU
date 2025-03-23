package util;

import com.github.javafaker.Faker;

public class GenerateRandomDate {
    Faker faker = new Faker();

    public String getFirstName = faker.name().firstName();
    public String getLastName = faker.name().lastName();
    public String getUserEmail = faker.internet().emailAddress();
    public String getGender = faker.options().option("Male", "Female", "Other");
    public String getUserPhoneNumber = faker.phoneNumber().subscriberNumber(10);
    public String getDay = String.format("%s", faker.number().numberBetween(1, 28));
    public String getMonth = faker.options().option("January", "February", "March", "April",
            "May", "June", "July", "August", "September", "October", "November", "December");
    public String getYear = String.format("%s", faker.number().numberBetween(1980, 2024));
    public String getSubject = faker.options().option("Computer Science", "Commerce", "Accounting", "Economics", "Arts", "Social Studies", "History",
            "Civics");
    public String getHobbies = faker.options().option("Sports", "Reading", "Music");
    public String getPicture = faker.options().option("Screenshot.png", "Screenshot2.png");
    public String getCurrentAddress = faker.address().fullAddress();
    public String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public String city = selectCity(state);

    public String selectCity(String state) {
        return switch (state) {

            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");

            default -> null;
        };
    }
}
