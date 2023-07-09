package com.my.test.jdkProxy;

import cn.hutool.json.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @author : chengdu
 * @date :  2023/7/9-07
 **/
public class TargetExample  implements TargetInterface {

    private final Logger logger = LoggerFactory.getLogger(getClass()) ;
    /**
     * 保存实体
     *
     * @param map
     */
    @Override
    public void save(Map<String, Object> map) {
        logger.info("before save");
        logger.info(JSONUtil.toJsonStr(map));
        logger.info("save sucess");
        System.out.println("sucess");
    }
}
