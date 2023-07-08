package com.my.annotation.p2;

import org.junit.Test;

import java.lang.reflect.Field;

public class Demo2ExampleTest {

    @Test
    public void test1(){
        Demo2Example demo2Example = new Demo2Example();
        demo2Example.setName("月亮");
        demo2Example.setSheet("kdu");

        Class<? extends Demo2Example> aClass = demo2Example.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field field:declaredFields){
            Demo2Annotation annotation = field.getAnnotation(Demo2Annotation.class);
            if (annotation == null){
                continue;
            }
            System.out.println(annotation.types().getName()+" "+annotation.types());
        }
    }

}
