package com.study.design.pattern.simple_factory.v3;

import java.math.BigDecimal;

/**
 * @author : chengdu
 * @date :  2023/6/24-06
 **/
public class CashReturn extends CashSuper {

    /**
     * 返利条件
     */
    private BigDecimal moneyCondition;

    /**
     * 返利值
     */
    private BigDecimal moneyReturn;

    /**
     * 计算收费的时候 ,当达到返利条件,就原价减去返利值
     *
     * @param price 单价
     * @param type  数量
     * @return
     */
    @Override
    public BigDecimal acceptCash(BigDecimal price, int type) {
        BigDecimal result = price.multiply(new BigDecimal(type));
        if (moneyCondition != null && result.compareTo(moneyCondition) > 0) {
            BigDecimal multiply = result.divide(moneyCondition, 2, BigDecimal.ROUND_FLOOR).multiply(moneyReturn);
            result = result.subtract(multiply);
        }
        return result;
    }

    public CashReturn(BigDecimal moneyCondition, BigDecimal moneyReturn) {
        this.moneyCondition = moneyCondition;
        this.moneyReturn = moneyReturn;
    }

    public BigDecimal getMoneyCondition() {
        return moneyCondition;
    }

    public BigDecimal getMoneyReturn() {
        return moneyReturn;
    }
}
