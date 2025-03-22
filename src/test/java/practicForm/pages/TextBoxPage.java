package practicForm.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {
    private String url = "/text-box";
    protected SelenideElement fullNameInput = $("#userName");
    protected SelenideElement userEmailInput = $("#userEmail");
    protected SelenideElement currentAddressInput = $("#currentAddress");
    protected SelenideElement permanentAddressInput = $("#permanentAddress");
    protected SelenideElement submitButton = $("#submit");


    public TextBoxPage openTextBoxPage() {
        open(url);
        return this;
    }

    public TextBoxPage setName(String value) {
        fullNameInput.setValue(value);
        return this;
    }

    public TextBoxPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public TextBoxPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        permanentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage submit() {
        submitButton.click();
        return this;
    }
}
