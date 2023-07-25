package org.rangiffler.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.rangiffler.pages.component.Header;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class FriendsTravelsPage extends BasePage<FriendsTravelsPage> {

    public static final String URL = "/main";
    private final Header header = new Header();
    private final ElementsCollection spendingRows = $(".spendings-table tbody").$$("tr");
    private final SelenideElement deleteSelectedBtn = $(byText("Delete selected"));


    public Header getHeader() {
        return header;
    }

    @Override
    public FriendsTravelsPage checkThatPageLoaded() {
        getHeader().checkThatComponentDisplayed();
        return this;
    }

    @Step("Select Spending by description: {spendDescription}")
    public FriendsTravelsPage selectSpendingByDescription(String spendDescription) {
        spendingRows.find(text(spendDescription))
                .$$("td").first().scrollTo()
                .click();
        return this;
    }

    @Step("Click Delete Selected")
    public FriendsTravelsPage clickDeleteSelected() {
        deleteSelectedBtn.click();
        return this;
    }

    @Step("Verify Spending table is empty")
    public void verifySpendingTableIsEmpty() {
        spendingRows.shouldHave(size(0));
    }

    @Step("Delete Spending: {spendDescription}")
    public FriendsTravelsPage deleteSpending(String description) {
        selectSpendingByDescription(description)
                .clickDeleteSelected()
                .verifySpendingTableIsEmpty();
        return this;
    }


}
