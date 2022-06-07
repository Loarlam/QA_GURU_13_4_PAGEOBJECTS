package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import pages.pagecomponents.CalenderComponent;
import pages.pagecomponents.ResultDataFormComponent;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class PageOfRegistrationForm {
    private SelenideElement name = $("#firstName"),
            surname = $("#lastName"),
            email = $("#userEmail"),
            mobileNumber = $("#userNumber"),
            dateOfBirthField = $("#dateOfBirthInput"),
            subject = $("#subjectsInput"),
            picture = $("#uploadPicture"),
            address = $("#currentAddress"),
            state = $("#react-select-3-input"),
            city = $("#react-select-4-input"),
            submit = $("#submit"),
            resultForm = $(".modal-title");

    CalenderComponent calenderComponent = new CalenderComponent();
    ResultDataFormComponent resultDataFormComponent = new ResultDataFormComponent();

    public void openingWebsiteWithoutAds() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
    }

    public void settingFirstName(String userName) {
        name.setValue(userName);
    }

    public void settingSurname(String userSurname) {
        surname.setValue(userSurname);
    }

    public void settingEmail(String userEmail) {
        email.setValue(userEmail);
    }

    public void settingGender(int userGender) {
        $(String.format("#gender-radio-%s", userGender)).sendKeys(" ");
    }

    public void settingMobileNumber(long userMobileNumber) {
        mobileNumber.setValue(String.format("%s", userMobileNumber));
    }

    public void settingDateOfBirth(int dayOfBirth, String monthOfBirth, int yearOfBirth) {
        dateOfBirthField.click();
        calenderComponent.settingDateOfBirthInCalender(dayOfBirth, monthOfBirth, yearOfBirth);
    }

    public void settingSubject(String userSubject) {
        subject.sendKeys(userSubject);
        subject.sendKeys(Keys.RETURN);
    }

    public void settingHobbies(int userHobbies) {
        $(String.format("#hobbies-checkbox-%s", userHobbies)).sendKeys(" ");
    }

    public void uploadingPicture(String userPicture) {
        $("#uploadPicture").uploadFile(new File(userPicture));
    }

    public void settingAddress(String userAddress) {
        address.setValue(userAddress);
    }

    public void selectingState(String userState) {
        state.setValue(userState).sendKeys(Keys.RETURN);
    }

    public void selectingCity(String userCity) {
        city.setValue(userCity).sendKeys(Keys.RETURN);
    }

    public void checkingResultFormValues(String validateFieldValue) {
        submit.click();
        resultDataFormComponent.checkingResultFormValues(validateFieldValue);
    }
}
