package com.my.annotation.p3;

import org.junit.Test;

/**
 * @author : chengdu
 * @date :  2023/7/8-07
 **/
public class Demo3ExampleTest {

    @Test
    public void test1(){
        Animal animal = new Duck();
        animal.eat();

        //Inherited注解的作用：被它修饰的Annotation将具有继承性。如果某个类使用了被@Inherited修饰的Annotation，则其子类将自动具有该注解AnnotatedElement
        Class<? extends Animal> aClass = animal.getClass();
        Demo3Annoation annotation = aClass.getAnnotation(Demo3Annoation.class);

        System.out.println(annotation.title());
    }

}
