package com.study.design.pattern.strategy.v2;

import java.math.BigDecimal;

/**
 * @author : chengdu
 * @date :  2023/6/24-06
 **/
public interface Gun {

    /**
     * 名称
     * @return
     */
    String name();

    /**
     * 距离
     * @return
     */
    BigDecimal distance() ;

    /**
     * 攻击
     */
    void run();

    /**
     * 容量
     * @return
     */
    String capacity();
}
