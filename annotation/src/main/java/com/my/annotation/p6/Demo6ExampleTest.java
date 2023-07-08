package com.my.annotation.p6;

import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

/**
 * @author : chengdu
 * @date :  2023/7/8-07
 **/
public class Demo6ExampleTest {

    @Test
    public void test1()throws Exception{
        Demo6D d6 = new Demo6D();
        d6.sumTotal(20,29);
        System.out.println(Arrays.toString(d6.getClass().getMethods()));




    }

}
