package com.my.aop.service;

import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author : chengdu
 * @date :  2023/7/8-07
 **/
@Component
public class HelloWorld {

    public String sayHello(String name){
        System.out.println("你好啊"+name+"!");
        return name+ UUID.randomUUID().toString();
    }

}
