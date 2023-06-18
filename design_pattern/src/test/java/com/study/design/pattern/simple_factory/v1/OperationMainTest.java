package com.study.design.pattern.simple_factory.v1;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author : chengdu
 * @date :  2023/6/18-06
 **/
public class OperationMainTest {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void testOperationMain() {
        double a1 = 2;
        double a2 = 3;
        OperationMain main = new OperationMain();
        double result = main.execute(a1, a2, "+");

        logger.info(String.valueOf(result));
        int i = 5;
//        int i = 4;
        Assert.assertTrue("不相等",result == i);
    }
}
