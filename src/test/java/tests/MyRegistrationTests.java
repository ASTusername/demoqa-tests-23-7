package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ResultTableComponent;

import static tests.constants.DataTest.*;

public class MyRegistrationTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    ResultTableComponent resultTableComponent = new ResultTableComponent();

    @Test
    void fillStudentRegistrationFormTest() {
        registrationPage.openPage()
                .killBanners()
                .setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME)
                .setUserEmail(USER_EMAIL)
                .setGenter(GENDER)
                .setUserNumber(USER_NUMBER)
                .setDateOfBirth(DAY_OF_BIRTH, MONTH_OF_BIRTH, YEAR_OF_BIRTH)
                .setSubjects(SUBJECTS1)
                .setSubjects(SUBJECTS2)
                .setHobbies(HOBBIES1)
                .setHobbies(HOBBIES2)
                .setUploadPicture(UPLOAD_PICTURE)
                .setCurrentAddress(CURRENT_ADDRESS)
                .setStateAndCity(STATE, CITY)
                .clickSubmit();

        registrationPage.checkResultTableAppearAndTitle()
                .checkResult("Student Name", FIRST_NAME + " " + LAST_NAME)
                .checkResult("Student Email", USER_EMAIL)
                .checkResult("Gender", GENDER)
                .checkResult("Mobile", USER_NUMBER)
                .checkResult("Date of Birth", DAY_OF_BIRTH + " " + MONTH_OF_BIRTH + "," + YEAR_OF_BIRTH)
                .checkResult("Subjects", SUBJECTS1 + ", " + SUBJECTS2)
                .checkResult("Hobbies", HOBBIES1 + ", " + HOBBIES2)
                .checkResult("Picture", UPLOAD_PICTURE)
                .checkResult("Gender", GENDER)
                .checkResult("Address", CURRENT_ADDRESS)
                .checkResult("State and City", STATE + " " + CITY);
    }

    @Test
    void fillRequiredStudentRegistrationFormTest() {
        registrationPage.openPage()
                .killBanners()
                .setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME)
                .setGenter(GENDER)
                .setUserNumber(USER_NUMBER)
                .clickSubmit();

        registrationPage.checkResultTableAppearAndTitle()
                .checkResult("Student Name", FIRST_NAME + " " + LAST_NAME)
                .checkResult("Gender", GENDER)
                .checkResult("Mobile", USER_NUMBER)
                .checkResult("Date of Birth", resultTableComponent.dateTodayFormatted());
    }

    @Test
    void fillNotValidStudentRegistrationFormTest() {
        registrationPage.openPage()
                .killBanners()
                .setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME)
                .setGenter(GENDER)
                .setUserNumber(USER_NUMBER_NOT_VALID)
                .clickSubmit();

        registrationPage.checkResultTableNotAppear()
                .checkMobileFieldIsRed();
    }
}