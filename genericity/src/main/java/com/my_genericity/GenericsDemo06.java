package com.my_genericity;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author : chengdu
 * @date :  2023/9/24-09
 **/
public class GenericsDemo06 {


    static class DateValue<T extends Object> {
        T t;

        public DateValue(T t) {
            this.t = t;
        }

        public T getT() {
            return t;
        }

        public void setT(T t) {
            this.t = t;
        }
    }

    public static void main(String[] args) {
        GenericsDemo06.fun(new DateValue(6));
        GenericsDemo06.fun(new DateValue(5L));
        GenericsDemo06.fun(new DateValue(3d));
        GenericsDemo06.fun(new DateValue(5.66f));
    }

    public static void fun(DateValue<? super Number> value) {
        System.out.println("value:" + value.getT());
    }

}
