package com.study.suite;

import org.junit.Test;

public class BuyTest extends BaseTest {

    @Test
    public void buy()throws Exception {
        //验证用户是否登录 成功
        String orange = "orange";
        if (dataMap.containsKey(orange) && dataMap.get(orange).equals("登录成功")) {
            logger.info("登录成功,可以买~");
        } else {
            logger.error("请登录~");
            throw new Exception("请登录") ;
        }
    }

}
