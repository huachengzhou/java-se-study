package com.study.design.pattern.proxy_pattern;

/**
 * @author : chengdu
 * @date :  2023/6/25-06
 **/
public class ClientDemo {

    public void run(){
        SchoolGirl girl = new SchoolGirl("黄蓉") ;

        // Proxy已经知道谁去代理了
        Proxy proxy = new Proxy(girl) ;

        proxy.giveChocolate();
        proxy.giveDolls();
        proxy.giveFlowers();

    }

}
