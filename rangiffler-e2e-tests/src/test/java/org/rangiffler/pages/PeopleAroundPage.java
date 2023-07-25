package org.rangiffler.pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import org.rangiffler.pages.component.Header;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$$;

public class PeopleAroundPage extends BasePage<PeopleAroundPage> {

    private final Header header = new Header();
    private final ElementsCollection firendsTable = $$(".table tbody tr");

    public Header getHeader() {
        return header;
    }

    @Override
    public PeopleAroundPage checkThatPageLoaded() {
        return null;
    }

    @Step("Verify Friends table not empty")
    public PeopleAroundPage verifyFriendsTableNotEmpty() {
        firendsTable.shouldHave(sizeGreaterThan(0));
        return this;
    }
}
