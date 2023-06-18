package com.study.design.pattern.simple_factory.v1;

/**
 * @author : chengdu
 * @date :  2023/6/18-06
 **/
public class Sub extends Operation {

    @Override
    public double getResult(double numberA, double numberB) {
        return numberA - numberB;
    }
}
