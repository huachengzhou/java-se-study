package org.sort;

import array.ToArray;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class SortTest {
    //    int[] arr = ToArray.getToArray().setSize(100000).setStart(1).setEnd(1000000).toIntArray();
    int[] arr = ToArray.toFinalArray();
    long start = 0;

    @Before
    public void start() {
        start = System.currentTimeMillis();
    }

    @Test
    public void testBubbleSort() {
        System.out.println(Arrays.toString(arr));
        arr = BubbleSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void testSelectSort() {
        System.out.println(Arrays.toString(arr));
        arr = SelectSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void testInsertSort() {
        System.out.println(Arrays.toString(arr));
        arr = InsertSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void testMergeSort() {
        System.out.println(Arrays.toString(arr));
        MergeSort.mergeSort(arr, 0, 1);
        System.out.println(Arrays.toString(arr));
    }

    @After
    public void end() {
        long time = System.currentTimeMillis() - start;
        System.out.println("time:" + (time / 1000));
        System.out.println("time:" + time);
    }

}
