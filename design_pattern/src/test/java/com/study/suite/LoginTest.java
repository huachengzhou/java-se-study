package com.study.suite;

import org.junit.Test;

public class LoginTest extends BaseTest {

    @Test
    public void login() {
        // 模拟用户登录
        dataMap.put("orange", "登录成功");
        logger.info("用户：orange 登录成功");
    }


}
