package org.rangiffler.pages.component;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.rangiffler.pages.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class HeaderComponent extends BaseComponent<HeaderComponent> {

    private final SelenideElement mainPageBtn = $("a[href*='main']");

    private final SelenideElement
            friendsPageBtn = $("a[href*='friends']"),
            profileBtn = $(".header__avatar"),
            peopleBtn = $("a[href*='people']"),
            findsBtn = $("a[href*='friends']");
    ;

    public HeaderComponent() {
        super($(".header"));
    }

    public HeaderComponent(SelenideElement self) {
        super(self);
    }

    @Override
    public HeaderComponent verifyComponentDisplayed() {
        self.$x("//h1").shouldHave(text("Rangiffler"));
        return this;
    }

    @Step("Go to Main page")
    public MainPage goToMainPage() {
        mainPageBtn.click();
        return new MainPage();
    }

    @Step("Go to Profile page")
    public ProfileComponent goToProfilePage() {
        profileBtn.click();
        return new ProfileComponent();
    }

}
