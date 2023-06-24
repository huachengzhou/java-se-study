package com.study.design.pattern.simple_factory.v2;

/**
 * @author : chengdu
 * @date :  2023/6/24-06
 **/
public class AnimalFactory {

    public static Animal createAnimal(String type){
        Animal animal =null;
        switch (type){
            case "鸭子":{
                animal = new Duck();
                break;
            }
            case "鸟儿":{
                animal = new Bird();
                break;
            }
            default:{
                break;
            }
        }

        return animal;
    }

}
