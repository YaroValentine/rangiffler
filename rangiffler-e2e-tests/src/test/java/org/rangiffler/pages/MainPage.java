package org.rangiffler.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage<MainPage> {
    private final SelenideElement loginButton = $(byText("Login"));
    private final SelenideElement registerButton = $(byText("Register"));
    @Override
    @Step("Check load LandingPage")
    public MainPage checkThatPageLoaded() {
        loginButton.should(visible);
        registerButton.should(visible);
        return this;
    }

    @Step("Open LandingPage")
    public MainPage open() {
        return Selenide.open(""/*configEnv.frontUrl()*/, MainPage.class);
    }

    @Step("Click Login button")
    public LoginPage toLogin() {
        loginButton.click();
        return new LoginPage();
    }

    @Step("Click Register button")
    public RegistrationPage toRegistration() {
        registerButton.click();
        return new RegistrationPage();
    }
}
