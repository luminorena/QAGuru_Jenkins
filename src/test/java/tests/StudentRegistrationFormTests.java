package tests;

import helpers.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.StudentRegistrationFormPage;

import static helpers.TestData.*;


public class StudentRegistrationFormTests extends TestBase {

    StudentRegistrationFormPage studentRegistrationFormPage
            = new StudentRegistrationFormPage();

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
