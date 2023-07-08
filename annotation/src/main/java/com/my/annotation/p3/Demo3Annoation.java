package com.my.annotation.p3;

import java.lang.annotation.*;

/**
 * @author : chengdu
 * @date :  2023/7/8-07
 **/
@Inherited
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD, ElementType.FIELD,ElementType.TYPE})
public @interface Demo3Annoation {
    String name() default "";

    String title()default "" ;


}
