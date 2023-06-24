package com.study.design.pattern.strategy;

import cn.hutool.core.util.RandomUtil;
import com.study.design.pattern.strategy.v1.CashContext;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author : chengdu
 * @date :  2023/6/24-06
 **/
public class CashContextDemo1 {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void test1() {
        CashContext context = new CashContext(CashContext.CashEnum.TWO);
        Map<BigDecimal, Integer> priceMap = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            priceMap.put(
                    RandomUtil.randomBigDecimal(new BigDecimal(10), new BigDecimal(100)),
                    RandomUtil.randomInt(2, 6)
            );
        }
        BigDecimal total = BigDecimal.ZERO;
        Iterator<Map.Entry<BigDecimal, Integer>> iterator = priceMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<BigDecimal, Integer> integerEntry = iterator.next();
            try {
                BigDecimal decimal = context.getResult(integerEntry.getKey(), integerEntry.getValue());
                System.out.println("price:" + integerEntry.getKey() + " number:" + integerEntry.getValue() + " value:" + decimal.toString());
                total = total.add(decimal);
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }
        logger.info(total.toPlainString());
    }

}
