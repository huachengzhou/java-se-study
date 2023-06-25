package com.study.design.pattern.proxy_pattern;

import org.junit.Test;

/**
 * @author : chengdu
 * @date :  2023/6/25-06
 **/
public class ClientDemo1 {

    /*
        代理类
     */
    @Test
    public void test1(){
        ClientDemo clientDemo = new ClientDemo();
        clientDemo.run();
    }

}
