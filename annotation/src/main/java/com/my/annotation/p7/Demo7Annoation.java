package com.my.annotation.p7;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author : chengdu
 * @date :  2023/7/8-07
 **/
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.ANNOTATION_TYPE,ElementType.TYPE})
public @interface Demo7Annoation {

    /**
     * 报告分组
     *
     * @return
     */
    public GroupTypeEnum typeEnum() default GroupTypeEnum.GROUP_TYPE_ONE_ENUM;
}
