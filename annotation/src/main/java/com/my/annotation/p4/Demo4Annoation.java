package com.my.annotation.p4;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author : chengdu
 * @date :  2023/7/8-07
 **/
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.PARAMETER})
public @interface Demo4Annoation {

    public String name() default "";

    public String defaultValue() default "";

}
