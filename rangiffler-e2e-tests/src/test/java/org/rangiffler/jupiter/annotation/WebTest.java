package org.rangiffler.jupiter.annotation;


import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.extension.ExtendWith;
import org.rangiffler.jupiter.extension.ApiLoginExtension;
import org.rangiffler.jupiter.extension.BrowserExtension;
import org.rangiffler.jupiter.extension.GenerateUserExtension;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith({
        AllureJunit5.class,
        BrowserExtension.class,
        GenerateUserExtension.class,
        ApiLoginExtension.class
})
public @interface WebTest {

}
