package com.study.design.pattern.facade;

/**
 * @author noatn
 * @description
 * @date 2023-06-27
 */
public class Facade {

    private SubSystem subSystem = new SubSystem();

    public void watchMovie() {
        subSystem.turnOnTV();
        subSystem.setCD("a movie");
        subSystem.starWatching();
    }
}
