package org.rangiffler.test.web;

import io.qameta.allure.AllureId;
import org.junit.jupiter.api.Test;
import org.rangiffler.pages.MainPage;

public class LoginTest extends BaseWebTest {


    @Test
    @AllureId("9000:1001")
    void positiveLoginTest() {
        new MainPage().open()
                .clickLogin()
                .doLogin("yaro", "secret");
    }
}
