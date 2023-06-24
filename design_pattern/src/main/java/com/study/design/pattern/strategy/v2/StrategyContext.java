package com.study.design.pattern.strategy.v2;

/**
 * @author : chengdu
 * @date :  2023/6/24-06
 **/
public class StrategyContext {
    private Strategy strategy;

    public StrategyContext(Strategy strategy) {
        this.strategy = strategy;
    }

    public void run() {
        this.strategy.assaultWeapon();
    }

    public static Strategy getType(int type) {
        Strategy strategy = null;
        switch (type) {
            case 0: {
                strategy = new MachineStrategy();
                break;
            }
            case 1: {
                strategy = new GunM16A4Strategy();
                break;
            }
            case 2: {
                strategy = new LGM_30G_MissileStrategy();
                break;
            }
            default:
                break;
        }
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
