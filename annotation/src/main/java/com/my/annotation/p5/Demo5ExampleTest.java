package com.my.annotation.p5;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author : chengdu
 * @date :  2023/7/8-07
 **/
public class Demo5ExampleTest {


    @Test
    public void test1(){
        Package pkg = Package.getPackage("com.my.annotation.p5") ;
        Demo5Annoation annotation = pkg.getAnnotation(Demo5Annoation.class);
        System.out.println(annotation.desc());
        System.out.println(Arrays.toString(annotation.useClass()));
        System.out.println(pkg.getName());
    }
}
