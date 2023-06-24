package com.study.design.pattern.simple_factory.v3;

import java.math.BigDecimal;

/**
 * @author : chengdu
 * @date :  2023/6/24-06
 **/
public class CashMain {

    public BigDecimal acceptTotal(CashFactory.CashEnum cashEnum,BigDecimal price,int number)throws Exception {
        CashSuper cashSuper = CashFactory.createCashAccept(cashEnum);
        if (cashSuper == null){
            throw new Exception("无此种算法工厂") ;
        }
        return cashSuper.acceptCash(price,number);
    }

}
