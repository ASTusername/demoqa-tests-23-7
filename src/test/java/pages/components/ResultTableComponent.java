package pages.components;

import com.codeborne.selenide.SelenideElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultTableComponent {
    private final SelenideElement resultTable = $(".table-responsive");
    private final SelenideElement modalWindow = $(".modal-dialog");
    private final SelenideElement modalWindowTitle = $("#example-modal-sizes-title-lg");

    public void checkResultTableAppearAndTitle() {
        modalWindow.should(appear);
        modalWindowTitle.shouldHave(text("Thanks for submitting the form"));
    }

    public void checkResultTableNotAppear() {
        modalWindow.shouldNot(appear);
    }

    public void checkResult(String key, String value) {
        if (key.equals("Picture")) resultTable.$(byText(key)).parent().shouldHave(text(picturePath(value)));
        else resultTable.$(byText(key)).parent().shouldHave(text(value));
    }

    public String dateTodayFormatted() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd MMMM,yyyy", Locale.ENGLISH);
        return today.format(pattern);
    }

    private String picturePath(String value) {
        String[] paths = value.split("/");
        return paths[paths.length - 1];
    }

}
