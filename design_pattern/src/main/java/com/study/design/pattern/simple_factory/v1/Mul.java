package com.study.design.pattern.simple_factory.v1;

public class Mul extends Operation {
    @Override
    public double getResult(double numberA, double numberB) {
        return numberA * numberB;
    }
}
