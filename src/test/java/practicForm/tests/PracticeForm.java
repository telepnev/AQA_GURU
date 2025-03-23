package practicForm.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import practicForm.pages.CheckPracticeFormPage;
import practicForm.pages.PracticeFormPage;
import practicForm.pages.component.CalendarComponent;
import util.GenerateRandomDate;

import java.util.stream.Stream;

import static io.qameta.allure.Allure.step;

public class PracticeForm extends BaseTest{
    private PracticeFormPage practiceFormPage = new PracticeFormPage();
    private CalendarComponent calendarComponent = new CalendarComponent();
    private CheckPracticeFormPage checkPracticeFormPage = new CheckPracticeFormPage();
    private GenerateRandomDate generateRandomDate = new GenerateRandomDate();

    String firstName = generateRandomDate.getFirstName;
    String lastName = generateRandomDate.getLastName;
    String email = generateRandomDate.getUserEmail;
    String gender = generateRandomDate.getGender;
    String phone = generateRandomDate.getUserPhoneNumber;
    String day = generateRandomDate.getDay;
    String month = generateRandomDate.getMonth;
    String year = generateRandomDate.getYear;
    String state = generateRandomDate.state;
    String city = generateRandomDate.selectCity(state);
    String subject = generateRandomDate.getSubject;
    String hobbies = generateRandomDate.getHobbies;
    String picture = generateRandomDate.getPicture;
    String currentAddress = generateRandomDate.getCurrentAddress;

