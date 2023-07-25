package org.rangiffler.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage<LoginPage> {

    public final static String URL = "/login";

    private final SelenideElement
            loginBtn = $(byText("Login")),
            registerBtn = $(byText("Register")),
            usernameFld = $(byName("username")),
            passwordFld = $(byName("password")),
            signInBtn = $(byText("Sign In")),
            signUpLnk = $(byText("Sign up!"));

    @Override
    public LoginPage checkThatPageLoaded() {
        $("main__header").shouldHave(Condition.text("Welcome to magic journey with Niffler. The coin keeper"));
        return this;
    }

    @Step("Click Login button")
    public LoginPage clickLoginBtn() {
        loginBtn.click();
        return this;
    }

    @Step("Click Registration button")
    public RegistrationPage clickRegisterBtn() {
        registerBtn.click();
        return new RegistrationPage();
    }

    @Step("Type into Username field")
    public LoginPage typeUsername(String username) {
        usernameFld.setValue(username);
        return this;
    }

    @Step("Type into Password field")
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
        clickLoginBtn()
                .typeUsername(username)
                .typePassword(password)
                .clickSignInBtn();
        return new YourTravelsPage();
    }


}
