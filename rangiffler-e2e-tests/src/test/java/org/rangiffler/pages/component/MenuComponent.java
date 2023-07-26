package org.rangiffler.pages.component;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MenuComponent {
    SelenideElement
            yourTravelsBtn = $(byText("Your travels")),
            friendsTravelsBtn = $(byText("Friends travels")),
            peopleAroundBtn = $(byText("People Around"));

}
