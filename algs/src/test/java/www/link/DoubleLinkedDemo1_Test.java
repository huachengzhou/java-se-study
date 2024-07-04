package www.link;

import org.junit.Test;
import org.link.DoubleLinkedDemo1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

/**
 * @author : chengdu
 * @date :  2024/6/22-06
 **/
public class DoubleLinkedDemo1_Test {

    @Test
    public void test_addFirst() {
        DoubleLinkedDemo1 linkedList = new DoubleLinkedDemo1();
        linkedList.addFirst(62);
        linkedList.addFirst(49);
        linkedList.addFirst(89);
        linkedList.addFirst(25);
        linkedList.addFirst(92);
        linkedList.addFirst(100);
        linkedList.forEach(integer -> System.out.println(integer));
    }

    @Test
    public void test_addLast() {
        DoubleLinkedDemo1 linkedList = new DoubleLinkedDemo1();
        linkedList.addLast(64);
        linkedList.addLast(98);
        linkedList.addLast(38);
        linkedList.addLast(58);
        linkedList.forEach(integer -> System.out.println(integer));
    }

    @Test
    public void test_removeFirst() {
        DoubleLinkedDemo1 linkedList = new DoubleLinkedDemo1();
        linkedList.addLast(64);
        linkedList.addLast(89);
        linkedList.removeFirst();
        linkedList.forEach(integer -> System.out.println(integer));
    }

    @Test
    public void test_remove() {
        DoubleLinkedDemo1 linkedList = new DoubleLinkedDemo1();
        linkedList.addLast(41);
        linkedList.addLast(84);
        linkedList.addLast(46);
        linkedList.addLast(59);

        linkedList.remove(3);
        linkedList.forEach(integer -> System.out.println(integer));
    }


    @Test
    public void test_insert() {
        DoubleLinkedDemo1 linkedList = new DoubleLinkedDemo1();
        linkedList.insert(92, 0);
        linkedList.insert(88, 1);
        linkedList.insert(100, 2);
        linkedList.insert(29, 3);
//        linkedList.forEach(integer -> System.out.println(integer));

        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(3));
    }

    @Test
    public void test_Math() {
        System.out.println(Math.log(100));
    }

    @Test
    public void test_MathPI() {
        System.out.println(Math.PI);

        // 计算圆周率π
        double pi = 0;
        int flag = -1;
        for (int i = 1; i <= 100000000; i += 2) { //为了方便计算，循环10亿次
            flag *= -1;
            pi += flag * 1.0 / i;
        }
        System.out.println("pi=4*(1-1/3+1/5-1/7+...)=" + 4 * pi);
    }

    @Test
    public void test_MathPI2() {
        System.out.println(Math.PI);

        //马青公式：π = 16 (arctan1 / 5−4 arctan1 / 239 )
        //初始公式变量相关
        BigDecimal fz = BigDecimal.ONE;
        BigDecimal fz1 = new BigDecimal("5");
        BigDecimal fz2 = new BigDecimal("239");

        BigDecimal fm1 = new BigDecimal("25");
        BigDecimal fm2 = new BigDecimal("57121");
        BigDecimal a = new BigDecimal("4");
        BigDecimal b = new BigDecimal("1");
        BigDecimal c = new BigDecimal("2");
        //公式符号改变标志
        int flag = 1;
        //结果存储
        //分结果
        BigDecimal result1;
        BigDecimal r1;
        BigDecimal r2;
        //总结果
        BigDecimal result = new BigDecimal("0");
        //精确迭代次数10000次
//        int n = 10000;
        int n = 10000000;
        //start
        int i = 1;
        long time1 = new Date().getTime();
        while (i < n) {
            i++;
            //分式子结果，计算1
            r1 = fz.divide(fz1.multiply(b), n, BigDecimal.ROUND_DOWN);
            r2 = fz.divide(fz2.multiply(b), n, BigDecimal.ROUND_DOWN);
            //分式子结果，计算1
            if (flag == 1) {
                result1 = a.multiply(r1).subtract(r2);
                //标志改变
                flag = -1;
            } else {
                result1 = r2.subtract(a.multiply(r1));
                flag = 1;
            }
            //总计算
            result = result.add(result1);
            //变量迭达变换
            b = b.add(c);
            fz1 = fz1.multiply(fm1);
            fz2 = fz2.multiply(fm2);

        }
        //end
        long time2 = new Date().getTime();
        //输出pi1000与计算时间
        System.out.println("pi计算的结果：\n" + result.multiply(a).toString().substring(0, 1000));
        System.out.println("pi计算的时间：\n" + (time2 - time1) + "毫秒");
    }

}
