package org.rangiffler.jupiter.annotation;

import org.rangiffler.jupiter.extension.ApiLoginExtension;
import org.rangiffler.jupiter.extension.GenerateUserExtension;
import org.rangiffler.jupiter.extension.KafkaExtension;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@ExtendWith({KafkaExtension.class, AllureJunit5.class, GenerateUserExtension.class, ApiLoginExtension.class})
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface KafkaTest {
}
