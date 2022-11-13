import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
    }

@Test

    void fillFormTest () {
        open("https://demoqa.com/automation-practice-form");
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("qwe1");
        $("#lastName").setValue("qwe2");
        $("#userEmail").setValue("qwe3@mail.com");
        $("#gender-radio-3").parent().click();
        $("#userNumber").setValue("1234567899");

        $("#subjectsInput").setValue("English");
        $("#subjectsInput").pressEnter();
        $("#hobbies-checkbox-1").parent().click();
        $("#uploadPicture").uploadFile(new File("Files/Photo.jpg"));
        $("#currentAddress").setValue("Miami/HomeBRB");
        $("#react-select-3-input").setValue("NCR");
        $("#react-select-3-input").pressEnter();
        $("#react-select-4-input").setValue("Delhi");
        $("#react-select-4-input").pressEnter();
        $("#submit").click();






    }
}
