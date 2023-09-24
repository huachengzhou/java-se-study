package com.my_genericity;

/**
 * @author : chengdu
 * @date :  2023/9/24-09
 **/
public class GenericsDemo04 {

    public static void main(String[] args) {
        Notepad<String, Integer> notepad = null;        // 定义两个泛型类型的对象
        notepad = new Notepad<String, Integer>();       // 里面的key为String，value为Integer
        notepad.setKey("汤姆");        // 设置第一个内容
        notepad.setValue(20);            // 设置第二个内容
        System.out.print("姓名；" + notepad.getKey());      // 取得信息
        System.out.print("，年龄；" + notepad.getValue());       // 取得信息
    }
}
