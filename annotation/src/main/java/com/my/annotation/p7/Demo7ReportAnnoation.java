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
@Target(value = {ElementType.TYPE})
public @interface Demo7ReportAnnoation {
    /**
     * 报告标题
     * @return
     */
    String title();

    /**
     * 报告段落
     * @return
     */
    String[] strings() ;

}
