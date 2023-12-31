package org.rangiffler.test.web;

import org.rangiffler.config.Config;
import org.rangiffler.jupiter.annotation.WebTest;
import org.rangiffler.pages.*;

@WebTest
public abstract class BaseWebTest {

    private MainPage mainPage;

    public MainPage mainPage() {
        return mainPage == null ? new MainPage() : mainPage;
    }

}
