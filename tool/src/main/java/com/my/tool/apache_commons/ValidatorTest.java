package com.my.tool.apache_commons;

import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.IdcardUtil;
import org.apache.commons.validator.GenericValidator;
import org.apache.commons.validator.routines.InetAddressValidator;
import org.junit.Assert;
import org.junit.Test;

import java.util.UUID;

/**
 * @author noatn
 * @description 验证框架测试
 * @date 2023-06-28
 */
public class ValidatorTest {

    /**
     * apache commons validator 使用演示
     */
    @Test
    public void commonsValidatorTest() {
        // null 或 空断言
        Assert.assertTrue(GenericValidator.isBlankOrNull(""));
        Assert.assertTrue(GenericValidator.isBlankOrNull(null));
        // int，其他类型一样：byte,short，float，double，long
        Assert.assertTrue(GenericValidator.isInt("1"));
        // 日期
        Assert.assertTrue(GenericValidator.isDate("20200829", "yyyyMMdd",true));
        // int 在指定范围内，其他类型一样：byte,short，float，double，long
        Assert.assertTrue(GenericValidator.isInRange(1, 0,2));
        // int 最大最小，其他类型一样：float，double，long
        Assert.assertTrue(GenericValidator.minValue(1, 1));
        Assert.assertTrue(GenericValidator.maxValue(1, 1));
        // 字符串 最大最小长度
        Assert.assertTrue(GenericValidator.maxLength("daodaotest", 10));
        Assert.assertTrue(GenericValidator.minLength("daodaotest", 10));
        // 正则表达式
        Assert.assertTrue(GenericValidator.matchRegexp("daodaotest", "^d.*t$"));
        // 信用卡验证
        Assert.assertTrue(GenericValidator.isCreditCard("6227612145830440"));
        // url
        Assert.assertTrue(GenericValidator.isUrl("http://www.baidu.com"));
        // email
        Assert.assertTrue(GenericValidator.isEmail("dao@test.com"));
        // ip
        Assert.assertTrue(InetAddressValidator.getInstance().isValid("192.168.1.1"));
        Assert.assertTrue(InetAddressValidator.getInstance().isValid("CDCD:910A:2222:5498:8475:1111:3900:2020"));
    }

    /**
     * hutools validator 使用演示
     */
    @Test
    public void huTollsValidatorTest() {
        // null 空 布尔
        Assert.assertTrue(Validator.isNull(null));
        Assert.assertTrue(Validator.isNotNull("daodaotest"));
        Assert.assertTrue(Validator.isEmpty(""));
        Assert.assertTrue(Validator.isNotEmpty("daodaotest"));
        Assert.assertTrue(Validator.isTrue(true));
        Assert.assertTrue(Validator.isFalse(false));
        // 相等
        Assert.assertTrue(Validator.equal("daodaotest","daodaotest"));
        // 是否汉字，包含汉字
        Assert.assertTrue(Validator.hasChinese("daodaotest叨叨软件测试"));
        Assert.assertTrue(Validator.isChinese("叨叨软件测试"));
        // 是否为数字
        Assert.assertTrue(Validator.isNumber("1.1"));
        // 是否字母，包括大写和小写字母
        Assert.assertTrue(Validator.isWord("daodaotest"));
        // 是否为英文字母 、数字和下划线， 还支持：大写和小写字母和汉字（isLetter）
        Assert.assertTrue(Validator.isGeneral("dao_1"));
        // 是否全为大写或小写字母
        Assert.assertTrue(Validator.isLowerCase("daodaotest"));
        Assert.assertTrue(Validator.isUpperCase("DAODAOTEST"));
        // 检查给定的数字是否在指定范围内
        Assert.assertTrue(Validator.isBetween(1,1,1));
        // 生日
        Assert.assertTrue(Validator.isBirthday("20200830"));
        // 18位 身份证号格式校验，已经提 PR，改为调用 IdcardUtil 的方法，估计5.4.1 版本更新
        Assert.assertTrue(Validator.isCitizenId("11010119900307299X"));
        // 身份证校验，支持18位、15位和港澳台的10位
        // 支持：10位（isValidCard10），15位（isValidCard15），18位（isValidCard18），香港（isValidHKCard），台湾（isValidTWCard）
        Assert.assertTrue(IdcardUtil.isValidCard("11010119900307299X"));
        Assert.assertTrue(IdcardUtil.isValidCard18("11010119900307299X"));
        // 统一社会信用代码（营业执照注册号）
        Assert.assertTrue(Validator.isCreditCode("91350500676532779B"));
        // 中国车牌号
        Assert.assertTrue(Validator.isPlateNumber("京A88888"));
        // 邮编
        Assert.assertTrue(Validator.isZipCode("100000"));
        // uuid
        Assert.assertTrue(Validator.isUUID(UUID.randomUUID().toString()));
        // 正则表达式
        Assert.assertTrue(Validator.isMatchRegex("^d.*t$","daodaotest"));
        // 手机号
        Assert.assertTrue(Validator.isMobile("13888888888"));
        // url
        Assert.assertTrue(Validator.isUrl("http://www.baidu.com"));
        // email
        Assert.assertTrue(Validator.isEmail("dao@test.com"));
        // ip
        Assert.assertTrue(Validator.isIpv4("192.168.1.1"));
        Assert.assertTrue(Validator.isIpv6("CDCD:910A:2222:5498:8475:1111:3900:2020"));
    }

}

