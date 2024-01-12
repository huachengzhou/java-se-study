package org.sort;

/**
 * @author zhou
 * 冒泡排序
 */
public class BubbleSort {

    public static int[] sort(int[] arr) {
        int temp;
        for (int i = arr.length - 1; i > 0; i--) {// 趟数  (第一次选出最大的)
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}
