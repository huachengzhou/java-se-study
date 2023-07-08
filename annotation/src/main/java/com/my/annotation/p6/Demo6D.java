package com.my.annotation.p6;

import java.lang.annotation.Annotation;
import java.util.Arrays;

/**
 * @author : chengdu
 * @date :  2023/7/8-07
 **/
public class Demo6D   extends DemoParent{


    public void sumTotal(Object price,Object num){

        @Demo6Annoation(type = Double.class)
         Object a1 = price;

        @Demo6Annoation(type = Integer.class)
        Object a2 = num;
        Annotation[] annotations = a2.getClass().getAnnotations();

        System.out.println(Arrays.toString(annotations));


    }

}
