package com.study.design.pattern.facade;

/**
 * @author noatn
 * @description 观看电影需要操作很多电器，使用外观模式实现一键看电影功能
 * @date 2023-06-27
 */
public class SubSystem {

    public void turnOnTV() {
        System.out.println("turnOnTV()");
    }

    public void setCD(String cd) {
        System.out.println("setCD( " + cd + " )");
    }

    public void starWatching(){
        System.out.println("starWatching()");
    }

}
