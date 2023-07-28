package org.rangiffler.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage<LoginPage> {

    public final static String URL = "/login";

    private final SelenideElement
            usernameFld = $(byName("username")),
            passwordFld = $(byName("password")),
            signInBtn = $(byText("Sign In")),
            signUpLnk = $(byText("Sign up!")),
            fromError = $(".form__error");

    @Override
    public LoginPage verifyPageLoaded() {
        $("form__header").shouldHave(text("Login to Rangiffler"));
        return this;
    }

    @Step("Type into Username field {username}")
    public void typeUsername(String username) {
        usernameFld.setValue(username);
    }

    @Step("Type into Password field {password}")
    public void typePassword(String password) {
        passwordFld.setValue(password);
    }

    @Step("Click Sign In button")
    public void clickSignInBtn() {
        signInBtn.click();
    }

    @Step("Click Sign Up link")
    public LoginPage clickSignUp() {
        signUpLnk.click();
        return this;
    }

    @Step("Login")
    public LoginPage doLogin(String username, String password) {
        typeUsername(username);
        typePassword(password);
        clickSignInBtn();
        return this;
    }

    @Step("Verify error message {errorMessage}")
    public void verifyErrorMessage(String errorMessage) {
        fromError.shouldHave(text(errorMessage));
    }
}
