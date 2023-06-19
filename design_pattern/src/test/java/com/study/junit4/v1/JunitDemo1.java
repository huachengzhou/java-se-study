package com.study.junit4.v1;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/*
 * @Author noatn
 * @Description
 * @Date 2023-06-19
 */
public class JunitDemo1 {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 第一个例子 不提示
     */
    @Test
    public void test1() {
        Assert.assertTrue(1 == 1);
    }

    /**
     * 表达式测试 并提示信息
     */
    @Test
    public void test2() {
        Assert.assertTrue("不大于", RandomUtil.randomLong() > RandomUtil.randomLong());
    }

    /**
     * 数组比较
     */
    @Test
    public void test3() {
        final String[] strings = new String[]{
                RandomUtil.randomString(5),
                RandomUtil.randomString(5),
                RandomUtil.randomString(5)
        };
        logger.info(StrUtil.join("$", strings));
        Assert.assertArrayEquals("不相等", strings, strings);
    }

    /**
     * assertEquals() 如果比较的两个对象是相等的，此方法将正常返回；否则失败显示在JUnit的窗口测试将中止
     */
    @Test
    public void testAssertEquals() {
        Integer a = new Integer(127);
//        Integer b = Integer.valueOf(127);
        Integer b = Integer.parseInt("127");
        logger.info(a.hashCode() + " " + b.hashCode());
        Assert.assertEquals(a, b);
//        Assert.fail("打印错误");
    }


    /**
     * assertSame() 和 assertNotSame() 方法测试两个对象引用指向完全相同的对象
     */
    @Test
    public void testAssertSame() {
        Integer a1 = Integer.valueOf(RandomUtil.randomInt(10, 127));
        Integer a2 = Integer.valueOf(a1.toString());

//        Integer a1 = new Integer(RandomUtil.randomInt(10,127));
//        Integer a2 = new Integer(a1.toString());
        Object[] objects = new Object[]{a1, a2, RandomUtil.randomString(10)};
        System.out.println(Arrays.toString(objects));
        Assert.assertSame("对象引用不同", objects[0], objects[1]);
        Assert.assertSame("对象引用不同", objects[2], objects[1]);
    }

    @Test
    public void testAssertNotSame() {
        Integer a1 = new Integer(RandomUtil.randomInt(128, 1270));
        Integer a2 = new Integer(a1.toString());
        logger.info(String.format("%s-%s",a1.hashCode(),a2.hashCode()));
        Assert.assertNotSame("对象引用相同",a1, a2);
    }

    @Test
    public void testAssertNull(){
//        Double aDouble = RandomUtil.randomDouble();
        Double aDouble = null;
        Assert.assertNull("不等于空",aDouble);
    }

    @Test
    public void testAssertNotNull(){
        Float aFloat = (float) RandomUtil.randomDouble();
//        aFloat = null;
        Assert.assertNotNull("对象为空",aFloat);
    }


}
