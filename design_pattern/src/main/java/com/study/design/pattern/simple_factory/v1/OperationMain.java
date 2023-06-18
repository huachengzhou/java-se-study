package com.study.design.pattern.simple_factory.v1;

public class OperationMain {

    public double execute(Double a, Double b, String operate) {
        Operation operation = OperationFactory.createOperation(operate);
        return operation.getResult(a, b);
    }
}
