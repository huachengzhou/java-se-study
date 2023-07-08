package com.my.annotation.p5_1;

import org.junit.Test;

/**
 * @author : chengdu
 * @date :  2023/7/8-07
 **/
public class Demo5_1DemoTest {


    @Test
    public void test1(){
        Package pkg = Package.getPackage("com.my.annotation.p5_1") ;

        Demo5_1Annoation annotation = pkg.getAnnotation(Demo5_1Annoation.class);

        System.out.println(annotation.dangleUseClass());
        System.out.println(annotation.useUserClass());
        System.out.println(pkg.getName());
        System.out.println(Constant.USER_NAME +" "+Constant.PASS_WORD);

    }
}
