package com.my_genericity;

/**
 * @author : chengdu
 * @date :  2023/9/24-09
 **/
public class GenericsDemo05 {

    interface Info<T> {// 在接口上定义泛型

        /**
         * 定义抽象方法，抽象方法的返回值就是泛型类型
         *
         * @return
         */
        public T getVar();
    }

    static class InfoImpl<T> implements Info<T> {// 定义泛型接口的子类
        private T var; // 定义属性

        /**
         * 定义抽象方法，抽象方法的返回值就是泛型类型
         *
         * @return
         */
        @Override
        public T getVar() {
            return var;
        }

        public InfoImpl(T var) {// 通过构造方法设置属性内容
            this.var = var;
        }
    }

    public static void main(String[] args) {
        Info<String> info = null;        // 声明接口对象
        info = new InfoImpl<String>("汤姆");  // 通过子类实例化对象
        System.out.println("内容：" + info.getVar());
    }

}
