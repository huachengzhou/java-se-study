package com.study.design.pattern.proxy_pattern;

/**
 * @author : chengdu
 * @date :  2023/6/25-06
 **/
public class Pursuit implements IGiveGift {

    private SchoolGirl mm;

    public Pursuit(SchoolGirl mm) {
        this.mm = mm;
    }

    @Override
    public void giveDolls() {
        System.out.println(this.mm.getName()+", 你好！送你洋娃娃");
    }

    @Override
    public void giveFlowers() {
        System.out.println(this.mm.getName()+", 你好！送你鲜花");
    }

    @Override
    public void giveChocolate() {
        System.out.println(this.mm.getName()+", 你好！送你巧克力");
    }
}
