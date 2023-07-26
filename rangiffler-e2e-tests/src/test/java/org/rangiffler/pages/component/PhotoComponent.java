package org.rangiffler.pages.component;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.rangiffler.pages.YourTravelsPage;
import org.rangiffler.utils.DataUtils;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.rangiffler.utils.TestUtils.selectRandomUnique;

public class PhotoComponent extends BaseComponent<PhotoComponent> {

    //region Locators
    private final SelenideElement
            photoComponent = $x("//div[contains(@class, 'css-2632uw')]"),
            editBtn = $("[data-testid='EditIcon']"),
            deleteBtn = $("[data-testid='DeleteOutlineIcon']"),
            closeBtn = $("[data-testid='CloseIcon']"),
            saveBtn = $("button[type='submit']"),
            countryName = $x("//p[contains(@class, 'MuiTypography-gutterBottom css-18k87ye')]"),
            countryDropDwn = $x("//div[contains(@class, 'css-jedpe8-MuiSelect-select-MuiInputBase')]"),
            description = $x("//p[contains(@class, 'MuiTypography-body2 css-e784if')]"),
            descriptionFld = $x("//textarea[contains(@class, 'MuiInputBase-inputSizeSmall css-12tl3rr') and @id=':rd:']");
    private final ElementsCollection countryOptions = $$x("//li[contains(@class, 'MuiMenuItem-gutters css-kk1bwy')]");
    //endregion

    public PhotoComponent() {
        super($x("//div[contains(@class, 'css-2632uw')]"));
    }

    @Override
    public PhotoComponent verifyComponentDisplayed() {
        photoComponent.shouldBe(visible);
        return this;
    }

    @Step("Click Edit photo")
    public PhotoComponent clickEditPhoto() {
        editBtn.click();
        return this;
    }

    @Step("Click Delete photo")
    public PhotoComponent clickDeletePhoto() {
        deleteBtn.click();
        return this;
    }

    @Step("Click Close photo")
    public PhotoComponent clickClosePhoto() {
        closeBtn.click();
        return this;
    }

    @Step("Verify Country Name of photo")
    public PhotoComponent verifyCountryNameEqual(String expectCountryName) {
        countryName.shouldHave(text(expectCountryName));
        return this;
    }

    @Step("Verify Description of photo")
    public PhotoComponent verifyDescriptionEqual(String expectDescription) {
        description.shouldHave(text(expectDescription));
        return this;
    }

    @Step("Select Country '{countryName}'")
    public PhotoComponent selectCountry(String countryName) {
        countryDropDwn.selectOption(countryName);
        return this;
    }

    @Step("Set Description '{description}'")
    public PhotoComponent setDescription(String description) {
        Selenide.sleep(500);
        descriptionFld.shouldBe(editable).clear();
        descriptionFld.setValue(description);
        return this;
    }

    private String getCurrentCountryName() {
        return countryName.getText();
    }

    private String getCurrentDescription() {
        return description.getText();
    }

    @Step("Click Save photo")
    public PhotoComponent clickSavePhoto() {
        saveBtn.click();
        return this;
    }

    @Step("Verify can change Country name")
    public void verifyCanChangeCountry() {
        String oldCountryName = getCurrentCountryName();
        clickEditPhoto();
        selectRandomCountry();
        clickSavePhoto();
        new YourTravelsPage().openFirstPhoto();
        String newCountryName = getCurrentCountryName();

        Assertions.assertNotEquals(oldCountryName, newCountryName);
    }

    @Step("Select random country")
    private void selectRandomCountry() {
        countryDropDwn.shouldBe(visible).click();
        ElementsCollection options = countryOptions.filter(visible);
        selectRandomUnique(options, countryDropDwn.getText());
    }

    @Step("Verify can change Description")
    public void verifyCanChangeDescription() {
        String oldDescription = getCurrentDescription();
        clickEditPhoto();
        setDescription(DataUtils.generateRandomSentence(10));
        clickSavePhoto();
        new YourTravelsPage().openFirstPhoto();
        String newDescription = getCurrentDescription();

        Assertions.assertNotEquals(oldDescription, newDescription);
    }
}
