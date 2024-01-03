package com.study.design.pattern.decorator_pattern;

/**
 * @author : chengdu
 * @date :  2023/6/24-06
 **/
public class Person implements ICharacter {

    private final String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public void show() {
        System.out.println("装扮的" + this.name);
    }
}
