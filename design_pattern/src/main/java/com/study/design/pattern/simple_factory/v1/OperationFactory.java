package com.study.design.pattern.simple_factory.v1;

/**
 * @author : chengdu
 * @date :  2023/6/18-06
 **/
public class OperationFactory {

    public static Operation createOperation(String operate) {
        Operation instance = null;
        switch (operate) {
            case "+": {
                instance = new Add();
                break;
            }
            case "-": {
                instance = new Sub();
                break;
            }
            case "/": {
                instance = new Div();
                break;
            }
            case "*": {
                instance = new Mul();
                break;
            }
            default: {
                break;
            }
        }
        return instance;
    }
}
