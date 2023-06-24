package com.study.design.pattern.simple_factory.v3;

import java.math.BigDecimal;

/**
 * 消费工厂
 * @author : chengdu
 * @date :  2023/6/24-06
 **/
public class CashFactory {

    /**
     * @author noatn
     */
    public static enum CashEnum {
        ONE("正常收费"),
        TWO("打8折"),
        THREE("打7折"),
        FOUR("满300返还100"),
        ;

        private String name;

        CashEnum(String name) {
            this.name = name;
        }
    }

    public static CashSuper createCashAccept(CashEnum cashEnum) {
        CashSuper cashSuper = null;
        switch (cashEnum) {
            case ONE: {
                cashSuper = new CashNormal();
                break;
            }
            case TWO: {
                cashSuper = new CashRebate(new BigDecimal(0.8));
                break;
            }
            case THREE: {
                cashSuper = new CashRebate(new BigDecimal(0.7));
                break;
            }
            case FOUR: {
                cashSuper = new CashReturn(new BigDecimal(300), new BigDecimal(100));
                break;
            }
            default: {
                break;
            }
        }
        return cashSuper;
    }
}
