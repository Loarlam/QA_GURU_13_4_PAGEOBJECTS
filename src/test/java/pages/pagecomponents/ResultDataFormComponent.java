package pages.pagecomponents;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ResultDataFormComponent {
    private SelenideElement tableResponsive = $(".table-responsive");

    public void checkingResultFormValues(String checkedValue) {
        tableResponsive.shouldHave(text(checkedValue));
    }
}
