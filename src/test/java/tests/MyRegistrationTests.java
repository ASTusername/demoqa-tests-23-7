package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ResultTableComponent;
import tests.constants.DataTest;

public class MyRegistrationTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    ResultTableComponent resultTableComponent = new ResultTableComponent();
    DataTest dataTest = new DataTest();

    @Test
    void fillStudentRegistrationFormTest() {
        registrationPage.openPage()
                .killBanners()
                .setFirstName(dataTest.firstName)
                .setLastName(dataTest.lastName)
                .setUserEmail(dataTest.userEmail)
                .setGenter(dataTest.gender)
                .setUserNumber(dataTest.userNumber)
                .setDateOfBirth(dataTest.dayOfBirth, dataTest.monthOfBirth, dataTest.yearOfBirth)
                .setSubjects(dataTest.subjects)
                .setHobbies(dataTest.hobbies)
                .setUploadPicture(dataTest.uploadPicture)
                .setCurrentAddress(dataTest.currentAddress)
                .setStateAndCity(dataTest.state, dataTest.city)
                .clickSubmit();

        registrationPage.checkResultTableAppearAndTitle()
                .checkResult("Student Name", dataTest.firstName + " " + dataTest.lastName)
                .checkResult("Student Email", dataTest.userEmail)
                .checkResult("Gender", dataTest.gender)
                .checkResult("Mobile", dataTest.userNumber)
                .checkResult("Date of Birth", dataTest.dayOfBirth + " " + dataTest.monthOfBirth + "," + dataTest.yearOfBirth)
                .checkResult("Subjects", dataTest.subjects)
                .checkResult("Hobbies", dataTest.hobbies)
                .checkResult("Picture", dataTest.uploadPicture)
                .checkResult("Gender", dataTest.gender)
                .checkResult("Address", dataTest.currentAddress)
                .checkResult("State and City", dataTest.state + " " + dataTest.city);
    }

    @Test
    void fillRequiredStudentRegistrationFormTest() {
        registrationPage.openPage()
                .killBanners()
                .setFirstName(dataTest.firstName)
                .setLastName(dataTest.lastName)
                .setGenter(dataTest.gender)
                .setUserNumber(dataTest.userNumber)
                .clickSubmit();

        registrationPage.checkResultTableAppearAndTitle()
                .checkResult("Student Name", dataTest.firstName + " " + dataTest.lastName)
                .checkResult("Gender", dataTest.gender)
                .checkResult("Mobile", dataTest.userNumber)
                .checkResult("Date of Birth", resultTableComponent.dateTodayFormatted());
    }

    @Test
    void fillNotValidStudentRegistrationFormTest() {
        registrationPage.openPage()
                .killBanners()
                .setFirstName(dataTest.firstName)
                .setLastName(dataTest.lastName)
                .setGenter(dataTest.gender)
                .setUserNumber(dataTest.userNumberNotValid)
                .clickSubmit();

        registrationPage.checkResultTableNotAppear()
                .checkMobileFieldIsRed();
    }
}