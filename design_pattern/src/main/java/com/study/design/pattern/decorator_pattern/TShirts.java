package com.study.design.pattern.decorator_pattern;

/**
 * @author : chengdu
 * @date :  2023/6/24-06
 **/
public class TShirts extends Finery {
    @Override
    public void show() {
        System.out.println("大T恤");
        super.show();
    }
}
