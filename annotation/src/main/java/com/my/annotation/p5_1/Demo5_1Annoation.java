package com.my.annotation.p5_1;

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
public @interface Demo5_1Annoation {

    /**
     * 可以使用的class
     * @return
     */
    Class<?> useUserClass();

    /**
     * 危险的class
     * @return
     */
    Class<?> dangleUseClass() ;

    /**
     * 包描述
     * @return
     */
    String desc() ;

}
