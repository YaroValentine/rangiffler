package org.rangiffler.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.rangiffler.pages.component.HeaderComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PeopleAroundPage extends BasePage<PeopleAroundPage> {

    private final HeaderComponent headerComponent = new HeaderComponent();
    private final SelenideElement
            peopleAroundTbl = $("[aria-label='all people table']"),
            tblHead = $(byXpath("//thead[@class='MuiTableHead-root css-15wwp11-MuiTableHead-root']"));

    private final ElementsCollection users = $$("[aria-label='all people table']");

    public HeaderComponent getHeader() {
        return headerComponent;
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
