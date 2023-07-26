package org.rangiffler.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.rangiffler.pages.component.HeaderComponent;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class YourTravelsPage extends BasePage<YourTravelsPage> {

    private final HeaderComponent headerComponent = new HeaderComponent();
    private final SelenideElement
            zoomInBtn = $("svg[data-testid='ZoomInIcon']"),
            zoomOutBtn = $("svg[data-testid='ZoomOutIcon']"),
            worldMap = $x("//figure");
    private final ElementsCollection addedPhotos = $$(byXpath("//li[contains(@class, 'MuiImageListItem-root')]"));

    public HeaderComponent getHeader() {
        return headerComponent;
    }

    @Override
    @Step("Verify Your Travels page loaded")
    public YourTravelsPage verifyPageLoaded() {
        worldMap.shouldBe(visible);
        return this;
    }


}
