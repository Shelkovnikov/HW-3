import com.github.javafaker.Faker;
import tests.TestBase;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Random;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class TextBoxTests extends TestBase {


    @Test
    void fillFormTest() {
        Faker faker = new Faker(new Locale("eng"));
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy", Locale.CANADA);
        String[] birthday = sdf.format(faker.date().birthday()).split(" ");


        String userName = faker.name().firstName();
        String LastName = faker.name().lastName();
        String Email = faker.internet().emailAddress();
        String Number = faker.phoneNumber().subscriberNumber(10);
        String BirthDay = birthday[0];
        String BirthMonth = birthday[1];
        String BirthYear = birthday[2];
        String Gender = "Male";
        String Subject = "English";
        String Hobbies = "Sports";
        String FileUpload = "Photo.jpg";
        String currentAdress = faker.address().fullAddress();
        String state = "NCR";
        String city = "Delhi";


        registrationPage.openPage()
                .setFirstName(userName)
                .setLastName(LastName)
                .setEmail(Email)
                .setNumber(Number)
                .setBirthDate(BirthDay, BirthMonth, BirthYear)
                .genderClick(Gender)
                .subjectSet(Subject)
                .hobbbiesClick(Hobbies)
                .fileUpload(FileUpload)
                .currentAdressSet(currentAdress)
                .stateSet(state)
                .citySet(city)
                .submitClick();


        registrationPage.verifyResultsModal()
                .verifyResult("Student Name", userName + " " + LastName)
                .verifyResult("Student Email", Email)
                .verifyResult("Gender", Gender)
                .verifyResult("Date of Birth", BirthDay + " " + BirthMonth + "," + BirthYear)
                .verifyResult("Mobile", Number)
                .verifyResult("Subjects", Subject)
                .verifyResult("Hobbies", Hobbies)
                .verifyResult("Picture", FileUpload)
                .verifyResult("Address", currentAdress)
                .verifyResult("State and City", state + " " + city)
        ;


    }
}
