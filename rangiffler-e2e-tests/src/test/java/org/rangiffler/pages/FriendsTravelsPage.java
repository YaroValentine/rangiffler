package org.rangiffler.pages;

import org.rangiffler.pages.component.Header;

import static com.codeborne.selenide.Selenide.$;

public class FriendsTravelsPage extends BasePage<FriendsTravelsPage> {

    public static final String URL = "/main";
    private final Header header = new Header();

    public Header getHeader() {
        return header;
    }

    @Override
    public FriendsTravelsPage verifyPageLoaded() {
        getHeader().verifyComponentDisplayed();
        return this;
    }




}
