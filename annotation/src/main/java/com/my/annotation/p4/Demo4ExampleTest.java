package com.my.annotation.p4;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author : chengdu
 * @date :  2023/7/8-07
 **/
public class Demo4ExampleTest {

    @Test
    public void test1()throws Exception{
        Class<?> aClass = Class.forName("com.my.annotation.p4.Demo4Run");
        Method[] methods = aClass.getDeclaredMethods();
        for (Method method:methods){
            System.out.println("参数数量:"+method.getParameterCount());
            System.out.println(Arrays.toString(method.getParameterTypes()));
            System.out.println(Arrays.toString(method.getParameterAnnotations()));

            // 二维数组遍历，第一维是参数的个数，第二维是具体的注解值
            for (Annotation[] annotations:method.getParameterAnnotations()){
                //注解遍历
                for (Annotation annotation:annotations){
                    if (annotation instanceof Demo4Annoation){
                        Demo4Annoation demo4Annoation = (Demo4Annoation)annotation;
                        System.out.println(demo4Annoation.name());
                        System.out.println(demo4Annoation.defaultValue());
                    }
                }
            }
            System.out.println(method.getName());
        }
    }

}
