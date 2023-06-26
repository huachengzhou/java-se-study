package com.study.design.pattern.template_pattern.v1;

/**
 * @author noatn
 * @description
 * @date 2023-06-26
 */
public class Coffee extends CaffeineBeverage {

    @Override
    void brew() {
        System.out.println("咖啡 开始 酿造");
    }

    @Override
    void addCondiments() {
        System.out.println("添加调味品");
    }
}
