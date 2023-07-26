package org.rangiffler.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

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
            signUpLnk = $(byText("Sign up!"));

    @Override
    public LoginPage verifyPageLoaded() {
        $("form__header").shouldHave(text("Login to Rangiffler"));
        return this;
    }

    @Step("Type into Username field {username}")
    public LoginPage typeUsername(String username) {
        usernameFld.setValue(username);
        return this;
    }

    @Step("Type into Password field {password}")
    public LoginPage typePassword(String password) {
        passwordFld.setValue(password);
        return this;
    }

    @Step("Click Sign In button")
    public LoginPage clickSignInBtn() {
        signInBtn.click();
        return this;
    }

    @Step("Click Sign Up link")
    public LoginPage clickSignUp() {
        signUpLnk.click();
        return this;
    }

    @Step("Login")
    public YourTravelsPage doLogin(String username, String password) {
        typeUsername(username).typePassword(password).clickSignInBtn();
        travelsPage().verifyPageLoaded();
        return travelsPage();
    }

}
