package org.rangiffler.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.rangiffler.config.Config;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage extends BasePage<RegistrationPage> {

    public static final String URL = Config.getConfig().getAuthUrl() + "/register";
    private final SelenideElement
            header = $(".form__header"),
            usernameInput = $("#username"),
            passwordInput = $("#password"),
            passwordSubmitInput = $("#passwordSubmit"),
            signUpBtn = $("button[type='submit']"),
            formError = $(".form__error");

    @Override
    public RegistrationPage verifyPageLoaded() {
        header.shouldHave(text("Register to Rangiffler"));
        return this;
    }

    @Step("Fill registration form: username: {0}, password: {1}, passwordSubmit: {2}")
    public RegistrationPage fillRegistrationForm(String username, String password, String passwordSubmit) {
        usernameInput.val(username);
        passwordInput.val(password);
        passwordSubmitInput.val(passwordSubmit);
        signUpBtn.click();
        return this;
    }

    @Step("Verify 'Congratulations! You've registered!' message displayed")
    public void verifySuccessfulRegistrationMessageDisplayed() {
        $(byText("Congratulations! You've registered!")).shouldBe(visible);
    }

    @Step("Verify 'Allowed username length should be from 3 to 50 characters' message displayed")
    public void verifyAllowedUsernameCriteriaMessageDisplayed() {
        $(byText("Allowed username length should be from 3 to 50 characters")).shouldBe(visible);
    }

    @Step("Verify 'Allowed password length should be from 3 to 12 characters' message displayed")
    public void verifyAllowedPasswordCriteriaMessageDisplayed() {
        $(byText("Allowed password length should be from 3 to 12 characters")).shouldBe(visible);
    }

    @Step("Verify 'Passwords should be equal' message displayed")
    public void verifyPasswordsShouldMatchMessageDisplayed() {
        $(byText("Passwords should be equal")).shouldBe(visible);
    }

    @Step("Verify 'Username `{username}` already exists' message displayed")
    public void verifyUserAlreadyExistsMessageDisplayed(String username) {
        $(byText(String.format("Username `%s` already exists", username))).shouldBe(visible);
    }

}
