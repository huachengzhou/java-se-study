package com.study.design.pattern.strategy.v2;

import java.math.BigDecimal;

/**
 * @author : chengdu
 * @date :  2023/6/24-06
 **/
public class M16A4Gun implements Gun {
    public M16A4Gun() {
        super();
    }

    @Override
    public String name() {
        return "M16A4突击步枪";
    }

    @Override
    public BigDecimal distance() {
        return new BigDecimal(600);
    }

    @Override
    public void run() {
        System.out.println(name() + "攻击中 有效攻击距离" + distance().toString() + "容量" + capacity());
    }

    @Override
    public String capacity() {
        return "40发";
    }
}
