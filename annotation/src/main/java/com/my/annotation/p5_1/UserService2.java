package com.my.annotation.p5_1;

/**
 * @author : chengdu
 * @date :  2023/7/8-07
 **/

public class UserService2 extends UserServiceBase {
    @Override
    public void save(Object obj) {
        System.out.println("UserService2.save");
    }
}
