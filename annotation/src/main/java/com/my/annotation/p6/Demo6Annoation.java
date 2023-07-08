package com.my.annotation.p6;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author : chengdu
 * @date :  2023/7/8-07
 **/
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.LOCAL_VARIABLE})
public @interface Demo6Annoation {

    /**
     * 描述
     * @return
     */
    public String desc()default "" ;

    public Class<?> type();

}