    @BeforeEach
    public void open() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем https://demoqa.com/automation-practice-form", () -> {
            practiceFormPage.openPracticeFormPage();
            deletBaner();
        });
    }


    // MethodSource

    static Stream<Arguments> userMustRegisterWithMinimumDataTest() {
        return Stream.of(
                Arguments.of("Иван", "Иванов", "ivanov@example.com", "Male", "1234567890", "15", "May", "1990"),
                Arguments.of("玛丽", "王", "wang@example.com", "Female", "1122334455", "10", "March", "1978"),
                Arguments.of("John", "Smith", "smith@example.com", "Other", "0987654321", "22", "November", "1985")
        );
    }


    @Feature("Practice Form")
    @Story("Student Registration Form")
    @Owner("telepnev")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://demoqa.com/automation-practice-form")
    @DisplayName("Тест с @MethodSource")
    @MethodSource()
    @ParameterizedTest(name = "Проверка успешной регистрации при выборе данных {0} {1} {2} {3} {4} {5} {6} {7}")
    public void userMustRegisterWithMinimumDataTest(String firstName,
                                                    String lastName,
                                                    String email,
                                                    String gender,
                                                    String phone,
                                                    String day, String month, String year) {


        step("Заполняем имя  и фамилию ", () -> {
            practiceFormPage.setFio(firstName, lastName);
        });
        step("Заполняем email", () -> {
            practiceFormPage.setEmail(email);
        });
        step("Заполняем gender", () -> {
            practiceFormPage.setGender(gender);
        });
        step("Заполняем phone", () -> {
            practiceFormPage.setMobile(phone);
        });
        step("Заполняем day, month, year", () -> {
            calendarComponent.setDate(day, month, year);
        });
        step("Отправляем заполненную форму", () -> {
            practiceFormPage.submit();
        });

        // assertions table
        checkPracticeFormPage = new CheckPracticeFormPage();
        checkPracticeFormPage.modalWindowShouldAppear();
        checkPracticeFormPage
                .checkStudentName(firstName + " " + lastName)
                .checkStudentEmail(email)
                .checkGender(gender)
                .checkMobile(phone)
                .checkDateofBirth(day + " " + month + "," + year);

        checkPracticeFormPage.closeModal();

    }

    // CsvFileSource


    @Feature("Practice Form")
    @Story("Student Registration Form")
    @Owner("telepnev")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://demoqa.com/automation-practice-form")
    @DisplayName("Тест с @CsvFileSource")
    @CsvFileSource(resources = "/test_data/minimumAmountDataTest.csv")
    @ParameterizedTest(name = "Заполняем поля с тестовыми данными : {0},  {1}, {2}, {3}, {4}, {5}, {6}, {7}")
    public void registerWithMinimumDataTest(String firstName,
                                            String lastName,
                                            String email,
                                            String gender,
                                            String phone,
                                            String day, String month, String year) {


        step("Заполняем имя  и фамилию ", () -> {
            practiceFormPage.setFio(firstName, lastName);
        });
        step("Заполняем email", () -> {
            practiceFormPage.setEmail(email);
        });
        step("Заполняем gender", () -> {
            practiceFormPage.setGender(gender);
        });
        step("Заполняем phone", () -> {
            practiceFormPage.setMobile(phone);
        });
        step("Заполняем day, month, year", () -> {
            calendarComponent.setDate(day, month, year);
        });
        step("Отправляем заполненную форму", () -> {
            practiceFormPage.submit();
        });

        // assertions table
        checkPracticeFormPage = new CheckPracticeFormPage();
        checkPracticeFormPage.modalWindowShouldAppear();
        checkPracticeFormPage
                .checkStudentName(firstName + " " + lastName)
                .checkStudentEmail(email)
                .checkGender(gender)
                .checkMobile(phone)
                .checkDateofBirth(day + " " + month + "," + year);
        checkPracticeFormPage.closeModal();
    }

    @Test
    @Feature("Practice Form")
    @Story("Student Registration Form")
    @Owner("telepnev")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://demoqa.com/automation-practice-form")
    public void errorTest() {


        step("Заполняем имя  и фамилию ", () -> {
            practiceFormPage.setFio(firstName, lastName);
        });
        step("Заполняем email", () -> {
            practiceFormPage.setEmail(email);
        });
        step("Заполняем gender", () -> {
            practiceFormPage.setGender(gender);
        });
        step("Заполняем phone", () -> {
            practiceFormPage.setMobile(phone);
        });
        step("Заполняем day, month, year", () -> {
            calendarComponent.setDate(day, month, year);
        });
        step("Очищаем ранее заполненные даты календаря", () -> {
            calendarComponent.clearDate();
        });
        step("Отправляем заполненную форму", () -> {
            practiceFormPage.submit();
        });
        // assertions table
        checkPracticeFormPage = new CheckPracticeFormPage();
        checkPracticeFormPage.modalWindowShouldBeVizible();
    }


    // CsvSource


    @Feature("Practice Form")
    @Story("Student Registration Form")
    @Owner("telepnev")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://demoqa.com/automation-practice-form")
    @DisplayName("Тест с @CsvSource")
    @CsvSource(value = {
            " '' | '' ",
            "!@#$$%^&*() | 1234567890",
            " | ",
            " Petrov 123!@ () | Petrov !@#$$%^&*()",
            " \uD83D\uDE0A |  \uD83E\uDD14",
            " null | 0leg",
            " 0leg | null"
    }, delimiter = '|')
    @ParameterizedTest(name = "Проверка с некорректным именем {0} и фамилией {1}")
    public void negativeSendFormWithoutData(String firstName, String lastName) {


        step("Заполняем имя  и фамилию ", () -> {
            practiceFormPage.setFio(firstName, lastName);
        });
        step("Отправляем заполненную форму", () -> {
            practiceFormPage.submit();
        });
        checkPracticeFormPage = new CheckPracticeFormPage();
        checkPracticeFormPage.modalWindowShouldNotAppear();
    }

    @Test
    @Feature("Practice Form")
    @Story("Student Registration Form")
    @Owner("telepnev")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://demoqa.com/automation-practice-form")
    @Disabled("JIRA - 1234567")
    public void practiceFormTest() {

        practiceFormPage.setFio(firstName, lastName);
        practiceFormPage.setEmail(email);
        practiceFormPage.setGender(gender);
        practiceFormPage.setMobile(phone);
        calendarComponent.setDate(day, month, year);
        practiceFormPage.setSubjects(subject);
        practiceFormPage.setHobbies(hobbies);
        practiceFormPage.upLoadImg(picture);
        practiceFormPage.setCurrentAddress(currentAddress);
        practiceFormPage.setStateandCity(state, city);
        practiceFormPage.submit();

        // assertions table
        checkPracticeFormPage = new CheckPracticeFormPage();
        checkPracticeFormPage.modalWindowShouldAppear();
        checkPracticeFormPage
                .checkStudentName(firstName + " " + lastName)
                .checkStudentEmail(email)
                .checkGender(gender)
                .checkMobile(phone)
                .checkDateofBirth(day + " " + month + "," + year)
                .checkSubjects(subject)
                .checkHobbies(hobbies)
                .checkPicture(picture)
                .checkAddress(currentAddress)
                .checkStateandCity(state + " " + city);
        checkPracticeFormPage.closeModal();
    }
}
