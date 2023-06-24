package com.study.design.pattern.simple_factory.v3;

import java.math.BigDecimal;

/**
 *  收费抽象类
 * @author : chengdu
 * @date :  2023/6/24-06
 **/
public abstract class CashSuper {

    /**
     * 收取费用的方法
     * @param price 单价
     * @param type 数量
     * @return
     */
    public abstract BigDecimal acceptCash(BigDecimal price,int type);

}
