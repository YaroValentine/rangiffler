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
            submitBtn = $("button[type='submit']"),
            currencyDdl = $(" css-1hb7zxy-IndicatorsContainer"),
            categoryNameFld = $(byText("Add new category")),
            createBtn = $(byText("Create")),
            chooseFileForAvatarBtn = $("edit-avatar__input"),
            spendingCategoriesTbl = $(".main-content__section-categories ul");

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

    @Step("Type Category Name: {name}")
    public ProfileComponent typeCategoryName(String name) {
        categoryNameFld.setValue(name);
        return this;
    }

    @Step("Click Create button")
    public ProfileComponent clickCreateBtn() {
        createBtn.click();
        return this;
    }

    @Step("Click on Avatar")
    public ProfileComponent clickOnAvatar() {
        profileAvatar.click();
        return this;
    }

    @Step("Upload Photo: {file}")
    public ProfileComponent uploadPhoto(File file) {
        chooseFileForAvatarBtn.uploadFile(file);
        return this;
    }

    @Step("Verify Spending Category exists in All Your Spending Categories table")
    public ProfileComponent verifySpendingExistsInAllYourSpendingCategoriesTable(String spend) {
        spendingCategoriesTbl.shouldHave(text(spend));
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
