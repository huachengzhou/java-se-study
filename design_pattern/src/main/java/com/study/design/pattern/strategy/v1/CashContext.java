package com.study.design.pattern.strategy.v1;

import com.study.design.pattern.simple_factory.v3.*;

import java.math.BigDecimal;

/**
 * @author : chengdu
 * @date :  2023/6/24-06
 **/
public class CashContext {
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

    private CashSuper cs;

    public CashContext(CashContext.CashEnum cashEnum) {
        switch (cashEnum) {
            case ONE: {
                this.cs = new CashNormal();
                break;
            }
            case TWO: {
                this.cs = new CashRebate(new BigDecimal(0.8));
                break;
            }
            case THREE: {
                this.cs = new CashRebate(new BigDecimal(0.7));
                break;
            }
            case FOUR: {
                this.cs = new CashReturn(new BigDecimal(300), new BigDecimal(100));
                break;
            }
            default: {
                break;
            }
        }
    }


    public BigDecimal getResult(BigDecimal price, int type){
        return this.cs.acceptCash(price, type) ;
    }
}
