package org.rangiffler.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static org.rangiffler.config.InitConfig.CFG;

public class MainPage extends BasePage<MainPage> {
    private final SelenideElement loginBtn = $(byText("Login"));
    private final SelenideElement registerBtn = $(byText("Register"));

    @Override
    public MainPage verifyPageLoaded() {
        $(byText("Be like Rangiffler")).should(visible);
        return this;
    }

    @Step("Open Main page")
    public MainPage open() {
        Selenide.open(CFG.getFrontUrl());
        verifyPageLoaded();
        return this;
    }

    @Step("Click Login button")
    public LoginPage clickLogin() {
        loginBtn.click();
        return loginPage();
    }

    @Step("Click Register button")
    public RegistrationPage clickRegistration() {
        registerBtn.click();
        return registrationPage();
    }

}
