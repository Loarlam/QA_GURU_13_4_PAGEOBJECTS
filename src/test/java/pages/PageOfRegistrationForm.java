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

    public PageOfRegistrationForm openingWebsiteWithoutAds() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public PageOfRegistrationForm settingFirstName(String userName) {

        name.setValue(userName);
        return this;
    }

    public PageOfRegistrationForm settingSurname(String userSurname) {
        surname.setValue(userSurname);
        return this;
    }

    public PageOfRegistrationForm settingEmail(String userEmail) {
        email.setValue(userEmail);
        return this;
    }

    public PageOfRegistrationForm settingGender(int userGender) {
        $(String.format("#gender-radio-%s", userGender)).sendKeys(" ");
        return this;
    }

    public PageOfRegistrationForm settingMobileNumber(long userMobileNumber) {
        mobileNumber.setValue(String.format("%s", userMobileNumber));
        return this;
    }

    public PageOfRegistrationForm settingDateOfBirth(int dayOfBirth, String monthOfBirth, int yearOfBirth) {
        dateOfBirthField.click();
        calenderComponent.settingDateOfBirthInCalender(dayOfBirth, monthOfBirth, yearOfBirth);
        return this;
    }

    public PageOfRegistrationForm settingSubject(String userSubject) {
        subject.sendKeys(userSubject);
        subject.sendKeys(Keys.RETURN);
        return this;
    }

    public PageOfRegistrationForm settingHobbies(int userHobbies) {
        $(String.format("#hobbies-checkbox-%s", userHobbies)).sendKeys(" ");
        return this;
    }

    public PageOfRegistrationForm uploadingPicture(String userPicture) {
        $("#uploadPicture").uploadFile(new File(userPicture));
        return this;
    }

    public PageOfRegistrationForm settingAddress(String userAddress) {
        address.setValue(userAddress);
        return this;
    }

    public PageOfRegistrationForm selectingState(String userState) {
        state.setValue(userState).sendKeys(Keys.RETURN);
        return this;
    }

    public PageOfRegistrationForm selectingCity(String userCity) {
        city.setValue(userCity).sendKeys(Keys.RETURN);
        return this;
    }

    public PageOfRegistrationForm clickingOnSubmit() {
        submit.click();
        return this;
    }

    public PageOfRegistrationForm checkingResultFormValues(String validateFieldValue) {
        resultDataFormComponent.checkingResultFormValues(validateFieldValue);
        return this;
    }
}
