package com.study.design.pattern.simple_factory.v3;

import cn.hutool.core.util.RandomUtil;
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
public class CashMainTest {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void testAcceptTotal() {
        CashMain cashMain = new CashMain();
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
                BigDecimal decimal = cashMain.acceptTotal(CashFactory.CashEnum.FOUR, integerEntry.getKey(), integerEntry.getValue());
                System.out.println("price:" + integerEntry.getKey() + " number:" + integerEntry.getValue() + " value:" + decimal.toString());
                total = total.add(decimal);
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }
        logger.info(total.toPlainString());
    }


}
