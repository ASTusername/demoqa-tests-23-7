package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1520x1080";
        Configuration.pageLoadStrategy = "eager";
//        Configuration.browser = "chrome";
//        Configuration.timeout = 10000;
//        Configuration.holdBrowserOpen = true;
    }

}
