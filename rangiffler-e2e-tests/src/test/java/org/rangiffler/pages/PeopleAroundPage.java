package org.rangiffler.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.rangiffler.pages.component.Header;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PeopleAroundPage extends BasePage<PeopleAroundPage> {

    private final Header header = new Header();
    private final SelenideElement
            peopleAroundTbl = $("[aria-label='all people table']"),
            tblHead = $(byXpath("//thead[@class='MuiTableHead-root css-15wwp11-MuiTableHead-root']"));

    private final ElementsCollection users = $$("[aria-label='all people table']");

    public Header getHeader() {
        return header;
    }

    @Override
    public PeopleAroundPage verifyPageLoaded() {
        tblHead.shouldBe(visible);
        return this;
    }

    @Step("Verify Friends table not empty")
    public PeopleAroundPage verifyFriendsTableNotEmpty() {
        peopleAroundTbl.shouldHave(null);
        return this;
    }
}
