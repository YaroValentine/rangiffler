package org.rangiffler.test.web;

import io.qameta.allure.AllureId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static org.rangiffler.jupiter.Category.WEB;

@DisplayName("WEB: YOUR TRAVELS PAGE TESTS")
public class YourTravelsTests extends BaseWebTest {

    @Test
    @Tags({@Tag(WEB)})
    @AllureId("3001:1001")
    @DisplayName("Zoom button should change state when pressed")
    void zoomButtonShouldChangeStateWhenPressed() {
        mainPage()
                .open()
                .clickLogin()
                .doLogin("yaro", "secret")
                .travelsPage().verifyPageLoaded()
                .clickZoomInButton()
                .verifyZoomInButtonHasChangedStateToZoomOut()
                .clickZoomOutButton()
                .verifyZoomOutButtonHasChangedStateToZoomIn();
    }

    @Test
    @Tags({@Tag(WEB)})
    @AllureId("3001:1002")
    @DisplayName("User's photo collection should not be empty")
    void usersPhotoCollectionShouldBeNotEmpty() {//todo Create extension that generates user with photos
        mainPage()
                .open()
                .clickLogin()
                .doLogin("yaro", "secret")
                .travelsPage().verifyPageLoaded()
                .verifyUsersPhotosExist();
    }

    @Test
    @Tags({@Tag(WEB)})
    @AllureId("3001:1003")
    @DisplayName("User should be able to change photo's country")
    void userShouldBeAbleToChangePhotosCountry() {//todo Create extension that generates user with photos
        mainPage()
                .open()
                .clickLogin()
                .doLogin("yaro", "secret")
                .travelsPage().verifyPageLoaded()
                .verifyUsersPhotosExist()
                .openFirstPhoto()
                .photoComponent().verifyCanChangeCountry();
    }

    @Test
    @Tags({@Tag(WEB)})
    @AllureId("3001:1004")
    @DisplayName("User should be able to change photo's description")
    void userShouldBeAbleToChangePhotosDescription() {//todo Create extension that generates user with photos
        mainPage()
                .open()
                .clickLogin()
                .doLogin("yaro", "secret")
                .travelsPage().verifyPageLoaded()
                .verifyUsersPhotosExist()
                .openFirstPhoto()
                .photoComponent().verifyCanChangeDescription();
    }

}
