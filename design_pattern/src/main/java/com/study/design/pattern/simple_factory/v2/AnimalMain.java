package com.study.design.pattern.simple_factory.v2;

/**
 * @author : chengdu
 * @date :  2023/6/24-06
 **/
public class AnimalMain {

    public void execute(String type) {
        Animal animal = AnimalFactory.createAnimal(type);
        if (animal != null) {
            animal.fly();
        } else {
            System.out.println(type + " 未实现飞翔!");
        }
    }

}
