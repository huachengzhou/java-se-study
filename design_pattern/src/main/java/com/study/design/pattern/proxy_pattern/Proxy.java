package com.study.design.pattern.proxy_pattern;

/**
 * @author : chengdu
 * @date :  2023/6/25-06
 **/
public class Proxy implements IGiveGift {

    /**
     * 认识追求者
     */
    private Pursuit gg;

    //也认识被追求者
    public Proxy(SchoolGirl mm) {
        //初始化代理追求者  代理过程初始化
        this.gg = new Pursuit(mm);
    }

    @Override
    public void giveDolls() {
        this.gg.giveDolls();
    }

    @Override
    public void giveFlowers() {
        this.gg.giveFlowers();
    }

    @Override
    public void giveChocolate() {
        this.gg.giveChocolate();
    }
}
