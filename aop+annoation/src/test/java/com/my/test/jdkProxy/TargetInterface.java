package com.my.test.jdkProxy;

import java.util.Map;

/**
 * 目标类接口
 * @author : chengdu
 * @date :  2023/7/9-07
 **/
public interface TargetInterface {


    /**
     * 保存实体
     */
    public void save(Map<String,Object> map);


}
