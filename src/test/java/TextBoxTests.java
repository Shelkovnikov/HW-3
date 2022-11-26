import Tests.TestBase;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests extends TestBase {


    @Test
    void fillFormTest() {
        String userName = "Dmitry";

        registrationPage.openPage()
                .setFirstName(userName)
                .setLastName("Shelkovnikov")
                .setEmail("qwe3@mail.com")
                .setNumber("1234567899")
                .setBirthDate("20","may", "1997");



        $("#gender-radio-3").parent().click();
        $("#userNumber").setValue("1234567899");

        $("#subjectsInput").setValue("English");
        $("#subjectsInput").pressEnter();
        $("#hobbies-checkbox-1").parent().click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/Photo.jpg"));
        $("#currentAddress").setValue("Miami/HomeBRB");
        $("#react-select-3-input").setValue("NCR");
        $("#react-select-3-input").pressEnter();
        $("#react-select-4-input").setValue("Delhi");
        $("#react-select-4-input").pressEnter();
        $("#submit").click();

        registrationPage.verifyResultsModal()
                .verifyResult("Student Name", userName + "Shelkovnikov")
                .verifyResult("Student Email", "qwe3@mail.com")
                .verifyResult("Gender",  "Other")
                .verifyResult("Date of Birth", "20 May 1997")
        ;



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
