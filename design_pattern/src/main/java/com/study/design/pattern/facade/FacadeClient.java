package com.study.design.pattern.facade;

/**
 * @author noatn
 * @description
 * @date 2023-06-27
 */
public class FacadeClient {

    public void execute(){
        Facade facade = new Facade();
        facade.watchMovie();
    }
}
