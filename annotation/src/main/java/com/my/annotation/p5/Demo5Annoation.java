package com.my.annotation.p5;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author : chengdu
 * @date :  2023/7/8-07
 **/
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.PACKAGE})
public @interface Demo5Annoation {

    /**
     *  所有class
     * @return Class<?>[]
     */
    Class<?>[] classList() default {
            String.class,
            Double.class,
    };

    /**
     * 允许使用的class
     * @return Class<?>[]
     */
    Class<?>[]  useClass() default {} ;

    /**
     * 描述
     * @return String
     */
    String desc()default "" ;

}
