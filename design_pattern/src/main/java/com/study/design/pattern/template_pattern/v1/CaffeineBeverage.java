package com.study.design.pattern.template_pattern.v1;

/**
 * @author noatn
 * @Description
 * @Date 2023-06-26
 */
public abstract class CaffeineBeverage {

    /**
     * 准备食谱
     */
    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    /**
     * 酿造
     */
    abstract void brew();

    /**
     * 添加调味品
     */
    abstract void addCondiments();

    /**
     * 烧水
     */
    void boilWater() {
        System.out.println("boilWater(烧水)");
    }

    /**
     * 倒入
     */
    void pourInCup() {
        System.out.println("pourInCup(倒入)");
    }
}
