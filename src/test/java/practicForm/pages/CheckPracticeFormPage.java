package practicForm.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CheckPracticeFormPage {

    protected SelenideElement studentName = $(".table").$(byText("Student Name")).parent();
    protected SelenideElement StudentEmail = $(".table").$(byText("Student Email")).parent();
    protected SelenideElement gender = $(".table").$(byText("Gender")).parent();
    protected SelenideElement mobile = $(".table").$(byText("Mobile")).parent();
    protected SelenideElement dateofBirth = $(".table").$(byText("Date of Birth")).parent();
    protected SelenideElement subjects = $(".table").$(byText("Subjects")).parent();
    protected SelenideElement hobbies = $(".table").$(byText("Hobbies")).parent();
    protected SelenideElement picture = $(".table").$(byText("Picture")).parent();
    protected SelenideElement address = $(".table").$(byText("Address")).parent();
    protected SelenideElement stateandCity = $(".table").$(byText("State and City")).parent();

    public CheckPracticeFormPage checkForm(String colm, String text) {
        $(".table").$(byText(colm)).parent().shouldHave(text(text));
        return this;
    }
    @Step("Проверяем поле studentName")
    public CheckPracticeFormPage checkStudentName(String expectedText) {
        studentName.shouldHave(text(expectedText));
        return this;
    }

    @Step("Проверяем поле StudentEmail")
    public CheckPracticeFormPage checkStudentEmail(String expectedText) {
        StudentEmail.shouldHave(text(expectedText));
        return this;
    }
    @Step("Проверяем поле gender")
    public CheckPracticeFormPage checkGender(String expectedText) {
        gender.shouldHave(text(expectedText));
        return this;
    }
    @Step("Проверяем поле mobile")
    public CheckPracticeFormPage checkMobile(String expectedText) {
        mobile.shouldHave(text(expectedText));
        return this;
    }
    @Step("Проверяем поле dateofBirth")
    public CheckPracticeFormPage checkDateofBirth(String expectedText) {
        dateofBirth.shouldHave(text(expectedText));
        return this;
    }
    @Step("Проверяем поле subjects")
    public CheckPracticeFormPage checkSubjects(String expectedText) {
        subjects.shouldHave(text(expectedText));
        return this;
    }
    @Step("Проверяем поле hobbies")
    public CheckPracticeFormPage checkHobbies(String expectedText) {
        hobbies.shouldHave(text(expectedText));
        return this;
    }
    @Step("Проверяем поле picture")
    public CheckPracticeFormPage checkPicture(String expectedText) {
        picture.shouldHave(text(expectedText));
        return this;
    }
    @Step("Проверяем поле address")
    public CheckPracticeFormPage checkAddress(String expectedText) {
        address.shouldHave(text(expectedText));
        return this;
    }
    @Step("Проверяем поле stateandCity")
    public CheckPracticeFormPage checkStateandCity(String expectedText) {
        stateandCity.shouldHave(text(expectedText));
        return this;
    }
    @Step("Закрываем модальное окно Формы")
    public void closeModal() {
        $("#closeLargeModal").click();
    }
    @Step("Проверяем что модальное окно Формы не должно появиться")
    public void modalWindowShouldNotAppear() {
        $("#closeLargeModal").shouldNot(appear);
    }
    @Step("Проверяем что модальное окно Формы должно появиться")
    public void modalWindowShouldAppear() {
        $("#closeLargeModal").should(appear);
    }
    @Step("Проверяем что модальное окно Формы отображается")
    public void modalWindowShouldBeVizible() {
        $("#closeLargeModal").should(appear);
    }
}
