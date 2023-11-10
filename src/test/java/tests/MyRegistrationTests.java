package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class MyRegistrationTests extends TestBase {

    @Test
    void fillStudentRegistrationFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Surname Alex");
        $("#userEmail").setValue("222@name.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1977");
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__day--017").click();
        $("#subjectsInput").setValue("History").pressEnter();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("file.png");
        $("#currentAddress").setValue("My present address");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#submit").click();

        $(".table-responsive").shouldHave(
                text("Alex Surname Alex"),
                text("222@name.ru"),
                text("Male"),
                text("1234567890"),
                text("17 December,1977"),
                text("History, English"),
                text("Sports, Reading"),
                text("file.png"),
                text("My present address"),
                text("NCR Delhi"));
    }
}