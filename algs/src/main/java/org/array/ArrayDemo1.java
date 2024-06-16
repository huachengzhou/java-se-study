package org.array;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author : chengdu
 * @date :  2024/6/15-06
 **/
public class ArrayDemo1 {

    @Test
    public void test1() {

        int[][] arr = {};


    }

    @Test
    public void test2() {

        int[] arr = new int[]{2,3,4,6} ;
        int[] newArr = new int[20] ;

        System.arraycopy(arr,0,newArr,0,arr.length);

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(newArr));


    }


}
