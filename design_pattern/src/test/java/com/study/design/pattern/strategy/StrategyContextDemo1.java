package com.study.design.pattern.strategy;

import com.study.design.pattern.strategy.v2.StrategyContext;
import org.junit.Test;

/**
 * @author : chengdu
 * @date :  2023/6/24-06
 **/
public class StrategyContextDemo1 {

    @Test
    public void test1() {
        StrategyContext context = new StrategyContext(StrategyContext.getType(2));

        //在运行过程中  我们改变了它的算法
        context.setStrategy(StrategyContext.getType(0));
        context.run();

    }


}
