package com.study.design.pattern.simple_factory.v3;

import java.math.BigDecimal;

/**
 * @author : chengdu
 * @date :  2023/6/24-06
 **/
public class CashNormal extends  CashSuper {

    /**
     * 正常收费
     * @param price 单价
     * @param type 数量
     * @return
     */
    @Override
    public BigDecimal acceptCash(BigDecimal price, int type) {
        return price.multiply(new BigDecimal(type));
    }

}
