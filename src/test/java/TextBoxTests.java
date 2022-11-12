import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void veforeAll() {
        Configuration.holdBrowserOpen = true;
    }

@Test

    void fillFormTest () {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("qwe1");
        $("#lastName").setValue("qwe2");
        $("#userEmail").setValue("qwe3@mail.com");
        $("#subjectsInput").setValue("English");
        $("#subjectsInput").pressEnter();
        $("#hobbies-checkbox-1").parent().click();



    }
}
