package array;

import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class ArrayUse {

    /**
     * 数组初始化
     */
    @Test
    public void test_init() {
        int[] arr = new int[10];
        int[] nums = {1, 2, 5, 6};

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(nums));
    }


    /**
     * 随机返回一个数组元素
     */
    @Test()
    public void test_randomAccess() {
        int[] nums = {0, 5, 2, 6, 7, 9};
        int num = randomAccess(nums);
        System.out.println("num:" + num);
    }

    /**
     * 扩展数组长度
     */
    @Test()
    public void test_extend() {
        int[] nums = {0, 5, 2, 6, 7, 9};
        int[] extend = extend(nums, 2);
        System.out.println(Arrays.toString(extend));
    }

    /**
     * 在数组的索引 index 处插入元素 num
     */
    @Test
    public void test_insert() {
        //实际容量 {0, 5, 2, 6, 6, 7, 9} 扩大一个容量
        //可以参考 test_extend 扩大
        int[] nums = {0, 5, 2, 6, 6, 7, 9, 0};
        int index = 4;
        int num = 33;
        insert(nums, num, index);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test_remove() {
        int[] nums = {8, 5, 2, 6, 10, 7, 9, 4};
        int index = 2;
        remove(nums, index);
        System.out.println(Arrays.toString(nums));
    }


    /* 删除索引 index 处元素 */
    void remove(int[] nums, int index) {
        //index之前的数据向前移动并覆盖index位置  这样第一个元素是一个重复元素
//        for (int i = index; i > 0; i--) {
//            nums[i ] = nums[i-1];
//        }
        // 把索引 index 之后的所有元素向前移动一位
        System.out.println(nums.length - 1);
//        for (int i = index; i < nums.length - 1; i++) {
//            System.out.println(i);
//            nums[i] = nums[i + 1];
//        }

        for (int i = index; i < nums.length -1; i++) {
            System.out.println(i);
            nums[i] = nums[i+1 ];
        }
        nums[nums.length -1] = 0;
        //假如 数组下标有index+1 那么 循环判断体 一定要是len-1
    }

    /* 在数组的索引 index 处插入元素 num */
    void insert(int[] nums, int num, int index) {
        for (int i = nums.length - 1; i > index; i--) {
            nums[i] = nums[i - 1];
        }
        nums[index] = num;
    }

    /* 扩展数组长度 */
    int[] extend(int[] nums, int enlarge) {
        // 初始化一个扩展长度后的数组
        int[] arr = new int[nums.length + enlarge];
        // 将原数组中的所有元素复制到新数组
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }
        // 返回扩展后的新数组
        return arr;
    }

    /**
     * 随机返回一个数组元素
     *
     * @param nums
     * @return
     */
    private int randomAccess(int[] nums) {
        int index = ThreadLocalRandom.current().nextInt(0, nums.length);
        return nums[index];
    }

}
