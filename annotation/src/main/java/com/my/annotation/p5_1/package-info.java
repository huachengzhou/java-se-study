/**
 * @author : chengdu
 * @date :  2023/7/8-07
 **/

@Demo5_1Annoation(desc = "用户包类",useUserClass = UserService2.class,dangleUseClass = UserService1.class)
package com.my.annotation.p5_1;

final  class Constant {
    static final String PACKAGE_NAME = "Test";

    static final String USER_NAME = "admin" ;

    static final String PASS_WORD = "123456" ;

}
