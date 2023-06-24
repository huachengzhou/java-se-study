package com.study.design.pattern.simple_factory.v2;

import org.junit.Test;

/**
 * @author : chengdu
 * @date :  2023/6/24-06
 **/
public class AnimalMainTest {

    @Test
    public void testFly(){
        AnimalMain animalMain = new AnimalMain();
        animalMain.execute("鸟儿");
        animalMain.execute("熊");
    }


}
