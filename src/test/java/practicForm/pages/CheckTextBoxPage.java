package practicForm.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CheckTextBoxPage {
    protected SelenideElement name = $("#output").$("#name");
    protected SelenideElement email = $("#output").$("#email");
    protected SelenideElement currentAddress = $("#output #currentAddress");
    protected SelenideElement permanentAddress = $("#output #permanentAddress");

    public CheckTextBoxPage checkName(String str) {
        name.shouldHave(text(str));
        return this;
    }

    public CheckTextBoxPage checkEmail(String str) {
        email.shouldHave(text(str));
        return this;
    }

    public CheckTextBoxPage checkCurrentAddress(String str) {
        currentAddress.shouldHave(text(str));
        return this;
    }

    public CheckTextBoxPage checkPermanentAddress(String str) {
        permanentAddress.shouldHave(text(str));
        return this;
    }
}
