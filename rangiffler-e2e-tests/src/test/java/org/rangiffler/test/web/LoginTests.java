package org.rangiffler.test.web;

import io.qameta.allure.AllureId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.rangiffler.jupiter.annotation.GenerateUser;
import org.rangiffler.model.UserJson;

import static org.rangiffler.jupiter.Category.*;
import static org.rangiffler.utils.DataUtils.generateRandomPassword;
import static org.rangiffler.utils.DataUtils.generateRandomUsername;

@DisplayName("WEB: AUTH TESTS")
public class LoginTests extends BaseWebTest {

    @Test
    @Tags({@Tag(WEB), @Tag(POSITIVE)})
    @AllureId("9000:1001")
    @DisplayName("Travel Page should load on successful login Test")
    void travelsPageShouldLoadOnSuccessfulLogin() {
        mainPage()
                .open()
                .clickLogin()
                .doLogin("yaro", "secret")
                .travelsPage().verifyPageLoaded();
    }

    @Test
    @Tags({@Tag(WEB), @Tag(NEGATIVE)})
    @AllureId("9000:1002")
    @DisplayName("Bad Credentials should be displayed when wrong password is used")
    void badCredentialsShouldBeDisplayedWhenWrongPasswordUsed() {
        mainPage()
                .open()
                .clickLogin()
                .doLogin("yaro", generateRandomPassword())
                .loginPage().verifyErrorMessage("Bad credentials");
    }

    @Test
    @Tags({@Tag(WEB), @Tag(NEGATIVE)})
    @AllureId("9000:1003")
    @DisplayName("Bad Credentials should be displayed when non-existent username is used")
    void badCredentialsShouldBeDisplayedWhenNonExistentUsernameUsed() {
        mainPage()
                .open()
                .clickLogin()
                .doLogin(generateRandomUsername(), generateRandomPassword())
                .loginPage().verifyErrorMessage("Bad credentials");
    }

}
