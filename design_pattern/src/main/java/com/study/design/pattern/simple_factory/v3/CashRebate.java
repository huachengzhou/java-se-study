package com.study.design.pattern.simple_factory.v3;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * @author : chengdu
 * @date :  2023/6/24-06
 **/
public class CashRebate extends CashSuper {

    /**
     * 折扣率
     */
    private BigDecimal moneyRebate;

    public CashRebate(BigDecimal moneyRebate) {
        this.moneyRebate = moneyRebate;
    }

    /**
     * 计算收费时候 要在原价上面乘以折扣
     * @param price 单价
     * @param type 数量
     * @return
     */
    @Override
    public BigDecimal acceptCash(BigDecimal price, int type) {
        BigDecimal result = price.multiply(new BigDecimal(type));
        if (moneyRebate != null){
            result = result.multiply(moneyRebate, MathContext.DECIMAL64);
        }
//        result.setScale(2, RoundingMode.DOWN) ;
        return result;
    }

    public BigDecimal getMoneyRebate() {
        return moneyRebate;
    }
}
