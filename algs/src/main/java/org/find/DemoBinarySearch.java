package org.find;

public class DemoBinarySearch {

    /**
     * 右二分查找
     *
     * @param arr
     * @param target
     * @return 找到返回正整数没找到返回负整数
     */
    public static int rightMostBinarySearch(int[] arr, int target) {
        int i = 0;
        int j = arr.length - 1;
        //i-j 范围内元素
        while (i <= j) {
            //移位运算 右移1位
            int mid = (i + j) >>> 1;
            //目标值在左边
            if (target < arr[mid]) {
                j = mid - 1;
                //目标值在右边
            } else if (arr[mid] <= target) {
                i = mid + 1;
            }
        }
        //没找到返回最近的索引并且强行取负
        return target == arr[i - 1] ? i - 1 : -(i - 1);
    }

    /**
     * 右二分查找
     *
     * @param arr
     * @param target
     * @return 找到返回正整数没找到返回负整数
     */
    public static int rightMostBinarySearch1(int[] arr, int target) {
        int i = 0;
        int j = arr.length - 1;
        int candidate = -1;
        //i-j 范围内元素
        while (i <= j) {
            //移位运算 右移1位
            int mid = (i + j) >>> 1;
            //目标值在左边
            if (target < arr[mid]) {
                j = mid - 1;
                //目标值在右边
            } else if (arr[mid] < target) {
                i = mid + 1;
            } else {
                //把找到的索引存下来 记录候选位置
                candidate = mid;
                //继续往右边找
                i = mid + 1;
            }
        }
        //没找到返回最近的索引并且强行取负
        return candidate == -1 ? -i : candidate;
    }

    /**
     * 左二分查找
     *
     * @param arr
     * @param target
     * @return 找到返回正整数没找到返回负整数
     */
    public static int leftMostBinarySearch1(int[] arr, int target) {
        int i = 0;
        int j = arr.length - 1;
        int candidate = -1;
        //i-j 范围内元素
        while (i <= j) {
            //移位运算 右移1位
            int mid = (i + j) >>> 1;
            //目标值在左边
            if (target < arr[mid]) {
                j = mid - 1;
                //目标值在右边
            } else if (arr[mid] < target) {
                i = mid + 1;
            } else {
                //把找到的索引存下来 记录候选位置
                candidate = mid;
                //继续往左边找
                j = mid - 1;
            }
        }
        //没找到返回最近的索引并且强行取负
        return candidate == -1 ? -i : candidate;
    }

    /**
     * 左二分查找
     *
     * @param arr
     * @param target
     * @return 找到返回正整数没找到返回负整数
     */
    public static int leftMostBinarySearch(int[] arr, int target) {
        int i = 0;
        int j = arr.length - 1;
        //i-j 范围内元素
        while (i <= j) {
            //移位运算 右移1位
            int mid = (i + j) >>> 1;
            //目标值在左边
            if (target <= arr[mid]) {
                j = mid - 1;
                //目标值在右边
            } else if (arr[mid] < target) {
                i = mid + 1;
            }
        }
        //没找到返回最近的索引并且强行取负
        return target == arr[i] ? i : -i;
    }


    /**
     * 标准二分基础查找
     *
     * @param arr
     * @param target
     * @return 找到返回正整数没找到返回-1
     */
    public static int binarySearch(int[] arr, int target) {
        int i = 0, j = arr.length - 1;
        while (i <= j) {
            //改动处  防止int溢出情况 或者 (int) (((long)i + (long)j) /2)
            int mid = (i + j) >>> 1;
            //目标在左边 必然 目标值必须小于中心位置值
            if (arr[mid] > target) {
                //因此右边边界移动到mid位置处
                j = mid - 1;
                //目标在右边
            } else if (arr[mid] < target) {
                i = mid + 1;
            } else {
                //找到情况
                return mid;
            }
        }
        return -1;
    }


    /**
     * 二分查找 初次学习
     *
     * @param arr    升序数组
     * @param target 目标值
     * @return 找到返回正整数没找到返回-1
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
                j = m - 1;
                //这里为什么不是j=m 是因为j=m 是 target = arr[m]的情况
            } else if (arr[m] < target) {
                //目标在右边
                //中间值比目标值小  那么左边的肯定不能满足找出target的元素了
                i = m + 1;
            } else {
                //刚好中间值等于目标值了
                return m;
            }
        }
        return -1;
    }

}
