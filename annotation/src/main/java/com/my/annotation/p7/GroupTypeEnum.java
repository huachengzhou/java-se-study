package com.my.annotation.p7;

/**
 * @author : chengdu
 * @date :  2023/7/8-07
 **/
public enum GroupTypeEnum {
    GROUP_TYPE_ONE_ENUM("实时新闻组"), GROUP_TYPE_TWO_ENUM("娱乐周刊组");

    GroupTypeEnum(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }
}
