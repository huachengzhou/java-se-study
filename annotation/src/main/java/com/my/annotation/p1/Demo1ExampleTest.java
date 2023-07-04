package com.my.annotation.p1;

import org.junit.Test;

import java.lang.reflect.Field;

public class Demo1ExampleTest {

    @Test
    public void test1(){
        Demo1Example demo1Example = new Demo1Example();
        demo1Example.setName("空调");
        demo1Example.setOther("U");
        Class<?> aClass = demo1Example.getClass();
        Field[] fields = aClass.getDeclaredFields();
        for (Field field:fields){
            Demo1Annotation annotation = field.getAnnotation(Demo1Annotation.class);
            if (annotation == null){
                continue;
            }
            System.out.println();
            System.out.println(annotation.desc());
            System.out.println(annotation.title());
        }
        System.out.println(aClass.getName());
    }

}
