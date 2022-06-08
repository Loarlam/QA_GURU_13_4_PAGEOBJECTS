package tests;

import enumvalues.*;
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
        pageOfRegistrationForm.openingWebsiteWithoutAds()
                .settingFirstName(userName)
                .settingSurname(userSurname)
                .settingEmail(userEmail)
                .settingGender(userGender)
                .settingMobileNumber(userPhoneNumber)
                .settingDateOfBirth(userDayOfBirth, userMonthOfBirth, userYearOfBirth)
                .settingSubject(userSubject)
                .settingHobbies(userHobbies)
                .uploadingPicture(userPicture)
                .settingAddress(userAddress)
                .selectingState(userState)
                .selectingCity(userCity)
                .clickingOnSubmit()
                .checkingResultFormValues(userName + " " + userSurname)
                .checkingResultFormValues(userEmail)
                .checkingResultFormValues(String.valueOf(Gender.values()[userGender - 1]))
                .checkingResultFormValues(String.valueOf(Hobbies.values()[userHobbies - 1]))
                .checkingResultFormValues(userDayOfBirth + " " + userMonthOfBirth + "," + userYearOfBirth)
                .checkingResultFormValues(userSubject)
                .checkingResultFormValues(String.valueOf(userHobbies))
                .checkingResultFormValues(userPictureShortPath)
                .checkingResultFormValues(userAddress)
                .checkingResultFormValues(userState + " " + userCity);
    }
}