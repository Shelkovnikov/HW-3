import tests.TestBase;
import org.junit.jupiter.api.Test;


public class TextBoxTests extends TestBase {


    @Test
    void fillFormTest() {
        String userName = "Dmitry";
        String LastName = "Shelkovnikov";
        String Email = "qwe3@mail.com";
        String Number = "1234567899";
        String BirthDay = ("30");
        String BirthMonth = ("May");
        String BirthYear = ("2008");
        String Gender = "Male";
        String Subject = "English";
        String Hobbies = "Sports";
        String FileUpload = "Photo.jpg";
        String currentAdress = "Miami/HomeBRB";
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
