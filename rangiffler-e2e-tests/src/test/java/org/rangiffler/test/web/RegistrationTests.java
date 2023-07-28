package org.rangiffler.test.web;

import io.qameta.allure.AllureId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static org.rangiffler.jupiter.Category.*;
import static org.rangiffler.utils.DataUtils.generateRandomPassword;
import static org.rangiffler.utils.DataUtils.generateRandomUsername;

@DisplayName("WEB: AUTH TESTS")
public class RegistrationTests extends BaseWebTest {

    @Test
    @Tags({@Tag(WEB), @Tag(POSITIVE)})
    @AllureId("9000:2001")
    @DisplayName("Confirmation should be displayed on successful registration")
    void confirmationShouldBeDisplayedOnSuccessfulRegistration() {
        final String username = generateRandomUsername();
        final String password = generateRandomPassword();

        mainPage()
                .open()
                .clickRegistration()
                .fillRegistrationForm(username, password, password)
                .registrationPage().verifySuccessfulRegistrationMessageDisplayed();
    }

    @Test
    @Tags({@Tag(WEB), @Tag(NEGATIVE)})
    @AllureId("9000:2002")
    @DisplayName("Error should be displayed when username is less than three chars long")
    void errorShouldBeDisplayedWhenUsernameLessThanThreeCharsLong() {
        final String username = generateRandomUsername(2);
        final String password = generateRandomPassword();

        mainPage()
                .open()
                .clickRegistration()
                .fillRegistrationForm(username, password, password)
                .registrationPage().verifyAllowedUsernameCriteriaMessageDisplayed();
    }

    @Test
    @Tags({@Tag(WEB), @Tag(NEGATIVE)})
    @AllureId("9000:2003")
    @DisplayName("Error should be displayed when username is more than fifty chars long")
    void errorShouldBeDisplayedWhenUsernameMoreThanFiftyCharsLong() {
        final String username = generateRandomUsername(51);
        final String password = generateRandomPassword();

        mainPage()
                .open()
                .clickRegistration()
                .fillRegistrationForm(username, password, password)
                .registrationPage().verifyAllowedUsernameCriteriaMessageDisplayed();
    }

    @Test
    @Tags({@Tag(WEB), @Tag(NEGATIVE)})
    @AllureId("9000:2004")
    @DisplayName("Error should be displayed when password is less than three chars long")
    void errorShouldBeDisplayedWhenPasswordLessThanThreeCharsLong() {
        final String username = generateRandomUsername();
        final String password = generateRandomPassword(2);

        mainPage()
                .open()
                .clickRegistration()
                .fillRegistrationForm(username, password, password)
                .registrationPage().verifyAllowedPasswordCriteriaMessageDisplayed();
    }

    @Test
    @Tags({@Tag(WEB), @Tag(NEGATIVE)})
    @AllureId("9000:2005")
    @DisplayName("Error should be displayed when username is more than twelve chars long")
    void errorShouldBeDisplayedWhenPasswordMoreThanTwelveCharsLong() {
        final String username = generateRandomUsername();
        final String password = generateRandomPassword(13);

        mainPage()
                .open()
                .clickRegistration()
                .fillRegistrationForm(username, password, password)
                .registrationPage().verifyAllowedPasswordCriteriaMessageDisplayed();
    }

    @Test
    @Tags({@Tag(WEB), @Tag(NEGATIVE)})
    @AllureId("9000:2006")
    @DisplayName("Error should be displayed when username is more than twelve chars long")
    void errorShouldBeDisplayedWhenPasswordDontMatch() {
        final String username = generateRandomUsername();
        final String password1 = generateRandomPassword();
        final String password2 = generateRandomPassword();

        mainPage()
                .open()
                .clickRegistration()
                .fillRegistrationForm(username, password1, password2)
                .registrationPage().verifyPasswordsShouldMatchMessageDisplayed();
    }


    @Test
    @Tags({@Tag(WEB), @Tag(NEGATIVE)})
    @AllureId("9000:2007")
    @DisplayName("Error should be displayed when registering existent username")
    void errorShouldBeDisplayedWhenRegisteringExistentUser() {
        final String username = generateRandomUsername();
        final String password = generateRandomPassword();

        mainPage()
                .open()
                .clickRegistration()
                .fillRegistrationForm(username, password, password)
                .registrationPage().verifySuccessfulRegistrationMessageDisplayed();

        mainPage()
                .open()
                .clickRegistration()
                .fillRegistrationForm(username, password, password)
                .registrationPage().verifyUserAlreadyExistsMessageDisplayed(username);
    }
}
