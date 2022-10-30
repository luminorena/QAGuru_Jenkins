package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
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
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.remote="https://user1:1234@selenoid.autotests.cloud/wd/hub";

        //Configuration.browserCapabilities = getRemoteDriver();
    }

    /*private static MutableCapabilities getRemoteDriver(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "107");
        capabilities.setCapability("selenoid:options",
                Map.of("enableVNC", true, "enableVideo", true));
        return capabilities;
    }*/

    @AfterEach
        void addAttachments() {
        Attach.screenshotAs("Last Screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
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
