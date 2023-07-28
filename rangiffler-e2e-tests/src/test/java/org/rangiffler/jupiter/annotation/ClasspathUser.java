package org.rangiffler.jupiter.annotation;

import org.junit.jupiter.params.converter.ConvertWith;
import org.rangiffler.jupiter.extension.ClasspathUserConverter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@ConvertWith(ClasspathUserConverter.class)
public @interface ClasspathUser {

}
