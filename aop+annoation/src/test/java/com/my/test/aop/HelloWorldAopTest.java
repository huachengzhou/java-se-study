package com.my.test.aop;

import com.my.aop.service.HelloWorld;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author : chengdu
 * @date :  2023/7/9-07
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class HelloWorldAopTest {


    @Autowired
    private HelloWorld target;

    @Test
    public void test1(){
        String hello = target.sayHello("李世民");
        System.out.println(hello);
    }


}
