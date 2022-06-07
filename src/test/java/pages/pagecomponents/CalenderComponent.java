package pages.pagecomponents;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalenderComponent {
    private SelenideElement monthSelect = $(".react-datepicker__month-select"),
            yearSelect = $(".react-datepicker__year-select");

    public void settingDateOfBirthInCalender(int userBirthDay, String userBirthMonth, int userBirthYear) {
        monthSelect.setValue(userBirthMonth);
        yearSelect.setValue(String.format("%s", userBirthYear));

        if (userBirthDay < 10)
            $(String.format(".react-datepicker__day--00%s", userBirthDay)).click();
        else
            $(String.format(".react-datepicker__day--0%s", userBirthDay)).click();
    }
}
