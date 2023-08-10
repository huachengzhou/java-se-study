package www.lintcode.com;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.RandomUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * https://visualgo.net/zh/sorting
 */
public class SortDemoTest1 {


    public int[] arrBase = new int[20];
    public long startTime = 0;

    @Before
    public void before() {
        for (int i = 0; i < arrBase.length; i++) {
            arrBase[i] = RandomUtil.randomInt(1, 300);
        }
        System.out.println("原始数据:");
        System.out.println(Arrays.toString(arrBase));
        startTime = System.currentTimeMillis();
    }

    /**
     * 选择排序
     */
    @Test
    public void selTest() {
        int[] arr = ArrayUtil.clone(arrBase);
        int length = arr.length;
        int min = 0;
        int minIndex = 0;
        for (int i = 0; i < length; i++) {
            min = arr[i];
            minIndex = i;
            //使用arrBase[i]  与 i-length 之间做比较  找出那一趟结束完毕的最小值
            for (int j = i; j < length; j++) {
                //如果元素 < 现在的最小值   将此元素设置成为新的最小值
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            //将最小值和第一个没有排序过的位置交换
            int temp = arr[i];
            arr[i] = min;
            arr[minIndex] = temp;
        }
        System.out.println("选择排序结果:");
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 冒泡排序
     */
    @Test
    public void bubTest() {
        int[] arr = ArrayUtil.clone(arrBase);
        int length = arr.length;
        //外循环：未排序区间为 [0, i]
        for (int i = length - 1; i > 0; i--) {
            //内循环：将未排序区间 [0, i] 中的最大元素交换至该区间的最右端
            for (int j = 0; j < i; j++) {
                //如果 左边元素 > 右边元素
                if (arr[j] > arr[j + 1]) {
                    //交换（左边元素，右边元素）
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("冒泡排序结果:");
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 插入排序
     */
    @Test
    public void insertSort() {
        int[] arr = ArrayUtil.clone(arrBase);
        int length = arr.length;
        //最外层循环
        // 从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        for (int i = 1; i < length; i++) {
            //“提取” 元素 X  记录要插入的数据
            int x = arr[i];
            int j = 0;
            for (j = i - 1; j >= 0; j--) {
                //如果比x大把值往后移动一位
                if (arr[j] > x) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = x;
        }

        System.out.println("插入排序结果:");
        System.out.println(Arrays.toString(arr));
    }



    /**
     * 数组移动位数
     */
    @Test
    public void moveTest() {
        //向右移动
        int[] arr = ArrayUtil.clone(arrBase);
        for (int i = 3; i < arr.length; i++) {
            int temp = arr[i];
            arr[i] = arr[i - 1];
            arr[i - 1] = temp;
        }

        System.out.println("数组移动位数结果:");
        System.out.println(ArrayUtil.equals(arr, arrBase));
        System.out.println(Arrays.toString(arr));
    }


    @After
    public void after() {
        int[] arr = ArrayUtil.clone(arrBase);
        Arrays.sort(arr);
        System.out.println("标准排序结果:");
        System.out.println(Arrays.toString(arr));
        long time = System.currentTimeMillis() - startTime;
        System.out.println("time:" + time);
    }


}
