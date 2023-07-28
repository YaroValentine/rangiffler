package org.rangiffler.pages;

import org.rangiffler.pages.component.HeaderComponent;

import static com.codeborne.selenide.Selenide.$;

public class FriendsTravelsPage extends BasePage<FriendsTravelsPage> {

    public static final String URL = "/main";
    private final HeaderComponent headerComponent = new HeaderComponent();

    public HeaderComponent getHeader() {
        return headerComponent;
    }

    @Override
    public FriendsTravelsPage verifyPageLoaded() {
        getHeader().verifyComponentDisplayed();
        return this;
    }




}
