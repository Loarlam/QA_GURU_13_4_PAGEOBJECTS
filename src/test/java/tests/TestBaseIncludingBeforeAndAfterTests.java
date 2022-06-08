package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import pages.PageOfRegistrationForm;

public class TestBaseIncludingBeforeAndAfterTests {

    PageOfRegistrationForm pageOfRegistrationForm = new PageOfRegistrationForm();

    @BeforeAll
    static void beforeAllTests() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.browserPosition = "0x0";
    }

    @AfterAll
    static void afterAllTest() throws InterruptedException {
        Configuration.holdBrowserOpen = true;
        Thread.sleep(2000);
        Configuration.holdBrowserOpen = false;
    }
}
