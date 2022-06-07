package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import pages.pagecomponents.CalenderComponent;
import pages.pagecomponents.ResultDataFormComponent;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;

public class PageOfRegistrationForm {
    private SelenideElement firstName = $("#firstName"),
            secondName = $("#lastName"),
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

    public void settingFirstName(String userName) {
        firstName.setValue(userName);
    }

    public void settingSecondName(String userSecondName) {
        secondName.setValue(userSecondName);
    }

    public void settingGender(int userGender) {
        $(String.format("#gender-radio-%s", userGender)).sendKeys(" ");
    }

    public void settingMobileNumber(String userMobileNumber) {
        mobileNumber.setValue(userMobileNumber);
    }

    public void settingDateOfBirth(int dayOfBirth, String monthOfBirth, int yearOfBirth) {
        dateOfBirthField.click();
        calenderComponent.settingDateOfBirthInCalender(dayOfBirth, monthOfBirth, yearOfBirth);
    }

    public void settingSubject(String userSubject) {
        subject.setValue(userSubject);
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
