package org.rangiffler.jupiter.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface GenerateUser {

    String username() default "";

    String password() default "";

    String avatar() default "";

    Photo[] photos() default {};

    Friend[] friends() default {};

    Friend[] outcomeInvitations() default {};

    Friend[] incomeInvitations() default {};

}
