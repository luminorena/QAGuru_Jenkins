package helpers;

import com.github.javafaker.Faker;

import java.util.Random;

public class TestData {
    static Faker faker = new Faker();
     String firstName = faker.name().firstName();
     String lastName = faker.name().lastName();
     String email = faker.internet().emailAddress();
     String gender = faker.demographic().sex();
     String phone = faker.phoneNumber().subscriberNumber(10);
     String year = String.valueOf(faker.date().birthday().getYear() + 1900);
     String month = String.valueOf(faker.date().birthday().getDate());
     String day = getMonthName(faker.date().birthday().getMonth());
     String subject = getSubject();
     String hobbies = getHobbies();
     String filePath = "11.png";
     String currentAddress = faker.address().fullAddress();
     static String state = getState();
     String city = getCity();


    public static String getMonthName(int month) {
        switch (month) {
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";

        }
        return String.valueOf(month);
    }

    public static String getSubject() {
        String[] subjectsArray = {"Math", "Chemistry", "Computer Science"
                , "Commerce", "Economics", "English", "Social Studies"
                , "Accounting", "Physics"};
        return subjectsArray[new Random().nextInt(subjectsArray.length)];
    }

    public static String getHobbies() {
        String[] hobbiesArray = {"Sports", "Reading", "Music"};
        return hobbiesArray[new Random().nextInt(hobbiesArray.length)];
    }


    public static String getState() {
        String[] stateArray = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return stateArray[new Random().nextInt(stateArray.length)];
    }

    public static String getCity() {
        String[] citiesArray;
        switch (state) {
            case "NCR":
                citiesArray = new String[]{"Delhi", "Gurgagon", "Noida"};
                return citiesArray[new Random().nextInt(citiesArray.length)];
            case "Uttar Pradesh":
                citiesArray = new String[]{"Agra", "Lucknow", "Merrut"};
                return citiesArray[new Random().nextInt(citiesArray.length)];
            case "Haryana":
                citiesArray = new String[]{"Karnal", "Panipad"};
                return citiesArray[new Random().nextInt(citiesArray.length)];
            case "Rajasthan":
                citiesArray = new String[]{"Jaipur", "Jaiselmer"};
                return citiesArray[new Random().nextInt(citiesArray.length)];
        }
        return state;
    }


}
