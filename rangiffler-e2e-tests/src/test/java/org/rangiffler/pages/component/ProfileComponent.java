package org.rangiffler.pages.component;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.rangiffler.pages.BasePage;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ProfileComponent extends BasePage<ProfileComponent> {

    public final static String URL = "/profile";

    final SelenideElement
            profileAvatar = $("profile__avatar"),
            firstNameFld = $("input[name='firstname']"),
            sureNameFld = $("input[name='surname']"),
            submitBtn = $("button[type='submit']")
     ;

    @Override
    public ProfileComponent verifyPageLoaded() {
        profileAvatar.should(visible);
        return this;
    }

    @Step("Type Name: {name}")
    public ProfileComponent typeName(String name) {
        firstNameFld.setValue(name);
        return this;
    }

    @Step("Type Surname: {name}")
    public ProfileComponent typeSurname(String name) {
        sureNameFld.setValue(name);
        return this;
    }

    @Step("Click Submit button")
    public ProfileComponent clickSubmitBtn() {
        submitBtn.click();
        return this;
    }


    @Step("Click on Avatar")
    public ProfileComponent clickOnAvatar() {
        profileAvatar.click();
        return this;
    }

    @Step("Verify Name equals: {name}")
    public ProfileComponent verifyNameEquals(String name) {
        firstNameFld.shouldHave(value(name));
        return this;
    }

    @Step("Verify Surname equals: {name}")
    public ProfileComponent verifySurnameEquals(String name) {
        sureNameFld.shouldHave(value(name));
        return this;
    }


}
