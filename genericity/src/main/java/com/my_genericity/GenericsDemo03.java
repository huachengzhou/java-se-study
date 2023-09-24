package com.my_genericity;

/**
 * @author : chengdu
 * @date :  2023/9/24-09
 **/
public class GenericsDemo03 {

    public static void main(String[] args) {
        Point<String> p = new Point<String>() ;     // 里面的var类型为String类型
        p.setVar("it") ;                            // 设置字符串
        System.out.println(p.getVar().length()) ;   // 取得字符串的长度
    }
}
