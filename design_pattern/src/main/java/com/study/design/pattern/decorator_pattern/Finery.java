package com.study.design.pattern.decorator_pattern;

/**
 * 服饰类
 * @author : chengdu
 * @date :  2023/6/24-06
 **/
public abstract class Finery implements ICharacter {

    private ICharacter component;

    public void decorate(ICharacter component){
        this.component = component;
    }


    @Override
    public void show() {
        if (this.component != null){
            this.component.show();
        }
    }
}
