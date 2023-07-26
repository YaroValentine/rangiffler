package org.rangiffler.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.rangiffler.pages.component.Header;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class YourTravelsPage extends BasePage<YourTravelsPage> {

    private final Header header = new Header();
    private final SelenideElement
            yourTravelsBtn = $(byText("Your travels")),
            friendsTravelsBtn = $(byText("Friends travels")),
            peopleAroundBtn = $(byText("People Around")),
            zoomInBtn = $("svg[data-testid='ZoomInIcon']"),
            zoomOutBtn = $("svg[data-testid='ZoomOutIcon']"),
            worldMap = $x("//figure");
    private final ElementsCollection addedPhotos = $$(byXpath("//li[contains(@class, 'MuiImageListItem-root')]"));

    public Header getHeader() {
        return header;
    }

    @Override
    @Step("Verify Your Travels page loaded")
    public YourTravelsPage verifyPageLoaded() {
        worldMap.shouldBe(visible);
        return this;
    }


}
