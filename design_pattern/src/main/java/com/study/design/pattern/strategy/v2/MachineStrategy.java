package com.study.design.pattern.strategy.v2;

/**
 * @author : chengdu
 * @date :  2023/6/24-06
 **/
public class MachineStrategy extends Strategy {
    private Gun gun;
    @Override
    public String name() {
        return gun.name();
    }

    @Override
    public void assaultWeapon() {
        gun.run();
    }

    public MachineStrategy() {
        this.gun = new MachineGun() ;
    }
}
