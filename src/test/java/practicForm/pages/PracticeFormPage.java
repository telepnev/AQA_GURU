package practicForm.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {
    private String url = "/automation-practice-form";
    protected SelenideElement submit = $("#submit");
    protected SelenideElement firstName = $("#firstName");
    protected SelenideElement lastName = $("#lastName");
    protected SelenideElement userEmail = $("#userEmail");
    protected SelenideElement userNumber = $("#userNumber");

    public void openPracticeFormPage() {
        open(url);
    }

    public void submit() {
        $(submit).click();
    }

    public void setStateandCity(String state, String city) {
        $("#state").click();
        $x("//div[text()='" + state + "']").click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
    }

    public void setCurrentAddress(String address) {
        $("#currentAddress").setValue(address);
        $("#submit").scrollTo();
    }

    public void upLoadImg(String fileName) {
        $("#uploadPicture").uploadFromClasspath(fileName);
    }

    public void setHobbies(String hobbies) {
        $x("//label[text()='" + hobbies + "']").click();
    }

    public void setSubjects(String subject) {
        $("#subjectsContainer").click();
        $("#subjectsInput").setValue(subject).pressEnter();
    }


    public void setMobile(String phone) {
        $(userNumber).setValue(phone);
    }

    public void setGender(String gender) {
        $x("//label[text()='" + gender + "']").click();
    }

    public void setEmail(String mail) {
        $(userEmail).setValue(mail);
    }

    public void setFio(String nameFirst, String nameLast) {
        $(firstName).setValue(nameFirst);
        $(lastName).setValue(nameLast);
    }
}
