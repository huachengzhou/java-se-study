package com.my.annotation.p1;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = {ElementType.FIELD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Demo1Annotation {

    String desc() default "";

    String title() default "";

    int num() default 0;

}
