package practicForm.pages.component;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;
public class CalendarComponent {
    public void setDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionContainingText(month);
        $(".react-datepicker__year-select").selectOptionContainingText(year);
        $x("//div[@class='react-datepicker__week']/div[text()='" + day + "']").click();
    }

    public void clearDate() {
        $("#dateOfBirthInput").click();
        for (int i = 0; i < 11; i++) {
            actions().sendKeys(Keys.BACK_SPACE).perform();
        }
    }
}
