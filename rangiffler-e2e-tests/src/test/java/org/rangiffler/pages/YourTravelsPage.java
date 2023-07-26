package org.rangiffler.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class YourTravelsPage extends BasePage<YourTravelsPage> {

    private final SelenideElement
            zoomInBtn = $("svg[data-testid='ZoomInIcon']"),
            zoomOutBtn = $("svg[data-testid='ZoomOutIcon']"),
            worldMap = $x("//figure");
    private final ElementsCollection addedPhotos = $$(byXpath("//li[contains(@class, 'MuiImageListItem-root')]"));

    @Override
    @Step("Verify Your Travels page loaded")
    public YourTravelsPage verifyPageLoaded() {
        worldMap.shouldBe(visible);
        return this;
    }

    @Step("Click Zoom In button")
    public YourTravelsPage clickZoomInButton() {
        zoomInBtn.click();
        return this;
    }

    @Step("Click Zoom Out button")
    public YourTravelsPage clickZoomOutButton() {
        zoomOutBtn.click();
        return this;
    }

    @Step("Verify Zoom In button has changed state to Zoom Out")
    public YourTravelsPage verifyZoomInButtonHasChangedStateToZoomOut() {
        zoomOutBtn.shouldHave(attribute("data-testid", "ZoomOutIcon"));
        return this;
    }

    @Step("Verify Zoom Out button has changed state to Zoom In")
    public void verifyZoomOutButtonHasChangedStateToZoomIn() {
        zoomInBtn.shouldHave(attribute("data-testid", "ZoomInIcon"));
    }

    @Step("Users photos exist")
    public YourTravelsPage verifyUsersPhotosExist() {
        addedPhotos.shouldHave(sizeGreaterThan(0));
        return this;
    }

    @Step("Open first photo")
    public YourTravelsPage openFirstPhoto() {
        addedPhotos.first().click();
        photoComponent().verifyComponentDisplayed();
        return this;
    }

}
