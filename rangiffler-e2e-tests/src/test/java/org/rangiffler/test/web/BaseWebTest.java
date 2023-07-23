package org.rangiffler.test.web;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;

public class BaseWebTest {

    @Test
    void simpleTest() {
        firstMethod();
        secondMethod();
        thirdMethod();
        fourthMethod();
    }

    @Step("First method")
    private void firstMethod() {
        innerFirstMethod();
    }

    @Step("Inner first method")
    private void innerFirstMethod() {
    }

    @Step("Second method")
    private void secondMethod() {
    }

    @Step("Third method")
    private void thirdMethod() {
    }

    @Step("Fourth method")
    private void fourthMethod() {
    }

}
