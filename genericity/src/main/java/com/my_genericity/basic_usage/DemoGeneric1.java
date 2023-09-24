package com.my_genericity.basic_usage;

/**
 * @author : chengdu
 * @date :  2023/9/24-09
 **/
public class DemoGeneric1 {

    private static int add(int a, int b) {
        System.out.println(a + "+" + b + "=" + (a + b));
        return a + b;
    }

    private static float add(float a, float b) {
        System.out.println(a + "+" + b + "=" + (a + b));
        return a + b;
    }

    private static double add(double a, double b) {
        System.out.println(a + "+" + b + "=" + (a + b));
        return a + b;
    }

    public static <T extends Number> double addTwo(T a, T b) {
        System.out.println(a + "+" + b + "=" + (a.doubleValue() + b.doubleValue()));
        return a.doubleValue() + b.doubleValue();
    }

    public static void main(String[] args) {
        double v = DemoGeneric1.addTwo(2L, 5L);
        System.out.println(v);
    }


}
