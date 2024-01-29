package org.find;

public class DemoBinarySearch {


    /**
     * 二分查找 初次学习
     *
     * @param arr 升序数组
     * @param target 目标值
     * @return
     */
    public static int binarySearch1(int[] arr, int target) {
        int i = 0;
        int j = arr.length - 1;
        //i-j 范围内元素
        while (i <= j) {
            //中间索引 取左边边界索引+右边边界索引 和的平均值
            int m = (int) (double) ((i + j) / 2);
            //中间值比目标值大
            if (target < arr[m]) {
                //目标在左边
                //说明中间值右边的都不满足找出target的元素了
                j = m-1;
                //这里为什么不是j=m 是因为j=m 是 target = arr[m]的情况
            }else if (arr[m] < target ){
                //目标在右边
                //中间值比目标值小  那么左边的肯定不能满足找出target的元素了
                i = m +1;
            }else {
                //刚好中间值等于目标值了
                return m;
            }
        }
        return -1;
    }

}
