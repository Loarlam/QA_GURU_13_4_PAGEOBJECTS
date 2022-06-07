package tests;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class PersonalDataRegistrationFormTest extends TestBaseIncludingBeforeAndAfterTests {
    String userName = "Test",
            userSurname = "Testov",
            userEmail = "test_testov@testmail.com",
            userMonthOfBirth = "December",
            userSubject = "Chemistry",
            userPicture = "src/test/resources/Kavai.jpg",
            userPictureShortPath = "Kavai.jpg",
            userAddress = "Улица Пушкина, дом Ленина",
            userState = "Haryana",
            userCity = "Panipat";
    long userPhoneNumber = new Random().nextInt(1000000000) + 9000000000L;
    int userYearOfBirth = new Random().nextInt(101) + 1900,
            userDayOfBirth = new Random().nextInt(27) + 1,
            userGender = new Random().nextInt(3) + 1,
            userHobbies = new Random().nextInt(3) + 1;

    @Test
    void succesfulTest() {
        pageOfRegistrationForm.openingWebsiteWithoutAds();
        pageOfRegistrationForm.settingFirstName(userName);
        pageOfRegistrationForm.settingSurname(userSurname);
        pageOfRegistrationForm.settingEmail(userEmail);
        pageOfRegistrationForm.settingGender(userGender);
        pageOfRegistrationForm.settingMobileNumber(userPhoneNumber);
        pageOfRegistrationForm.settingDateOfBirth(userDayOfBirth, userMonthOfBirth, userYearOfBirth);
        pageOfRegistrationForm.settingSubject(userSubject);
        pageOfRegistrationForm.settingHobbies(userHobbies);
        pageOfRegistrationForm.uploadingPicture(userPicture);
        pageOfRegistrationForm.settingAddress(userAddress);
        pageOfRegistrationForm.selectingState(userState);
        pageOfRegistrationForm.selectingCity(userCity);
        pageOfRegistrationForm.clickingOnSubmit();
        pageOfRegistrationForm.checkingResultFormValues(userName + " " + userSurname);
        pageOfRegistrationForm.checkingResultFormValues(userEmail);
        pageOfRegistrationForm.checkingResultFormValues(String.valueOf(userGender));
        pageOfRegistrationForm.checkingResultFormValues(String.valueOf(userPhoneNumber));
        pageOfRegistrationForm.checkingResultFormValues(userDayOfBirth + " " + userMonthOfBirth + "," + userYearOfBirth);
        pageOfRegistrationForm.checkingResultFormValues(userSubject);
        pageOfRegistrationForm.checkingResultFormValues(String.valueOf(userHobbies));
        pageOfRegistrationForm.checkingResultFormValues(userPictureShortPath);
        pageOfRegistrationForm.checkingResultFormValues(userAddress);
        pageOfRegistrationForm.checkingResultFormValues(userState + " " + userCity);
    }
}
