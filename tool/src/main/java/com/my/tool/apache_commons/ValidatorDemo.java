package com.my.tool.apache_commons;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import org.apache.commons.validator.routines.DateValidator;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @author noatn
 * @description
 * @date 2023-06-28
 */
public class ValidatorDemo {

    private final Logger logger = LoggerFactory.getLogger(getClass()) ;

    @Test
    public void test1(){

        String fooString = "01/11/2014" ;
        // 获取日期验证
        DateValidator validator = DateValidator.getInstance();

        // 验证/转换日期
        Date fooDate = validator.validate(fooString, "dd/MM/yyyy");
        Assert.assertNotNull("验证/转换日期 失败",fooDate);
        logger.info(DateUtil.format(fooDate, DatePattern.CHINESE_DATE_PATTERN));
        System.out.println(DateUtil.format(fooDate, DatePattern.CHINESE_DATE_PATTERN));
    }

}
