package com.study.design.pattern.decorator_pattern;

import org.junit.Test;

/**
 * @author : chengdu
 * @date :  2023/6/24-06
 **/
public class DemoRunDecorator {

    @Test
    public void run(){
        Person person = new Person("小明") ;
        System.out.println("第一种装扮");

        TShirts tShirts = new TShirts();
        tShirts.decorate(person);

        BigTrouser bigTrouser = new BigTrouser();
        bigTrouser.decorate(tShirts);

        Strawhat strawhat = new Strawhat();
        strawhat.decorate(bigTrouser);
        strawhat.show();
    }
}
