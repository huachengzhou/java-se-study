package com.my_reflection.basic_usage;

import java.lang.reflect.Field;

/**
 * @author : chengdu
 * @date :  2023/9/24-09
 **/
public class ReflectionDemo2 {

    interface I1 {
    }

    interface I2 {
    }

    static class Cell {
        public int mCellPublic;
    }

    static class Animal extends Cell {
        private int mAnimalPrivate;
        protected int mAnimalProtected;
        int mAnimalDefault;
        public int mAnimalPublic;
        private static int sAnimalPrivate;
        protected static int sAnimalProtected;
        static int sAnimalDefault;
        public static int sAnimalPublic;
    }

    static class Dog extends Animal implements I1, I2 {
        private int mDogPrivate;
        public int mDogPublic;
        protected int mDogProtected;
        private int mDogDefault;
        private static int sDogPrivate;
        protected static int sDogProtected;
        static int sDogDefault;
        public static int sDogPublic;
    }

    public static void main(String[] args) throws Exception {
        Class<Dog> dog = Dog.class;
        //类名打印
        System.out.println(dog.getName()); //com.my_reflection.basic_usage.ReflectionDemo2$Dog
        System.out.println(dog.getSimpleName()); //Dog
        System.out.println(dog.getCanonicalName());//com.my_reflection.basic_usage.ReflectionDemo2.Dog
        //接口
        System.out.println(dog.isInterface()); //false
        for (Class iI : dog.getInterfaces()) {
            System.out.println(iI);
        }
         /*
          interface com.cry.I1
          interface com.cry.I2
         */

        //父类
        System.out.println(dog.getSuperclass());//class com.my_reflection.basic_usage.ReflectionDemo2$Animal
        //创建对象
        Dog d = dog.newInstance();
        //字段
        for (Field f : dog.getFields()) {
            System.out.println(f.getName());
        }
        /*
            mDogPublic
            sDogPublic
            mAnimalPublic
            sAnimalPublic
            mCellPublic  //父类的父类的公共字段也打印出来了
         */
        System.out.println("---------");
        for (Field f : dog.getDeclaredFields()) {
            System.out.println(f.getName());
        }
        /** 只有自己类声明的字段
         mDogPrivate
         mDogPublic
         mDogProtected
         mDogDefault
         sDogPrivate
         sDogProtected
         sDogDefault
         sDogPublic
         */
    }

}
