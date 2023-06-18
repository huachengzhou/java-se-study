package com.study.design.pattern.t1;

public class Demo1 {

    public int checkA(int x, int y) {
        return getA1(x, y);
    }

    public int checkB(int x, int y) {
        int a1 = getA1(x, y);
        return a1 + (int)(Math.random()*100);
    }

    private int getA1(int x, int y) {
        return x * y + (x - y);
    }

}
