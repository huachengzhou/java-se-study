package com.my.tool.apache_commons;

import cn.hutool.core.date.*;
import cn.hutool.core.util.RandomUtil;
import org.apache.commons.validator.GenericValidator;
import org.apache.commons.validator.routines.DateValidator;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.TimeZone;

/**
 * @author noatn
 * @description
 * @date 2023-06-28
 */
public class ValidatorDemo {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void test1() {

        String fooString = "01/11/2014";
        // 获取日期验证
        DateValidator validator = DateValidator.getInstance();

        // 验证/转换日期
        Date fooDate = validator.validate(fooString, "dd/MM/yyyy");
        Assert.assertNotNull("验证/转换日期 失败", fooDate);
        logger.info(DateUtil.format(fooDate, DatePattern.CHINESE_DATE_PATTERN));
        System.out.println(DateUtil.format(fooDate, DatePattern.CHINESE_DATE_PATTERN));
    }


    @Test
    public void testDate() {
        /**
         * 是否与datePattern完全匹配
         */
        final boolean strict = false;
        String value = "20200829_";
        String yyyyMMdd = "yyyyMMdd";
        Assert.assertTrue("验证失败",GenericValidator.isDate(value, yyyyMMdd, strict));
    }

    @Test
    public void testInteger(){
        String value = "dssds";
        Assert.assertTrue("验证失败 不是int类型",GenericValidator.isInt(value));
    }

    @Test
    public void testNumberRange(){
        double min = 10D;
        double max = 20D;

        double min1 = 1D;
        double max1 = 20D;
        Assert.assertTrue("验证失败 不在范围内",GenericValidator.isInRange(RandomUtil.randomDouble(min, max), min1, max1));
    }

    @Test
    public void testDateRange(){
        DateValidator validator = DateValidator.getInstance();
        DateTime date = DateUtil.parse("2000年12月11日", DatePattern.CHINESE_DATE_PATTERN);
        DateTime start = DateUtil.parse("2001年12月11日", DatePattern.CHINESE_DATE_PATTERN);
        DateTime end = DateUtil.parse("2003年12月11日", DatePattern.CHINESE_DATE_PATTERN);
        // date 指定日期; start 范围开始时间; end 范围结束时间。
        boolean flag = DateUtil.isIn(date, start, end);
        System.out.println(flag);
    }

}
