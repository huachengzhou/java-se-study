package com.study.design.pattern.simple_factory.v1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author : chengdu
 * @date :  2023/6/18-06
 **/
public class Div extends Operation {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public double getResult(double numberA, double numberB) {
        if (numberB == 0) {
            logger.info("除数不能为0");
            throw new ArithmeticException("除数为0");
        }
        return numberA / numberB;
    }
}
