package org.rangiffler.pages;

import io.qameta.allure.Step;

public abstract class BasePage<T extends BasePage> {

    @Step("Check that Page loaded")
    public abstract T checkThatPageLoaded();
}
