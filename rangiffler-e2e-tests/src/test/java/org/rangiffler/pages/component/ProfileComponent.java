package org.rangiffler.pages.component;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.rangiffler.pages.BasePage;

import java.io.File;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProfileComponent extends BasePage<ProfileComponent> {

    final SelenideElement
            profileAvatar = $("profile__avatar"),
            firstNameFld = $("input[name='firstname']"),
            sureNameFld = $("input[name='lastname']"),
            submitBtn = $("button[type='submit']"),
            uploadAvatarBtn = $("svg[data-testid=AddAPhotoIcon]"),
            userName = $x("//p[contains(@class,'body2 css-e784if')]");

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

    @Step("Upload an Avatar")
    public ProfileComponent clickOnAvatar(File file) {
        profileAvatar.uploadFile(file);
        return this;
    }

    @Step("Verify Name equals: {name}")
    public ProfileComponent verifyFirstNameEquals(String name) {
        firstNameFld.shouldHave(value(name));
        return this;
    }

    @Step("Verify Surname equals: {name}")
    public ProfileComponent verifySurnameEquals(String name) {
        sureNameFld.shouldHave(value(name));
        return this;
    }

    @Step("Verify Username equals: {username}")
    public ProfileComponent verifyUsernameEquals(String username) {
        userName.shouldHave(value(username));
        return this;
    }

}
