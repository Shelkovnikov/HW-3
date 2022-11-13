import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
    }

@Test

    void fillFormTest () {

        open("https://demoqa.com/automation-practice-form");

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue("Dmitry");
        $("#lastName").setValue("Shelkovnikov");
        $("#userEmail").setValue("qwe3@mail.com");
        $("#gender-radio-3").parent().click();
        $("#userNumber").setValue("1234567899");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("1997");
        $(".react-datepicker__day--020").click();
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


        $(".modal-content").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                text("Dmitry Shelkovnikov"),
                text("qwe3@mail.com"),
                text("Other"),
                text("1234567899"),
                text("English"),
                text("Sports"),
                text("Photo.jpg"),
                text("Miami/HomeBRB"),
                text("NCR Delhi"));

    }
}
