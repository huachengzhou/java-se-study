package com.study.design.pattern.strategy.v2;

/**
 * @author : chengdu
 * @date :  2023/6/24-06
 **/
public class LGM_30G_MissileStrategy extends Strategy {

    @Override
    public String name() {
        return "民兵3洲际弹道导弹";
    }

    @Override
    public void assaultWeapon() {
        System.out.println(name() + "攻击中 有效攻击距离" + "13000km" + "容量" + "34.5吨");
    }
}
