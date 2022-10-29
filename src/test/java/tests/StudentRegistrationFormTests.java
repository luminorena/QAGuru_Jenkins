package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.StudentRegistrationFormPage;


import java.util.Map;

import static helpers.TestData.*;


public class StudentRegistrationFormTests {

    StudentRegistrationFormPage studentRegistrationFormPage
            = new StudentRegistrationFormPage();



    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.remote=System
                .getProperty("selenide.remote");
        Configuration.browserCapabilities = getRemoteDriver();
    }

    private static MutableCapabilities getRemoteDriver(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "107");
        capabilities.setCapability("selenoid:options",
                Map.of("enableVNC", true, "enableVideo", true));
        return capabilities;
    }


    @Test
    @DisplayName("full form test")
    void doRegisterFillForm() throws InterruptedException {

        studentRegistrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhoneNumber(phone)
                .setBirthDate(day, month, year)
                .setSubjects(subject)
                .setHobbies(hobbies)
                .setFileUpload("src/test/resources/" + filePath)
                .setAddress(currentAddress)
                .setStateAndCity(state, city)
                .clickSubmit();


        // submitting checks

        studentRegistrationFormPage.checkModalWindowVisible()
                .checkResult("Student Name", firstName + "\n" + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phone)
                .checkResult("Date of Birth", day + ' ' + month + ',' + year)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", filePath)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", state + " " + city)
                .closeModalWindow();
    }


    @Test
    @DisplayName("Short form test")
    void doRegisterWithMinimumDataForm() throws InterruptedException {
        studentRegistrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhoneNumber(phone)
                .clickSubmit();

        // submitting checks

        studentRegistrationFormPage.checkModalWindowVisible()
                .checkResult("Student Name", firstName + "\n" + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phone)
                .closeModalWindow();
    }


}
