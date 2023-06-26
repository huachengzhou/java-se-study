package com.study.design.pattern.template_pattern.v1;

/**
 * @author noatn
 * @description
 * @date 2023-06-26
 */
public class Tea  extends CaffeineBeverage{
    /**
     * 酿造
     */
    @Override
    void brew() {
        System.out.println("茶 开始制作");
    }

    /**
     * 添加调味品
     */
    @Override
    void addCondiments() {
        System.out.println("添加茶叶");
    }
}
