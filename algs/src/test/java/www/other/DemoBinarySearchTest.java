package www.other;

import array.ToArray;
import org.find.DemoBinarySearch;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 二分查找demo
 */
public class DemoBinarySearchTest {

    @Test
    public void test1(){
        int[] intArray = new int[] {6, 13, 16, 22, 24, 32, 40, 53, 61, 74, 94, 95, 97, 97, 99} ;
        int target = 95;
        int index = DemoBinarySearch.binarySearch1(intArray, target);
        System.out.println(intArray[index]);
        Assert.assertEquals("不相等", intArray[index], target);
    }

}
