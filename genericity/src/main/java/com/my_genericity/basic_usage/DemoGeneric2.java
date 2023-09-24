package com.my_genericity.basic_usage;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author : chengdu
 * @date :  2023/9/24-09
 **/
public class DemoGeneric2 {

    @Test
    public void test1(){
        Map map = new HashMap();
        map.put(UUID.randomUUID().toString(),UUID.randomUUID().toString()) ;
        printMap(map) ;
    }

    public void printMap(Map<String,Number> numberMap){
        numberMap.entrySet().forEach(stringNumberEntry -> {
            System.out.println(stringNumberEntry.getValue().doubleValue());
        });
    }

}
