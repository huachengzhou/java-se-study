package com.my_genericity;

/**
 * @author : chengdu
 * @date :  2023/9/24-09
 **/
public class Notepad<K,V> {// 此处指定了两个泛型类型
    private K key;// 此变量的类型由外部决定
    private V value;// 此变量的类型由外部决定

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
