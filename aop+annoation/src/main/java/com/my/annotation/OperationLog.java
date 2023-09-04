package com.my.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD ,ElementType.FIELD ,ElementType.TYPE})
public @interface OperationLog {

    /**
     * 传入需要获取的参数，可在default设置默认值
     */
    String moduleName() default "内容管理";

    /**
     * 操作类型
     */
    String operateType();

    /**
     * 传入需要获取的参数，可在default设置默认值
     */
    String methodParamName() default "";

    /**
     * 操作描述
     */
    String operateDesc()default "";

}
