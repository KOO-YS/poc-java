package com.example.customize.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface CustomLog {
    enum Level{DEBUG, INFO, WARN, ERROR}

    Level level() default Level.INFO;
}
