package com.study.design.pattern.strategy.v2;

import java.math.BigDecimal;

/**
 * @author : chengdu
 * @date :  2023/6/24-06
 **/
public class MachineGun implements Gun {
    @Override
    public String name() {
        return "M2重机枪";
    }

    @Override
    public String capacity() {
        return "N/A";
    }

    @Override
    public BigDecimal distance() {
        return new BigDecimal(1500);
    }

    @Override
    public void run() {
        System.out.println(name() + "攻击中 有效攻击距离" + distance().toString() + "容量" + capacity());
    }
}
