package com.study.design.pattern.strategy.v2;

/**
 * @author : chengdu
 * @date :  2023/6/24-06
 **/
public class GunM16A4Strategy extends Strategy {

    private Gun gun;
    @Override
    public String name() {
        return gun.name();
    }

    @Override
    public void assaultWeapon() {
        gun.run();
    }

    public GunM16A4Strategy() {
        this.gun = new M16A4Gun() ;
    }


}
