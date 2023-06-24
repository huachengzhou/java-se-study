package com.study.design.pattern.strategy.v2;

/**
 * @author : chengdu
 * @date :  2023/6/24-06
 **/
public abstract class Strategy {

    /**
     * 武器名称
     * @return
     */
    public abstract String name();

    /**
     * 攻击方式
     */
    public abstract void assaultWeapon();

}
